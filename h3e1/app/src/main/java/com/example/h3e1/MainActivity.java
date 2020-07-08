package com.example.h3e1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar sb=findViewById(R.id.seekBar);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekbar, int progress, boolean fromUser) {
                Log.v("拖动过程中的值：", progress + ", " + fromUser);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekbar) {
                Log.v("开始滑动时的值：", String.valueOf(seekbar.getProgress()));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekbar) {
                Log.v("停止滑动时的值：", String.valueOf(seekbar.getProgress()));
                int progress=seekbar.getProgress();
                LottieAnimationView lv=findViewById(R.id.animator_view);
                lv.setProgress((float)(progress)/100);
            }
        });

    }
}