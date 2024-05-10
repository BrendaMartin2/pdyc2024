package ar.edu.unnoba.pdyc2024.mymusic.service;

import ar.edu.unnoba.pdyc2024.mymusic.model.Song;

import java.util.List;

public interface ISongService {

    List<Song> getAllSongs();

    Song getSongById(Long id);
}
