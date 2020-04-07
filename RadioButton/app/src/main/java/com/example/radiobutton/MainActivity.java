package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radiogroup;
    private RadioButton radiobutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radiogroup = (RadioGroup) findViewById(R.id.radiogroup);
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radiobutton = (RadioButton) findViewById(checkedId);
                switch (radiobutton.getId()){
                    case R.id.yes: {
                        if(radiobutton.isChecked())
                        Log.d("RD", "Yes!");
                    }
                    break;
                    case R.id.maybe: {
                        if(radiobutton.isChecked())
                        Log.d("RD","Maybe!");
                    }
                    break;
                    case R.id.no: {
                        if(radiobutton.isChecked())
                        Log.d("RD","No!");
                    }
                    break;
                }
            }
        });
    }
}
