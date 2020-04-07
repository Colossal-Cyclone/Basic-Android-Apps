package com.example.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private TextView name, description;
    private Bundle extras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        extras=getIntent().getExtras();

        name=(TextView) findViewById(R.id.d1);
        description=(TextView) findViewById(R.id.d2);
        if(extras!=null){
            name.setText(extras.getString("name"));
            description.setText(extras.getString("description"));
        }
    }
}
