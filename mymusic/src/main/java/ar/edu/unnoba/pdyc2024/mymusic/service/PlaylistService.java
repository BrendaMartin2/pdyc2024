package ar.edu.unnoba.pdyc2024.mymusic.service;

import ar.edu.unnoba.pdyc2024.mymusic.dto.PlaylistDTO;
import ar.edu.unnoba.pdyc2024.mymusic.dto.SongDTO;
import ar.edu.unnoba.pdyc2024.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc2024.mymusic.model.Song;
import ar.edu.unnoba.pdyc2024.mymusic.repository.PlaylistRepository;
import ar.edu.unnoba.pdyc2024.mymusic.repository.SongRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaylistService implements IPlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;

    private SongRepository songRepository;

    @Autowired
    private SongService songService;

    private ModelMapper modelMapper;

    @Override
    public List<PlaylistDTO> obtenerPlaylists(){
            List<Playlist> playlists = playlistRepository.findAll();
            List<PlaylistDTO> playlistDTOs = new ArrayList<>();
            for (Playlist playlist : playlists) {
                PlaylistDTO playlistDTO = modelMapper.map(playlist, PlaylistDTO.class);
                playlistDTOs.add(playlistDTO);
            }
            return playlistDTOs;
        }

    @Override
    public PlaylistDTO crearPlaylist(PlaylistDTO playlistDTO) {
        Playlist playlist = modelMapper.map(playlistDTO, Playlist.class);
        Playlist guardarPlaylist = playlistRepository.save(playlist); // se guarda la playlist en la base de datos
        return modelMapper.map(guardarPlaylist, PlaylistDTO.class); // se mapea la playlist de vuelta a un DTO y la retornamos
    }

    @Override
    public void agregarCancionAPlaylist(Long playlistId, Long songId) {
            Playlist playlist = playlistRepository.findById(playlistId).orElse(null);
            if (playlist != null) {
                // se busca la canción por su ID
                Song song = songRepository.findById(songId).orElse(null);
                if (song != null) {
                    // se agrega la canción a la playlist
                    playlist.getSongs().add(song);
                    // Guardamos la playlist actualizada en la base de datos
                    Playlist savedPlaylist = playlistRepository.save(playlist);
                } else {
                    throw new IllegalArgumentException("No se encontró la canción con el ID especificado.");
                }
            } else {
                throw new IllegalArgumentException("No se encontró la playlist con el ID especificado.");
            }
        }

    @Override
    public void cambiarNombrePlaylist(Long playlistId, String newName) {
        Playlist playlist = playlistRepository.findById(playlistId).orElse(null);
        if (playlist != null) {
            playlist.setNombre(newName);
            playlistRepository.save(playlist);
        } else {
            throw new IllegalArgumentException("No se encontró la playlist con el ID especificado.");
        }
    }

    public void sacarCancionDePlaylist(Long playlistId, Long songId) {
        Playlist playlist = playlistRepository.findById(playlistId).orElse(null);
        if (playlist != null) {
            Song song = songRepository.findById(songId).orElse(null);
            if (song != null) {
                playlist.getSongs().remove(song);
                // se guarda la playlist actualizada en la base de datos
                playlistRepository.save(playlist);
            } else {
                throw new IllegalArgumentException("No se encontró la canción con el ID especificado.");
            }
        } else {
            throw new IllegalArgumentException("No se encontró la playlist con el ID especificado.");
        }
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
        List<SongDTO> songsDTO = new ArrayList<>();
        if (playlist != null) {
            List<Song> songs = playlist.getSongs();
            for (Song song : songs) {
                SongDTO songDTO = modelMapper.map(song, SongDTO.class);
                songsDTO.add(songDTO);
            }
        } else {
            throw new RuntimeException("Playlist no encontrada, id: " + playlistId);
        }
        return songsDTO;
    }

    @Override
    public PlaylistDTO obtenerPlaylistPorId( @PathVariable Long id) {
        Playlist playlist = playlistRepository.findById(id).orElse(null);
        if (playlist != null) {
            return new PlaylistDTO(playlist);
        } else {
            throw new RuntimeException("Playlist no encontrada, id: " + id);
        }
    }
}