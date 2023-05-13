package fr.studi.interspe.repository;

import fr.studi.interspe.pojo.Adherent;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AdherentRepository extends CrudRepository<Adherent,Long> {

  @Query("SELECT a FROM Adherent a")
  List<Adherent> findAllAdherents();

}
