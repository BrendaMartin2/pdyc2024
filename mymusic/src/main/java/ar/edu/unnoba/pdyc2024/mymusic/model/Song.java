package ar.edu.unnoba.pdyc2024.mymusic.model;

import jakarta.persistence.*;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String nombre;

    @Column(name = "author", nullable = false)
    private String autor;
    @Enumerated(EnumType.STRING)
    @Column(name = "genre", nullable = false)
    private Genre genero;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getAutor() {return autor;}

    public void setAutor(String autor) {this.autor = autor;}

    public Genre getGenero() {return genero;}

    public void setGenero(Genre genero) {this.genero = genero;}
}
