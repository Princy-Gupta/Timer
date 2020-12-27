package com.example.timers;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public void uptime(int i) {
        int min = (int) i / 60;
        int sec = i - min * 60;
        String mins= Integer.toString(min);
        String seconds = Integer.toString(sec);
        if (sec <= 9) {
            seconds = "0" + seconds;

        }
        if(min<=9)
        {
            mins = "0" + mins;
        }
        tt.setText(mins + ":" + seconds);
    }

    SeekBar sb;
    TextView tt;
    Boolean slider = false;
    Button b;
    CountDownTimer c;
    public void  rt()
    {
        tt.setText("00:30");
        sb.setProgress(30);
        c.cancel();
        b.setText("Start");
        sb.setEnabled(true);
        slider =false;
    }

    public void func(View view) {
        if (slider == false){
            slider = true;
        sb.setEnabled(false);
        b.setText("Stop");
       c= new CountDownTimer(sb.getProgress() * 1000 + 100, 1000) {
            @Override
            public void onTick(long l) {
                uptime((int) l / 1000);
            }

            @Override
            public void onFinish() {
                rt();

                MediaPlayer mp = (MediaPlayer.create(getApplicationContext(), R.raw.sound));
                mp.start();

            }
        }.start();
    }
        else
        {
           rt();
        }

}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb= (SeekBar)findViewById(R.id.timersb);
         tt= (TextView) findViewById(R.id.text1);
        b= (Button)findViewById(R.id.button1);
        sb.setMax(600);
        sb.setProgress(30);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

uptime(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {

            }



//        final Handler handle= new Handler();
//        Runnable run = new Runnable() {
//            @Override
//            public void run() {
//         handle.postDelayed(this,1000)
//            }
//        };
//        handle.post(run);
        }.start();
    }
}