package ar.edu.unnoba.pdyc2024.mymusic.repository;

import ar.edu.unnoba.pdyc2024.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc2024.mymusic.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
@Query("SELECT s FROM Song s JOIN PlaylistSong ps ON s.id = ps.song.id JOIN Playlist p ON p.id = ps.playlist.id WHERE p.id = :playlistId")
    List<Song> findAllCancionesByPlaylistId(Long playlistId);
}
