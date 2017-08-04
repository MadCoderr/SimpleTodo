package com.example.farooqi.simpletodo;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 222;
    public static final String ITEM_NAME = "item_name";
    public static final String ITEM_POSITION = "item_position";


    ArrayList<String> todoItems;
    ArrayAdapter<String> aToDoAdapter;
    ListView lvItems;

    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItems = (ListView) findViewById(R.id.lv_item);
        mEditText = (EditText) findViewById(R.id.edt_item);

        populateArrayItems();

        lvItems.setAdapter(aToDoAdapter);
        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                todoItems.remove(position);
                aToDoAdapter.notifyDataSetChanged();
                writeItem();
                return true;
            }
        });

        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, EditItemActivity.class);
                String nameOfItem = (String) adapterView.getItemAtPosition(position);

                intent.putExtra(ITEM_NAME, nameOfItem);
                intent.putExtra(ITEM_POSITION, position);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

    }

    public void populateArrayItems() {
        readItem();
        aToDoAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, todoItems);
    }

    public void onAddItems(View view) {
        String items = mEditText.getText().toString();
        if (!items.equals("") && !items.isEmpty()) {
            aToDoAdapter.add(items);
            mEditText.setText("");
            writeItem();
        }
    }

    private void readItem() {
        File fileDir = getFilesDir();
        File file = new File(fileDir, "todo.txt");


        try {
            todoItems = new ArrayList<>(FileUtils.readLines(file));
        } catch (FileNotFoundException e) {
            todoItems = new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeItem() {
        File fileDir = getFilesDir();
        File file = new File(fileDir, "todo.txt");


        try {
            FileUtils.writeLines(file, todoItems);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String itemName = data.getStringExtra(EditItemActivity.NEW_ITEM_NAME);
                int itemPosition = data.getIntExtra(EditItemActivity.NEW_ITEM_POSITION, 0);
                todoItems.set(itemPosition, itemName);
                aToDoAdapter.notifyDataSetChanged();
                writeItem();
            }
        }
    }
}
