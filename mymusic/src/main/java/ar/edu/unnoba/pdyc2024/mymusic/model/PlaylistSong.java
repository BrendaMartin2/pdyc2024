package ar.edu.unnoba.pdyc2024.mymusic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "playlists_songs")
public class PlaylistSong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    @JsonIgnore
    private Playlist playlist;

    @ManyToOne
    @JoinColumn(name = "song_id")
    private Song song;

    public PlaylistSong() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public PlaylistSong(Long id, Playlist playlist, Song song) {
        this.id = id;
        this.playlist = playlist;
        this.song = song;

    }
}