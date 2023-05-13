package fr.studi.interspe.ws;

import fr.studi.interspe.pojo.Genre;
import fr.studi.interspe.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController // produit et consomme du JSON
@RequestMapping(ApiRegistration.API_REST + ApiRegistration.GENRE)
public class GenreWs {

    @Autowired
    private GenreService genreService;

    //Obtention de toutes les genres
    @GetMapping
    public List<Genre> getAllGenres(){
        return genreService.getAllGenres();
    }

    //Obtention d'une genre
    @GetMapping("/{id}")
    public Genre getGenreById(@PathVariable Long id){
        return genreService.getGenreById(id);
    }

    @PutMapping("/{id}")
    public void updateGenre(@PathVariable Long id,@RequestBody Genre genre){
        genreService.updateGenre(id,genre);
    }

    @PostMapping
    public void createGenre(@RequestBody Genre genre){
        genreService.createGenre(genre);
    }

    @DeleteMapping("/{id}")
    public void deleteGenreById(@PathVariable Long id){
        genreService.deleteGenreById(id);
    }




}
