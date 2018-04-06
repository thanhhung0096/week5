package com.tran.huunghia.exerciseweek5;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements PassValue{

    FloatingActionButton btnAdd;
    List<Task> myTask;
    RecyclerView recyclerView;
    Dialog dialog;
    TaskAdapter taskAdapter;
    TaskDialog taskDialog;
    Task mtask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        btnAdd = (FloatingActionButton) findViewById(R.id.addTodo);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        myTask = new ArrayList<>();
        //myTask.add(new Task("abc","cde"));
        taskAdapter = new TaskAdapter(getApplicationContext(), myTask);
        recyclerView.setAdapter(taskAdapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

    }
    public void openDialog(){
        taskDialog = new TaskDialog();
        taskDialog.show(getFragmentManager(),"aab");
    }

    @Override
    public void openDialog(String name, String priority,String date) {
        myTask.add(new Task(name,priority,date));
        taskAdapter.notifyDataSetChanged();
        recyclerView.smoothScrollToPosition(taskAdapter.getItemCount());
    }
}
