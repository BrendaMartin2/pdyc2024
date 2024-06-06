package ar.edu.unnoba.pdyc2024.mymusic.resource;

import ar.edu.unnoba.pdyc2024.mymusic.dto.PlaylistDTO;
import ar.edu.unnoba.pdyc2024.mymusic.dto.SongDTO;
import ar.edu.unnoba.pdyc2024.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc2024.mymusic.model.Song;
import ar.edu.unnoba.pdyc2024.mymusic.service.PlaylistService;
import ar.edu.unnoba.pdyc2024.mymusic.service.SongService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistResource {
    @Autowired
    private PlaylistService playlistService;

    @Autowired
    private SongService songService;
    private ModelMapper modelMapper;

    @GetMapping("/")
    public List<PlaylistDTO> obtenerPlaylists() {
        List<Playlist> playlists = playlistService.obtenerPlaylists();
        List<PlaylistDTO> playlistDTOs = new ArrayList<>();
        for (Playlist playlist : playlists) {
            PlaylistDTO playlistDTO = modelMapper.map(playlist, PlaylistDTO.class);
            playlistDTOs.add(playlistDTO);
        }
        return playlistDTOs;
    }

    @PostMapping("/")
    public void crearPlaylist(@RequestBody PlaylistDTO playlistDTO) {
        Playlist playlist = modelMapper.map(playlistDTO, Playlist.class);
        playlistService.crearPlaylist(playlist);
    }


    @PutMapping("/{id}")
    public void cambiarNombrePlaylist(@PathVariable Long id, @RequestBody String nuevoNombre) {
        Playlist playlist = playlistService.obtenerPlaylistPorId(id);
        if (playlist != null) {
            playlist.setNombre(nuevoNombre);
            playlistService.cambiarNombrePlaylist(playlist);
        } else {
            throw new IllegalArgumentException("No se encontró la playlist con el ID especificado.");
        }
    }

    @DeleteMapping("/{id}")
    public void borrarPlaylist(@PathVariable Long id) {
        Playlist playlist = playlistService.obtenerPlaylistPorId(id);
        if (playlist != null) {
            playlistService.borrarPlaylist(id);
        } else {
            throw new RuntimeException("Playlist no encontrada");
        }
    }

    @PostMapping("/{id}/songs/{songId}")
    public void agregarCancionAPlaylist(@PathVariable Long id, @PathVariable Long songId) {
        Playlist playlist = playlistService.obtenerPlaylistPorId(id); // se busca la playlist por su ID
        Song song = songService.getSongById(songId); // se busca la canción por su ID
        if (playlist != null && song != null) {
                playlist.getSongs().add(song); // se agrega la canción a la playlist
                playlistService.agregarCancionAPlaylist(playlist); // Guardamos la playlist actualizada en la base de datos
            } else {
                throw new IllegalArgumentException("No se encontró la playlist o la canción con el ID especificado.");
            }
        }

    @DeleteMapping("/{id}/songs/{songId}")
    public void sacarCancionDePlaylist(@PathVariable Long id, @PathVariable Long songId) {
        Playlist playlist = playlistService.obtenerPlaylistPorId(id);
        Song song = songService.getSongById(songId);
            if (playlist!= null && song != null) {
                playlist.getSongs().remove(song);
                playlistService.sacarCancionDePlaylist(playlist); // se guarda la playlist actualizada en la base de datos
            } else {
                throw new IllegalArgumentException("No se encontró la canción con el ID especificado.");
            }
        }


    @GetMapping("/{id}/songs")
    public List<SongDTO> obtenerCancionesDePlaylist(@PathVariable Long id) {
        List<Song> canciones = playlistService.obtenerCancionesDePlaylist(id);
        List<SongDTO> songsDTO = new ArrayList<>();
        if (canciones != null) {
            for (Song song : canciones) {
                SongDTO songDTO = modelMapper.map(song, SongDTO.class);
                songsDTO.add(songDTO);
            }
        } else {
            throw new RuntimeException("La playlist no tiene canciones");
        }
        return songsDTO;
    }

    @GetMapping("/{id}")
    public PlaylistDTO obtenerPlaylistPorId(@PathVariable Long id) {
        Playlist playlist= playlistService.obtenerPlaylistPorId(id);
        if (playlist != null) {
        return new PlaylistDTO(playlist);
        } else {
            throw new RuntimeException("Playlist no encontrada");
        }
    }
}
