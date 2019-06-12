package com.intellinects.intelliquiz.ExpandedList_Demo;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.intellinects.intelliquiz.R;
import com.intellinects.intelliquiz.model.Leaderboard_Final_curriculum;

import java.util.ArrayList;

public class MyCustomAdapter extends BaseExpandableListAdapter {


    private LayoutInflater inflater;
    private ArrayList<Leaderboard_Final_curriculum> mParent;
    String subject_code;
    public MyCustomAdapter(Context context, ArrayList<Leaderboard_Final_curriculum> parent){
        mParent = parent;
        inflater = LayoutInflater.from(context);
    }


    @Override
    //counts the number of group/parent items so the list knows how many times calls getGroupView() method
    public int getGroupCount() {
        return mParent.size();
    }

    @Override
    //counts the number of children items so the list knows how many times calls getChildView() method
    public int getChildrenCount(int i) {
        return mParent.get(i).getFinal_curriculumArrayList_details().size();
    }

    @Override
    //gets the title of each parent/group
    public Object getGroup(int i) {
        return mParent.get(i).getSubject_name();
    }

    @Override
    //gets the name of each item
    public Object getChild(int i, int i1) {
        return mParent.get(i).getFinal_curriculumArrayList_details().get(i1).getChapterTitle();
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    //in this method you must set the text to see the parent/group on the list
    public View getGroupView(int groupPosition, boolean b, View view, ViewGroup viewGroup) {

        ViewHolder holder = new ViewHolder();
        holder.groupPosition = groupPosition;

        if (view == null) {
            view = inflater.inflate(R.layout.list_item_parent, viewGroup,false);
        }

        TextView textView = (TextView) view.findViewById(R.id.list_item_text_view);
        textView.setText(getGroup(groupPosition).toString());
          subject_code = getGroup(groupPosition).toString();
        //Log.e("ME","parent subject id: "+mParent.get(groupPosition).getSubject_code());
       // Log.e("ME","parent subject name : "+mParent.get(groupPosition).getSubject_name());

        view.setTag(holder);

        //return the entire view
        return view;
    }

    @Override
    //in this method you must set the text to see the children on the list
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup viewGroup) {

        ViewHolder holder = new ViewHolder();
        holder.childPosition = childPosition;
        holder.groupPosition = groupPosition;

        if (view == null) {
            view = inflater.inflate(R.layout.list_item_child, viewGroup,false);
        }
        Log.e("ME", "child id : " + mParent.get(groupPosition).getFinal_curriculumArrayList_details().get(childPosition).getSubject_name());
        Log.e("ME", "subject_code id : " +getGroup(groupPosition).toString());

        TextView textView = (TextView) view.findViewById(R.id.list_item_text_child);
//        if (mParent.get(groupPosition).getFinal_curriculumArrayList_details().get(childPosition).getSubject_name().equals(subject_code))
//        textView.setText(mParent.get(groupPosition).getFinal_curriculumArrayList_details().get(childPosition).getChapterTitle());
//        {
            textView.setText(mParent.get(groupPosition).getFinal_curriculumArrayList_details().get(childPosition).getChapterTitle());

//        }else{
//            textView.setText("");
//        }
        view.setTag(holder);

        //return the entire view
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        /* used to make the notifyDataSetChanged() method work */
        super.registerDataSetObserver(observer);
    }

// Intentionally put on comment, if you need on click deactivate it
   /*  @Override
    public void onClick(View view) {
        ViewHolder holder = (ViewHolder)view.getTag();
        if (view.getId() == holder.button.getId()){

           // DO YOUR ACTION
        }
    }*/


    protected class ViewHolder {
        protected int childPosition;
        protected int groupPosition;
        protected Button button;
    }
}
