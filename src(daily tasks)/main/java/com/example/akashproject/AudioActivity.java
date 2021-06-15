package com.example.akashproject;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AudioActivity extends AppCompatActivity {

    ImageView playBtn, pauseBtn, stopbtn;
    MediaPlayer mediaPlayer;

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        playBtn = findViewById(R.id.play_btn);
        pauseBtn = findViewById(R.id.pause_btn);
        stopbtn = findViewById(R.id.stop_btn);

        mediaPlayer = MediaPlayer.create(AudioActivity.this, R.raw.audio_file);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });

        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
            }
        });
    }
}