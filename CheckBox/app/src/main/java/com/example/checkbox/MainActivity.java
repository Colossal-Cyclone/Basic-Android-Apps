package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CheckBox mom;
    private CheckBox dad;
    private CheckBox sis;

    private Button butt;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mom = (CheckBox) findViewById(R.id.b1);
        dad = (CheckBox) findViewById(R.id.b2);
        sis = (CheckBox) findViewById(R.id.b3);
        butt = (Button) findViewById(R.id.button);
        result = (TextView) findViewById(R.id.result);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder build = new StringBuilder();
                build.append(mom.getText().toString() + " Status is "+mom.isChecked()+"\n");
                build.append(dad.getText().toString() + " Status is "+dad.isChecked()+"\n");
                build.append(sis.getText().toString() + " Status is "+sis.isChecked()+"\n");
                result.setText(build);
            }
        });
    }
}
