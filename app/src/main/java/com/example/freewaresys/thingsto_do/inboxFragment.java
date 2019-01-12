package com.example.freewaresys.thingsto_do;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class inboxFragment extends Fragment {

    DbHelper dbHelper;

    ArrayAdapter<String> mAdapter;
    ListView lstTask;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        //TextView tb = getActivity().findViewById(R.id.toolbar);
        getActivity().setTitle("INBOX");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setIcon(R.drawable.ic_menu_inbox);



        /*ArrayList<String> todoList = new ArrayList<>();
        todoList.add("item1");
        todoList.add("item2");
        todoList.add("item2");*/
        //String[] todoList = {"aaa","bbb","ccc"};
        //mAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,todoList);


        dbHelper = new DbHelper(getActivity());
        View rootView = inflater.inflate(R.layout.fragment_inbox, container, false);
        lstTask = (ListView) rootView.findViewById(R.id.lstTask);

        //lstTask.setAdapter(mAdapter);

        ArrayList<String> taskList = dbHelper.getTodoList();
        if(mAdapter==null){

            mAdapter = new ArrayAdapter<String>(getActivity(),R.layout.defaut_row_todo,R.id.todo_title,taskList);
            lstTask.setAdapter(mAdapter);
        }
        else{
            mAdapter.clear();
            mAdapter.addAll(taskList);
            mAdapter.notifyDataSetChanged();
        }


        //loadTaskList();



        return rootView;
    }

    private void loadTaskList() {
        ArrayList<String> taskList = dbHelper.getTodoList();
        if(mAdapter==null){
            /*warning*/
            mAdapter = new ArrayAdapter<String>(getActivity(),R.layout.defaut_row_todo,R.id.todo_title,taskList);
            lstTask.setAdapter(mAdapter);
        }
        else{
            mAdapter.clear();
            mAdapter.addAll(taskList);
            mAdapter.notifyDataSetChanged();
        }
    }
}
