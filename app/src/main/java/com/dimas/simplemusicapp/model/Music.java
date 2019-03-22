package com.dimas.simplemusicapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Music implements Parcelable {

    private String singer;

    private String song;

    private int album;

    private int music;

    public Music(String singer, String song, int album, int music) {
        this.singer = singer;
        this.song = song;
        this.album = album;
        this.music = music;
    }

    protected Music(Parcel in) {
        singer = in.readString();
        song = in.readString();
        album = in.readInt();
        music = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(singer);
        dest.writeString(song);
        dest.writeInt(album);
        dest.writeInt(music);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Music> CREATOR = new Creator<Music>() {
        @Override
        public Music createFromParcel(Parcel in) {
            return new Music(in);
        }

        @Override
        public Music[] newArray(int size) {
            return new Music[size];
        }
    };

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public int getAlbum() {
        return album;
    }

    public void setAlbum(int album) {
        this.album = album;
    }

    public int getMusic() {
        return music;
    }

    public void setMusic(int music) {
        this.music = music;
    }
}
