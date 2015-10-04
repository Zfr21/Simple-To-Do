package com.celaloglu.zafer.simpletodo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.celaloglu.zafer.simpletodo.R;
import com.celaloglu.zafer.simpletodo.adapters.ToDoListAdapter;

import managers.DatabaseManager;

public class MainActivity extends AppCompatActivity {

    private DatabaseManager databaseManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
         databaseManager = new DatabaseManager(this);
        ToDoListAdapter adapter = new ToDoListAdapter(databaseManager.getAllTitles());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


        //DELETE ITEM FROM DB
        /*ToDoItem toDoItem = databaseManager.getInfo(1).get(7);
        databaseManager.deleteInfo(toDoItem);*/

        //POPULATE DATABASE
        /*for (int i = 0; i < 10; i++) {
            ToDoTitle toDoTitle = new ToDoTitle();
            toDoTitle.setTitle("Title " + i);
            databaseManager.addTitle(toDoTitle);
            for (int j = 0; j < 10; j++) {
                ToDoTitle toDoTitle1 = databaseManager.getAllTitles().get(i);
                ToDoItem item = new ToDoItem();
                item.setId(toDoTitle1.getId());
                item.setMessage("Message " + j);
                item.setIsChecked(new Random().nextBoolean());
                databaseManager.addInfo(item);
            }
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}