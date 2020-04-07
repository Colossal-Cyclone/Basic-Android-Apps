package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private SeekBar bar;
    private TextView result;
    private EditText amt;
    private Button calc;
    private TextView percent;
    private int seekBarpercentage;
    private float enteredamt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = (SeekBar) findViewById(R.id.seekBar);
        result = (TextView) findViewById(R.id.result);
        calc = (Button) findViewById(R.id.button);
        amt = (EditText) findViewById(R.id.amt);
        percent = (TextView) findViewById(R.id.percentage);

        calc.setOnClickListener(this);

        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percent.setText(String.valueOf(bar.getProgress())+" %");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBarpercentage = bar.getProgress();
            }
        });
    }

    @Override
    public void onClick(View v) {
        calc();

    }
    public void calc(){
        float resultn = 0.0f;
        if(amt.getText().toString() !="") {
            enteredamt = Float.parseFloat(amt.getText().toString());
            resultn = enteredamt*seekBarpercentage/100;
            float total_bill = resultn + enteredamt;
            result.setText("Your tip will be $"+ String.valueOf(resultn)+"\n"+"Your total bill be $"+String.valueOf(total_bill));
        }
        else{
            Toast.makeText(MainActivity.this, "Please enter a bill amount", Toast.LENGTH_SHORT).show();
        }
    }
}
