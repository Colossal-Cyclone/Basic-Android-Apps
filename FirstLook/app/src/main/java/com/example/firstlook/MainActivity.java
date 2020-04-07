package com.example.firstlook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    private Button mButton;
    private TextView mText;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstancesState){
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_main);
        mEditText = (EditText) findViewById(R.id.editText);
        mButton = (Button) findViewById(R.id.MyButton);
        mButton.setText(R.string.button);
        mText = (TextView) findViewById((R.id.mText));
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredText;
                enteredText = mEditText.getText().toString();
                mText.setVisibility(View.VISIBLE);
                mText.setText(enteredText);
            }
        });
    }
//    public void ShowMe(View view){
//        mText.setVisibility(View.VISIBLE);
//        mText.setText(R.string.show_text);
//    }
}
