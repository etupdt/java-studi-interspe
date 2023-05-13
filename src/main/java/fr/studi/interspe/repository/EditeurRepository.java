package fr.studi.interspe.repository;

import fr.studi.interspe.pojo.Editeur;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EditeurRepository extends CrudRepository<Editeur,Long> {

  @Query("SELECT a FROM Editeur a")
  List<Editeur> findAllEditeurs();

}
