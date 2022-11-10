package com.songrJRut.songr.albums;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String title;
    private String artist;
    private int songCount;

    @OneToMany(mappedBy = "album") List<Song> songList;
    private int lengthInSeconds;
    private String imageUrl;

    public Album(){};

    public Album(String artist, String title){
        this.artist = artist;
        this.title = title;
        this.songCount = 1;
        this.lengthInSeconds = 10;
        this.imageUrl = "UhOh!";
    }
    public Album(String title, String artist, int songCount, int lengthInSeconds, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.lengthInSeconds = lengthInSeconds;
        this.imageUrl = imageUrl;
    }

    public String albumString(){
        return getArtist() + getTitle() + getSongCount() + getLengthInSeconds() + getImageUrl();
    }

    public List<Song> getSongList() {return songList;}

    public void setSongList(List<Song> songList) {this.songList = songList;}

    public Long getId() {return id;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public void setLengthInSeconds(int lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
