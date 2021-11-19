package com.android.guicelebrini.youtubeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity {

    private YouTubePlayerView playerView;

    private YouTubePlayer.PlaybackEventListener eventListener;

    public static final String GOOGLE_API_KEY = "AIzaSyBIkJyyaMXwVcAnr52DM5nAXCOOqh2eFKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewsById();

        eventListener = new YouTubePlayer.PlaybackEventListener() {
            @Override
            public void onPlaying() {

            }

            @Override
            public void onPaused() {

            }

            @Override
            public void onStopped() {

            }

            @Override
            public void onBuffering(boolean b) {

            }

            @Override
            public void onSeekTo(int i) {

            }
        };

        playerView.initialize(GOOGLE_API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasPlaying) {
                Toast.makeText(getApplicationContext(), "Player initialized successfully", Toast.LENGTH_SHORT).show();
                youTubePlayer.setPlaybackEventListener(eventListener);


                if (!wasPlaying) {
                    youTubePlayer.loadPlaylist("PL15FF6F444D5A4B8E");
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(getApplicationContext(), "Player initialization failed - " + youTubeInitializationResult.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void findViewsById() {
        playerView = findViewById(R.id.viewYoutubePlayer);
    }
}