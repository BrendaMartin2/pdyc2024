package ar.edu.unnoba.pdyc2024.mymusic.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "playlists")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @ManyToMany()
    @JoinTable(name = "playlists_songs",
            joinColumns = @JoinColumn(name = "playlists"),
            inverseJoinColumns = @JoinColumn(name="songs"))
    private List<Song> songs;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public List<Song> getSongs() {return songs;}

    public void setSongs(List<Song> songs) {this.songs = songs;}
}
