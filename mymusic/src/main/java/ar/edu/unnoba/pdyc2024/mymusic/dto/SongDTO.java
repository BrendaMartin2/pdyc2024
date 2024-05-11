package ar.edu.unnoba.pdyc2024.mymusic.dto;

import ar.edu.unnoba.pdyc2024.mymusic.model.Genre;
import ar.edu.unnoba.pdyc2024.mymusic.model.Song;

public class SongDTO {
    private String nombre;
    private String autor;
    private Genre genero;
    private Long id;

    public SongDTO(String nombre, String autor, Genre genero, Long id) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
    }

    public SongDTO() {
    }

    public SongDTO(Song song) {
        this.id = song.getId();
        this.nombre = song.getNombre();
        this.autor = song.getAutor();
        this.genero = song.getGenero();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Genre getGenero() {
        return genero;
    }

    public void setGenero(Genre genero) {
        this.genero = genero;
    }
}
