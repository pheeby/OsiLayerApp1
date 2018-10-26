package com.phoebewong.osilayerapp1;

import android.os.Bundle;
import android.media.session.PlaybackState;
import android.support.constraint.ConstraintLayout;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.Toast;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;
import android.graphics.Bitmap.Config;
import android.widget.Button;

public class PlayVideo1 extends YouTubeBaseActivity {

    private static final String TAG = "videoPlay";

    YouTubePlayerView mYoutubePlayerView;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;
    Button btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video1);

        //when button is clicked, the loaded video will play
        //it also prints the string msg in Log.d to ensure the system is loading correctly

        Log.d(TAG, "OnCreate: Starting.");
        mYoutubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlay);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "onClick: Done initializing");

                youTubePlayer.loadVideo("qSk5SLrg7Yg");
            }

            @Override
            public void onInitializationFailure(Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "fail to initialise");
            }
        };

        //the API key is coded with this appilication's SHA1 to ensure we have access
        //to the youtube API and can play the video from this application

        btnPlay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d(TAG, "OnClick: Initializing Youtube Player.");
                mYoutubePlayerView.initialize("AIzaSyCHbf1ZPDeYJfwA0fkVISCarRdiY812zmk", mOnInitializedListener);

            }
        });

    }
}