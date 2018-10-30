package com.example.kccistc.sitezip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class PlayYoutube extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{

    String videoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_youtube);

        YouTubePlayerView player = findViewById(R.id.youtube_player);
        player.initialize("AIzaSyAiL-zs1TQFlMVXVg0LS4It2fejRDn29hE", this);

        Intent intent = getIntent();
        videoId = intent.getStringExtra("video");
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo(videoId);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Log.e("youtube", "Initialization Fail");
    }
}
