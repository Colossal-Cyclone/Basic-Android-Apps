package com.example.meterstoinches;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText enterMeters;
    private Button convert;
    private TextView inches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterMeters = (EditText) findViewById(R.id.enterinmeters);
        convert = (Button) findViewById(R.id.convert);
        inches = (TextView) findViewById(R.id.resultid);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double multiplier = 39.37;
                double result = 0.0;
                if (enterMeters.getText().toString().equals("")){
                    inches.setText(R.string.error_message);
                    inches.setTextColor(Color.RED);
                }
                else{
                    double meters =Double.parseDouble(enterMeters.getText().toString());
                    result = multiplier*meters;
                    inches.setVisibility(View.VISIBLE);
                    inches.setTextColor(Color.WHITE);
                    inches.setText(String.format("%.2f",result)+ " inches");
                }


            }
        });
    }
}
