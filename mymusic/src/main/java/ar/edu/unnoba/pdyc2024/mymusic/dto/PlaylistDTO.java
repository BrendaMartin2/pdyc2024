package ar.edu.unnoba.pdyc2024.mymusic.dto;

import ar.edu.unnoba.pdyc2024.mymusic.model.Playlist;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PlaylistDTO {
    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("songs")
    private List<SongDTO> songs;
    private Long id;

    public PlaylistDTO(String nombre, Long id) {
        this.nombre = nombre;
        this.id=id;
    }

    public PlaylistDTO(Playlist playlist) {
        this.nombre = playlist.getNombre();
        this.id = playlist.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlaylistDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
