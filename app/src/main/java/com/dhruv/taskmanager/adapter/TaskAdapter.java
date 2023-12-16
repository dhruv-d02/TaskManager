package com.dhruv.taskmanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dhruv.taskmanager.R;
import com.dhruv.taskmanager.TaskData;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    LayoutInflater layoutInflater;
    List<TaskData> taskDataList;

    public TaskAdapter(Context context, List<TaskData> taskDataList){
        layoutInflater = LayoutInflater.from(context);
        this.taskDataList = taskDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.task_custom_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.taskTitle.setText(taskDataList.get(position).getTaskTitle());
        holder.taskDescription.setText(taskDataList.get(position).getTaskDescription());

    }

    @Override
    public int getItemCount() {
        return taskDataList.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{

        TextView taskTitle, taskDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            taskTitle = itemView.findViewById(R.id.taskTitle);
            taskDescription = itemView.findViewById(R.id.taskDescription);
        }
    }
}
