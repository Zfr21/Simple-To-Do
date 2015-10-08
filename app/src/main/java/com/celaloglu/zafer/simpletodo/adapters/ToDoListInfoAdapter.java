package com.celaloglu.zafer.simpletodo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.celaloglu.zafer.simpletodo.R;
import com.celaloglu.zafer.simpletodo.models.ToDoItem;

import java.util.List;

import managers.DatabaseManager;

/**
 * Created by zafer on 6.10.15.
 */
public class ToDoListInfoAdapter extends RecyclerView.Adapter<ToDoListInfoAdapter.ViewHolder>{

    public ToDoListInfoAdapter(DatabaseManager databaseManager, List<ToDoItem> toDoItems) {
        this.databaseManager = databaseManager;
        this.toDoItems = toDoItems;
    }

    List<ToDoItem> toDoItems;
    DatabaseManager databaseManager;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.message.setText(toDoItems.get(position).getMessage());
        holder.checkBox.setChecked(toDoItems.get(position).isChecked());
    }

    @Override
    public int getItemCount() {
        return toDoItems.size();
    }
    public void setData(List<ToDoItem> items){this.toDoItems = items;}

    public class ViewHolder extends RecyclerView.ViewHolder implements CompoundButton.OnCheckedChangeListener{

        private TextView message;
        private CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            message = (TextView) itemView.findViewById(R.id.text);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
            checkBox.setOnCheckedChangeListener(this);
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            int position = getAdapterPosition();
            toDoItems.get(position).setIsChecked(isChecked);
            databaseManager.changeChecked(toDoItems.get(position), isChecked);
        }
    }
}
