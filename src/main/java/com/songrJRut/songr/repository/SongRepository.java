package com.songrJRut.songr.repository;

import com.songrJRut.songr.albums.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
