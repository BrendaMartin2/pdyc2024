package ar.edu.unnoba.pdyc2024.mymusic.repository;

import ar.edu.unnoba.pdyc2024.mymusic.model.PlaylistSong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistSongRepository extends JpaRepository<PlaylistSong, Long> {
}
