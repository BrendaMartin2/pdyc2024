package ar.edu.unnoba.pdyc2024.mymusic.dto;

import ar.edu.unnoba.pdyc2024.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc2024.mymusic.model.Song;

import java.util.List;

public class PlaylistDTO {
    private String nombre;

    private List<Song> canciones;

    private int cantidadCanciones;
    private Long id;


    public PlaylistDTO(Playlist playlist) {
        this.nombre = playlist.getNombre();
        this.id = playlist.getId();
        this.canciones=playlist.getSongs();
        this.cantidadCanciones= obtenerTotalCanciones(playlist.getSongs());
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

    public List<Song> getCanciones() {
        return canciones;
    }
    public void setCanciones(List<Song> canciones) {
        this.canciones = canciones;
    }
    public int getCantidadCanciones() {
        return cantidadCanciones;
    }
    public void setCantidadCanciones(int cantidadCanciones) {
        this.cantidadCanciones = cantidadCanciones;
    }

    private int obtenerTotalCanciones(List<Song> canciones){
        int total=0;
        for (Song c: canciones) {
            total+=1;
        }
        return total;
    }

}
