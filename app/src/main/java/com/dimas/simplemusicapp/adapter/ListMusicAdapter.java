package com.dimas.simplemusicapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dimas.simplemusicapp.R;
import com.dimas.simplemusicapp.model.Music;

import java.util.ArrayList;

public class ListMusicAdapter extends RecyclerView.Adapter<ListMusicAdapter.ListMusicViewHolder> {

    private Context context;

    private ArrayList<Music> musics;

    private OnListMusicListener listener;

    public ListMusicAdapter(Context context, ArrayList<Music> musics) {
        this.context = context;
        this.musics = musics;
    }

    public OnListMusicListener getListener() {
        return listener;
    }

    public void setListener(OnListMusicListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ListMusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_music, parent, false);
        return new ListMusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListMusicViewHolder holder, int position) {
        holder.bind(musics.get(position));
    }

    @Override
    public int getItemCount() {
        return musics.size();
    }

    public class ListMusicViewHolder extends RecyclerView.ViewHolder {

        ImageView imgAlbum;

        TextView tvSinger, tvSong;

        LinearLayout itemMusic;

        public ListMusicViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAlbum = itemView.findViewById(R.id.img_album);
            tvSinger = itemView.findViewById(R.id.tv_singer);
            tvSong = itemView.findViewById(R.id.tv_song);
            itemMusic = itemView.findViewById(R.id.item_music);
        }

        public void bind(final Music data) {
            imgAlbum.setImageResource(data.getAlbum());
            tvSong.setText(data.getSong());
            tvSinger.setText(data.getSinger());
            itemMusic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getListener() != null){
                        getListener().onItemClick(data);
                    }
                }
            });
        }
    }

    public interface OnListMusicListener {

        void onItemClick(Music data);

    }
}
