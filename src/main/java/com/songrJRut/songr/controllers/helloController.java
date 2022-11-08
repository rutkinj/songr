package com.songrJRut.songr.controllers;

import com.songrJRut.songr.albums.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Array;

@Controller
public class helloController {
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

    @GetMapping("/albums")
    public String getTestAlbums(Model m){

        String albumString = testAlbumDumper();

        m.addAttribute("albumString", albumString);
        return "albums/albums";
    }

    @PostMapping("/albums")
    public String postAlbums(){
        return "albums/albums";
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
