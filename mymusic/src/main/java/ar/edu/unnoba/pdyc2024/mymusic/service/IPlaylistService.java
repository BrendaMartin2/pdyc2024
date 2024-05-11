package ar.edu.unnoba.pdyc2024.mymusic.service;

import ar.edu.unnoba.pdyc2024.mymusic.dto.PlaylistDTO;
import ar.edu.unnoba.pdyc2024.mymusic.dto.SongDTO;

import java.util.List;

public interface IPlaylistService {

    List<PlaylistDTO> obtenerPlaylists();

    PlaylistDTO crearPlaylist(PlaylistDTO playlistDTO);

    void borrarPlaylist(Long id);

    void agregarCancionAPlaylist(Long id,Long songId);

    void cambiarNombrePlaylist(Long playlistId, String newName);

    void sacarCancionDePlaylist(Long id, Long songId);
    List<SongDTO> obtenerCancionesDePlaylist(Long id);

    PlaylistDTO obtenerPlaylistPorId(Long id);
}
