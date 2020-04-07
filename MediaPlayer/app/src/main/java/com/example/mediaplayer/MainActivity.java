package com.example.mediaplayer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.SimpleDateFormat;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer mediaPlayer;

    private ImageView artistImage;

    private TextView leftTime;

    private TextView rightTime;

    private SeekBar seekBar;

    private Button prevButton;

    private Button playButton;

    private Button nextButton;

    private Thread thread;





    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        setUpUI();



        seekBar.setMax(mediaPlayer.getDuration());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {



                if (fromUser) {

                    mediaPlayer.seekTo(progress);

                }



                SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");

                int currentPos = mediaPlayer.getCurrentPosition();

                int duration = mediaPlayer.getDuration();





                //leftTime.setText(String.valueOf(new java.text.SimpleDateFormat("mm:ss").format(new Date(mediaPlayer.getCurrentPosition()))));
                leftTime.setText(milliSecondsToTimer(mediaPlayer.getCurrentPosition()));


                //rightTime.setText(String.valueOf(new java.text.SimpleDateFormat("mm:ss").format(new Date(mediaPlayer.getDuration() - mediaPlayer.getCurrentPosition()))));
                rightTime.setText(milliSecondsToTimer(mediaPlayer.getDuration() - mediaPlayer.getCurrentPosition()));




            }



            @Override

            public void onStartTrackingTouch(SeekBar seekBar) {



            }



            @Override

            public void onStopTrackingTouch(SeekBar seekBar) {



            }

        });

    }





    public void setUpUI() {



        mediaPlayer = new MediaPlayer();

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.arrivalofthebirds);



        artistImage = (ImageView) findViewById(R.id.imageView);

        leftTime = (TextView) findViewById(R.id.lefttime);

        rightTime = (TextView) findViewById(R.id.righttime);

        seekBar = (SeekBar) findViewById(R.id.progress);

        prevButton = (Button) findViewById(R.id.prev);

        playButton = (Button) findViewById(R.id.play);

        nextButton = (Button) findViewById(R.id.next);



        prevButton.setOnClickListener(this);

        playButton.setOnClickListener(this);

        nextButton.setOnClickListener(this);





    }



    @Override

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.prev:

                backMusic();





                break;



            case R.id.play:

                if (mediaPlayer.isPlaying()) {

                    pauseMusic();

                } else {

                    startMusic();

                }



                break;



            case R.id.next:

                nextMusic();



                break;

        }



    }



    public void pauseMusic() {

        if (mediaPlayer != null) {

            mediaPlayer.pause();

            playButton.setBackgroundResource(android.R.drawable.ic_media_play);



        }



    }



    public void startMusic() {

        if (mediaPlayer != null) {

            mediaPlayer.start();

            updateThread();

            playButton.setBackgroundResource(android.R.drawable.ic_media_pause);

        }



    }





    public void backMusic() {

        if (mediaPlayer.isPlaying()) {

            //for now

            mediaPlayer.seekTo(0);

        }

    }



    public void nextMusic() {

        if (mediaPlayer.isPlaying()) {

            mediaPlayer.seekTo(mediaPlayer.getDuration());

        }

    }



    public void updateThread() {



        thread = new Thread() {

            @Override

            public void run() {



                try {



                    while (mediaPlayer != null && mediaPlayer.isPlaying()) {





                        Thread.sleep(50);

                        runOnUiThread(new Runnable() {

                            @Override

                            public void run() {

                                int newPosition = mediaPlayer.getCurrentPosition();

                                int newMax = mediaPlayer.getDuration();

                                seekBar.setMax(newMax);

                                seekBar.setProgress(newPosition);



                                //update the text





                                //leftTime.setText(String.valueOf(new java.text.SimpleDateFormat("mm:ss").format(new Date(mediaPlayer.getCurrentPosition()))));
                                leftTime.setText(milliSecondsToTimer(mediaPlayer.getCurrentPosition()));


                                //rightTime.setText(String.valueOf(new java.text.SimpleDateFormat("mm:ss").format(new Date(mediaPlayer.getDuration() - mediaPlayer.getCurrentPosition()))));
                                rightTime.setText(milliSecondsToTimer(mediaPlayer.getDuration() - mediaPlayer.getCurrentPosition()));



                            }

                        });

                    }



                } catch (InterruptedException e) {

                    e.printStackTrace();

                }

            }

        };

        thread.start();



    }
    public  String milliSecondsToTimer(long milliseconds) {
        String finalTimerString = "";
        String secondsString = "";

        // Convert total duration into time
        int hours = (int) (milliseconds / (1000 * 60 * 60));
        int minutes = (int) (milliseconds % (1000 * 60 * 60)) / (1000 * 60);
        int seconds = (int) ((milliseconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);
        // Add hours if there
        if (hours > 0) {
            finalTimerString = hours + ":";
        }

        // Prepending 0 to seconds if it is one digit
        if (seconds < 10) {
            secondsString = "0" + seconds;
        } else {
            secondsString = "" + seconds;
        }

        finalTimerString = finalTimerString + minutes + ":" + secondsString;

        // return timer string
        return finalTimerString;
    }


    @Override

    protected void onDestroy() {

        if (mediaPlayer != null && mediaPlayer.isPlaying()) {

            mediaPlayer.stop();

            mediaPlayer.release();

            mediaPlayer = null;

        }



        thread.interrupt();

        thread = null;

        super.onDestroy();

    }

}
