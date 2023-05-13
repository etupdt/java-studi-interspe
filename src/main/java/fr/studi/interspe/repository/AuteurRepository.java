package fr.studi.interspe.repository;

import fr.studi.interspe.pojo.Auteur;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AuteurRepository extends CrudRepository<Auteur,Long> {

  @Query("SELECT a FROM Auteur a")
  List<Auteur> findAllAuteurs();

}
