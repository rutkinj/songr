package com.songrJRut.songr.controllers;

import com.songrJRut.songr.albums.Album;
import com.songrJRut.songr.albums.Song;
import com.songrJRut.songr.repository.AlbumRepository;
import com.songrJRut.songr.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Array;
import java.util.List;

@Controller
public class helloController {
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;
    @GetMapping("/")
    public String getSplash(){
        return "splash";
    }

    @GetMapping("/hello")
    public String getHello(){
        return "basic/hello";
    }

    @GetMapping("/capitalize/{wordToCap}")
    public String getCaps(@PathVariable String wordToCap, Model m){
        m.addAttribute("word", wordToCap.toUpperCase());
        return "basic/caps";
    }

// albums

    @GetMapping("/albums")
    public String getTestAlbums(Model m){

//        String albumString = testAlbumDumper();

        List<Album> allAlbums = albumRepository.findAll();

        m.addAttribute("albums", allAlbums);
        return "albums/albums.html";
    }

    @PostMapping("/albums")
    public RedirectView postAlbums(String artist, String title){
        Album newAlbum = new Album(artist, title);
        albumRepository.save(newAlbum);
        return new RedirectView("/albums");
    }

// songs

    @GetMapping("/songs")
    public String getSongs(Model m){
        List<Song> songs = songRepository.findAll();
        m.addAttribute("songs", songs);
        return "albums/albums.html";
    }

    @PostMapping("/songs")
    public RedirectView postSong(String title, int length, int trackNum, String album){
        Album gotAlbum = albumRepository.findByTitle(album);
        Song newSong = new Song(title, length, trackNum, gotAlbum);
        songRepository.save(newSong);
        return new RedirectView("/albums");
    }

    private String testAlbumDumper(){
        Album[] testAlbums = new Album[3];
        testAlbums[0] = new Album("Hubba Bubba", "Damaged Bug", 12, 2197, "pay no attention to this image url.");
        testAlbums[1] = new Album("Loaded", "Velvet Underground", 14, 1111, "pay no attention to this image url.");
        testAlbums[2] = new Album("Heaven is Here", "CANDY", 10, 2222, "pay no attention to this image url.");

        String albumString = testAlbums[0].albumString() + ", " + testAlbums[1].albumString() + ", " + testAlbums[2].albumString();

        return albumString;
    }
}
