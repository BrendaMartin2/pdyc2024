package ar.edu.unnoba.pdyc2024.mymusic.resource;

import ar.edu.unnoba.pdyc2024.mymusic.dto.PlaylistDTO;
import ar.edu.unnoba.pdyc2024.mymusic.dto.SongDTO;
import ar.edu.unnoba.pdyc2024.mymusic.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistResource {
    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/")
    public List<PlaylistDTO> obtenerPlaylists() {
        return playlistService.obtenerPlaylists();
    }

    @PostMapping("/")
    public PlaylistDTO crearPlaylist(@RequestBody PlaylistDTO playlistDTO) {
        return playlistService.crearPlaylist(playlistDTO);
    }

    @GetMapping("/{id}")
    public PlaylistDTO obtenerPlaylistPorId(@PathVariable Long id) {
        return playlistService.obtenerPlaylistPorId(id);
    }

    @PutMapping("/{id}")
    public PlaylistDTO cambiarNombrePlaylist(@PathVariable Long id, @RequestBody PlaylistDTO playlistDTO) {
        return playlistService.cambiarNombrePlaylist(id, playlistDTO);
    }

    @DeleteMapping("/{id}")
    public void borrarPlaylist(@PathVariable Long id) {
        playlistService.borrarPlaylist(id);
    }

    @PostMapping("/{id}/songs/{songId}")
    public void agregarCancionAPlaylist(@PathVariable Long id, @PathVariable Long songId) {
        playlistService.agregarCancionAPlaylist(id, songId);
    }

    @DeleteMapping("/{id}/songs/{songId}")
    public void sacarCancionDePlaylist(@PathVariable Long id, @PathVariable Long songId) {
        playlistService.sacarCancionDePlaylist(id, songId);
    }

    @GetMapping("/{id}/songs")
    public List<SongDTO> obtenerCancionesDePlaylist(@PathVariable Long id) {
        return playlistService.obtenerCancionesDePlaylist(id);
    }
}
