package fr.studi.interspe.repository;

import fr.studi.interspe.pojo.Emprunt;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmpruntRepository extends CrudRepository<Emprunt,Long> {

  @Query("SELECT a FROM Emprunt a")
  List<Emprunt> findAllEmprunts();

}
