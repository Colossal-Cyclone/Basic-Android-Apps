package com.example.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter;
import Model.ListItem;

public class MainActivity extends AppCompatActivity {
    private RecyclerView reciclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reciclerView = (RecyclerView) findViewById(R.id.reciclerView);
        reciclerView.setHasFixedSize(true);
        //every item has a fixed size
        reciclerView.setLayoutManager(new
                LinearLayoutManager(this));

        listItems = new ArrayList<>();

        for (int i = 0; i<10; i++) {
            ListItem listItem = new ListItem(
                    "Item " + (i+1),
                    "Description"
            );
            listItems.add(listItem);
        }

        adapter = new MyAdapter(this, listItems);

        reciclerView.setAdapter(adapter);


    }
}
