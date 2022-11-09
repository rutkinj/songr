package com.songrJRut.songr.repository;

import com.songrJRut.songr.albums.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    public Album findByArtist(String artist);
    public Album findByTitle(String title);
}
