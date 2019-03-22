package com.dimas.simplemusicapp.model;

public class Music {

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
