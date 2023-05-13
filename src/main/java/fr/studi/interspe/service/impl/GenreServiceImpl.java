package fr.studi.interspe.service.impl;

import fr.studi.interspe.pojo.Genre;
import fr.studi.interspe.repository.GenreRepository;
import fr.studi.interspe.service.GenreService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public GenreServiceImpl() {
    }

    @Override
    public Genre getGenreById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    @Override
    public void createGenre(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public List<Genre> getAllGenres() {
        return (List<Genre>) genreRepository.findAllGenres();
    }

    @Override
    public void deleteGenreById(Long id) {
        genreRepository.deleteById(id);
    }

    @Override
    public void updateGenre(Long id, Genre genre) {
        Genre monGenre = this.getGenreById(id);

        //Si j'ai une Genre
        if(monGenre != null){

            //je modifie les informations
			monGenre.setId(genre.getId());
			monGenre.setNom(genre.getNom());

       
           //je le sauvegarde en base
           genreRepository.save(monGenre);
        }
    }


}
