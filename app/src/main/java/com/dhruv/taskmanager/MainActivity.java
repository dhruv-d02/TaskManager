package com.dhruv.taskmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.dhruv.taskmanager.adapter.TaskAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TaskAdapter taskAdapter;
    private ArrayList<TaskData> taskDataList = new ArrayList<>();
    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TaskData taskData1 = new TaskData("Task1", "Task1");
        TaskData taskData2 = new TaskData("Task2", "Task2");
        TaskData taskData3 = new TaskData("Task3", "Task3");
        TaskData taskData4 = new TaskData("Task4", "Task4");
        TaskData taskData5 = new TaskData("Task5", "Task5");
        taskDataList.add(taskData1);
        taskDataList.add(taskData2);
        taskDataList.add(taskData3);
        taskDataList.add(taskData4);
        taskDataList.add(taskData5);
        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.fab);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter = new TaskAdapter(this, taskDataList);
        recyclerView.setAdapter(taskAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskData taskData6 = new TaskData("Task6", "Task6");
                taskDataList.add(taskData6);
                taskAdapter = new TaskAdapter(getApplicationContext(), taskDataList);
                recyclerView.setAdapter(taskAdapter);
                Toast.makeText(getApplicationContext(), "Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}