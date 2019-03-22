package com.dimas.simplemusicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.dimas.simplemusicapp.adapter.ListMusicAdapter;
import com.dimas.simplemusicapp.model.Music;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListMusicAdapter.OnListMusicListener {

    private RecyclerView rvMusic;

    private ListMusicAdapter adapter;

    private ArrayList<Music> musics;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMusic = findViewById(R.id.rv_music);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.label_music_app);


        musics = new ArrayList<>();
        musics.add(new Music("Maroon 5", "Animal", R.drawable.animal, R.raw.maroon5_animals));
        musics.add(new Music("Maroon 5", "Girls Like You", R.drawable.girls_like_you, R.raw.maroon5_girls_like_you));
        musics.add(new Music("Maroon 5", "This Love", R.drawable.this_love, R.raw.maroon5_this_love));
        musics.add(new Music("Maroon 5", "Payphone", R.drawable.payphone, R.raw.maroon5_payphone));


        adapter = new ListMusicAdapter(this, musics);
        adapter.setListener(this);
        rvMusic.setLayoutManager(new GridLayoutManager(this, 2));
        rvMusic.setHasFixedSize(true);
        rvMusic.setAdapter(adapter);

    }

    @Override
    public void onItemClick(Music data) {
        MusicDetailActivity.start(this, data);
    }
}
