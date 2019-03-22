package com.dimas.simplemusicapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.dimas.simplemusicapp.constan.BundleKey;
import com.dimas.simplemusicapp.model.Music;

public class MusicDetailActivity extends AppCompatActivity {

    private ImageButton btnPlay;

    private LottieAnimationView lavIndicatorMusic;

    private Toolbar toolbar;

    private Music music;

    public static void start(Context context, Music music){
        Intent intent = new Intent(context, MusicDetailActivity.class);
        intent.putExtra(BundleKey.KEY_MUSIC, music);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_detail);

        btnPlay = findViewById(R.id.btn_play);
        lavIndicatorMusic = findViewById(R.id.lav_indicator_music);
        toolbar = findViewById(R.id.toolbar);

        initIntentData();

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(String.format("%s - %s", music.getSinger(), music.getSong()));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MusicDetailActivity.this, "klik", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initIntentData() {
        music = getIntent().getParcelableExtra(BundleKey.KEY_MUSIC);
    }

    @Override
    protected void onStart() {
        super.onStart();
        lavIndicatorMusic.setAnimation(R.raw.play_button);
        lavIndicatorMusic.playAnimation();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
