# Pre-work - Simple Todo App

Simple Todo  is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: Shahroon Farooqi

Time spent: 1 and a half hours spent in total

* [Done]  User can successfully add and remove items from the todo list
* [Done] User can  tap a todo item in the list and bring up an edit screen for the todo item  and then have any changes to the text reflected in the todo list.
* [Done ] User can  persist todo items  and retrieve them properly on app restart


## Video Walkthrough
[Link to Video walkthrough] (https://www.dropbox.com/s/gh34klz3v4tnn7t/2017_08_04_23_18_53.mp4?dl=0)


**Question 1:** "What are your reactions to the Android app development platform so far? Compare and contrast Android's approach to layouts and user interfaces in past platforms you've used."

Answer: As with User Interfaces stuff I am not that good with it. I Am pretty good with logic and implementation  part.


Question 2:"Take a moment to reflect on the `ArrayAdapter` used in your pre-work. How would you describe an adapter in this context and what is its function in Android? Why do you think the adapter is important? Explain the purpose of the `convertView` in the `getView` method of the `ArrayAdapter`."

Answer: Well ArrayAdapter is the simplest adapter out there.  

The ArrayAdapter fits in between an ArrayList (data source) and the ListView (visual representation) and configures two aspects:
•	Which array to use as the data source for the list
•	How to convert any given item in the array into a corresponding View object

Importance of Adapter: 

Without Adapter, to implement the ListView functionality, we will need to:
•	Create a TextView within a ScrollView group.
•	Then we will have to implement pagination concept for the contents of the TextView.
•	We will also have to write additional code to identify the click event on a particular row in the TextView.

Purpose of ConvertView in getView:

ConvertView is used strictly to increase the performance of our Adapter. When a ListView uses an Adapter to fill its rows with Views, the adapter populates each list item with a View object by calling getView() on each row. The Adapter uses the convertView as a way of recycling old View objects that are no longer being used. In this way, the ListView can send the Adapter old, "recycled" view objects that are no longer being displayed instead of instantiating an entirely new object each time the Adapter wants to display a new list item. This is the purpose of the convertView parameter.


Describe any challenges encountered while building the app:

Getting result back from edit item activity and then inserting the updated todo text for the item at the correct position in the array was challenging to me.

## License

    Copyright [2017] [Shahroon Farooqi]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
