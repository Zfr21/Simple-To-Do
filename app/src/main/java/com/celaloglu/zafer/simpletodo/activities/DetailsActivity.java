package com.celaloglu.zafer.simpletodo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.celaloglu.zafer.simpletodo.R;
import com.celaloglu.zafer.simpletodo.adapters.ToDoListInfoAdapter;
import com.celaloglu.zafer.simpletodo.models.ToDoItem;

import java.util.List;

import managers.DatabaseManager;

/**
 * Created by zafer on 4.10.15.
 */
public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int id = getIntent().getExtras().getInt("ID");

        DatabaseManager databaseManager = new DatabaseManager(this);
        List<ToDoItem> toDoItems = databaseManager.getInfo(id);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new ToDoListInfoAdapter(databaseManager, toDoItems));
    }
}
