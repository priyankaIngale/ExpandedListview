package com.intellinects.intelliquiz.ExpandedList_Demo;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.intellinects.intelliquiz.R;

import java.util.ArrayList;

public class Main_ExpandList_java extends Activity {
        private ExpandableListView mExpandableList;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);


//            mExpandableList = (ExpandableListView)findViewById(R.id.expandable_list);
//
//            ArrayList<Parent> arrayParents = new ArrayList<Parent>();
//            ArrayList<String> arrayChildren = new ArrayList<String>();
//
//            //here we set the parents and the children
//            for (int i = 0; i < 10; i++){
//                //for each "i" create a new Parent object to set the title and the children
//                Parent parent = new Parent();
//                parent.setTitle("Parent " + i);
//
//                arrayChildren = new ArrayList<String>();
//                for (int j = 0; j < 10; j++) {
//                    arrayChildren.add("Child " + j);
//                }
//                parent.setArrayChildren(arrayChildren);
//
//                //in this array we add the Parent object. We will use the arrayParents at the setAdapter
//                arrayParents.add(parent);
//            }
//
//            //sets the adapter that provides data to the list.
//            mExpandableList.setAdapter(new MyCustomAdapter(Main_ExpandList_java.this,arrayParents));

        }
    }
