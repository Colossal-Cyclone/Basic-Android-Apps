package com.example.tryme;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private View background;
    private Button tryme;
    private int[] colours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        background = findViewById(R.id.windowView);
        tryme = (Button) findViewById(R.id.button);
        colours = new int[]{Color.RED ,Color.GRAY,Color.GREEN,Color.BLUE,Color.BLACK,Color.WHITE,Color.YELLOW,Color.CYAN };
        tryme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int randomnum = random.nextInt(colours.length);
                background.setBackgroundColor(colours[randomnum]);
                Log.d("Random",String.valueOf(randomnum));

            }
        });
    }
}
