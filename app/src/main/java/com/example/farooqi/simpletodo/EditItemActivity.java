package com.example.farooqi.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    public static final String NEW_ITEM_NAME = "new_item_name";
    public static final String NEW_ITEM_POSITION = "new_item_pos";

    EditText mEditText;
    int itemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        mEditText = (EditText) findViewById(R.id.edt_new_item);

        Intent intent = getIntent();
        String itemName = intent.getStringExtra(MainActivity.ITEM_NAME);
        itemPosition = intent.getIntExtra(MainActivity.ITEM_POSITION, 0);

        mEditText.setText(itemName);
        mEditText.setSelection(mEditText.getText().length());

    }

    public void onSaveClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        String newItemName = mEditText.getText().toString();

        intent.putExtra(NEW_ITEM_NAME, newItemName);
        intent.putExtra(NEW_ITEM_POSITION, itemPosition);

        setResult(RESULT_OK, intent);
        finish();
    }
}
