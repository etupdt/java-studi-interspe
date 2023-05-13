package fr.studi.interspe.service;

import fr.studi.interspe.pojo.Genre;

import java.util.List;

public interface GenreService {

    Genre getGenreById(Long id);

    void createGenre(Genre genre);

    List<Genre> getAllGenres();

    void deleteGenreById(Long id);

    void updateGenre(Long id, Genre genre);
}
