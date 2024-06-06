package ar.edu.unnoba.pdyc2024.mymusic.service;

import ar.edu.unnoba.pdyc2024.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc2024.mymusic.model.Song;
import ar.edu.unnoba.pdyc2024.mymusic.repository.PlaylistRepository;
import ar.edu.unnoba.pdyc2024.mymusic.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PlaylistService implements IPlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;

    private SongRepository songRepository;

    @Autowired
    private SongService songService;


    @Override
    public List<Playlist> obtenerPlaylists(){
            return playlistRepository.findAll();
        }

    @Override
    public void crearPlaylist(Playlist playlist) {
        playlistRepository.save(playlist);
    }

    @Override
    public void agregarCancionAPlaylist(Playlist playlist) {
        playlistRepository.save(playlist);
        }

    @Override
    public void cambiarNombrePlaylist(Playlist playlist) {
        playlistRepository.save(playlist);
    }

    public void sacarCancionDePlaylist(Playlist playlist) {
        playlistRepository.save(playlist);
    }

    @Override
    public void borrarPlaylist(Long id) {
        playlistRepository.deleteById(id);
    }

    public List<Song> obtenerCancionesDePlaylist(Long id) {
        return playlistRepository.findAllCancionesByPlaylistId(id);
    }

    @Override
    public Playlist obtenerPlaylistPorId( @PathVariable Long id) {
        return playlistRepository.findById(id).orElse(null);
    }
}