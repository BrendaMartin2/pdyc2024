package ar.edu.unnoba.pdyc2024.mymusic.service;

import ar.edu.unnoba.pdyc2024.mymusic.dto.PlaylistDTO;
import ar.edu.unnoba.pdyc2024.mymusic.dto.SongDTO;
import ar.edu.unnoba.pdyc2024.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc2024.mymusic.model.Song;
import ar.edu.unnoba.pdyc2024.mymusic.repository.PlaylistRepository;
import ar.edu.unnoba.pdyc2024.mymusic.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaylistService implements IPlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private SongService songService;
    private SongRepository songRepository;

    @Override
    public List<PlaylistDTO> obtenerPlaylists() {
        List<Playlist> playlists = playlistRepository.findAll();
        List<PlaylistDTO> playlistDTOs = new ArrayList<>();
        for (Playlist playlist : playlists) {
            playlistDTOs.add(new PlaylistDTO(playlist));
        }
        return playlistDTOs;
    }

    @Override
    public PlaylistDTO crearPlaylist(PlaylistDTO playlistDTO) {
        Playlist playlist = new Playlist();
        playlist.setNombre(playlistDTO.getNombre());
        playlist = playlistRepository.save(playlist);
        return new PlaylistDTO(playlist);
    }

    @Override
    public PlaylistDTO obtenerPlaylistPorId(Long id) {
        Playlist playlist = playlistRepository.findById(id).orElse(null);
        if (playlist != null) {
            return new PlaylistDTO(playlist);
        } else {
            throw new RuntimeException("Playlist no encontrada, id: " + id);
        }
    }

    @Override
    public void agregarCancionAPlaylist(Long playlistId, Long songId) {
        Playlist playlist = playlistRepository.findById(playlistId).orElse(null);
        if (playlist == null){
            throw new RuntimeException("Playlist no encontrada, id: " + playlistId);}
        Song song = songService.getSongById(songId);
        if (song == null) {
            throw new RuntimeException("Canción no encontrada, id: " + songId);
        }
        // Agregar la canción a la lista de canciones de la playlist
        playlist.getSongs().add(song);
        playlistRepository.save(playlist);
    }

    @Override
    public PlaylistDTO cambiarNombrePlaylist(Long id, PlaylistDTO playlistDTO) {
        Playlist playlist = playlistRepository.findById(id).orElse(null);
        if (playlist != null) {
            playlist.setNombre(playlistDTO.getNombre());
            playlist = playlistRepository.save(playlist);
            return new PlaylistDTO(playlist);
        } else {
            throw new RuntimeException("Playlist no encontrada, id: " + id);
        }
    }

    public void sacarCancionDePlaylist(Long playlistId, Long songId) {
        Playlist playlist = playlistRepository.findById(playlistId).orElse(null);
        if (playlist == null) {
            throw new RuntimeException("Playlist no encontrada, id: " + playlistId);
        }
        Song song = songService.getSongById(songId);
        if (song == null) {
            throw new RuntimeException("Canción no encontrada, id: " + songId);
        }
        // Eliminar la canción de la lista de canciones de la playlist
        playlist.getSongs().remove(song);
        playlistRepository.save(playlist);
    }

    @Override
    public void borrarPlaylist(Long id) {
        Playlist playlist = playlistRepository.findById(id).orElse(null);
        if (playlist != null) {
            playlistRepository.delete(playlist);
        } else {
            throw new RuntimeException("Playlist no encontrada, id: " + id);
        }
    }

    public List<SongDTO> obtenerCancionesDePlaylist(Long playlistId) {
        Playlist playlist = playlistRepository.findById(playlistId).orElse(null);
        if (playlist != null) {
            List<Song> songs = playlist.getSongs();
            List<SongDTO> songDTOs = new ArrayList<>();
            for (Song song : songs) {
                SongDTO songDTO = new SongDTO();
                songDTO.setId(song.getId());
                songDTO.setNombre(song.getNombre());
                songDTOs.add(songDTO);
            }
            return songDTOs;
        } else {
            throw new RuntimeException("Playlist no encontrada, id: " + playlistId);
        }
    }
}