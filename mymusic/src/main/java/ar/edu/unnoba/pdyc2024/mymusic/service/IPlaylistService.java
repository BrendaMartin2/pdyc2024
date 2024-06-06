package ar.edu.unnoba.pdyc2024.mymusic.service;

import ar.edu.unnoba.pdyc2024.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc2024.mymusic.model.Song;

import java.util.List;

public interface IPlaylistService {

    List<Playlist> obtenerPlaylists();

    void crearPlaylist(Playlist playlist);

    void borrarPlaylist(Long id);

    void agregarCancionAPlaylist(Playlist playlist);

    void cambiarNombrePlaylist(Playlist playlist);

    void sacarCancionDePlaylist(Playlist playlist);
    List<Song> obtenerCancionesDePlaylist(Long id);

    Playlist obtenerPlaylistPorId(Long id);
}
