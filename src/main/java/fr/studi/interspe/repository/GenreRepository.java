package fr.studi.interspe.repository;

import fr.studi.interspe.pojo.Genre;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre,Long> {

  @Query("SELECT a FROM Genre a")
  List<Genre> findAllGenres();

}
