package com.example.akashproject;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = findViewById(R.id.videoView);

        MediaController mediaController = new MediaController(VideoActivity.this);

        mediaController.setAnchorView(videoView);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_file);

        videoView.setMediaController(mediaController);

        videoView.setVideoURI(uri);

        videoView.requestFocus();
        videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(VideoActivity.this, "Thanks For Watching...", Toast.LENGTH_SHORT).show();
            }
        });

        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(VideoActivity.this, "Error !!!", Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }
}