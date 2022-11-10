package com.songrJRut.songr.albums;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) Long id;

    private String title;
    private int length;
    private int trackNum;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTrackNum() {
        return trackNum;
    }

    public void setTrackNum(int trackNum) {
        this.trackNum = trackNum;
    }

    @ManyToOne Album album;

    protected Song(){};

    public Song(String title, int length, int trackNum, Album album) {
        this.title = title;
        this.length = length;
        this.trackNum = trackNum;
        this.album = album;
    }


}
