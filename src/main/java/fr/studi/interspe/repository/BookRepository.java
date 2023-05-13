package fr.studi.interspe.repository;

import fr.studi.interspe.pojo.Livre;
import fr.studi.interspe.pojo.Status;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Livre,Long> {

  @Query("SELECT a FROM Livre a")
  List<Livre> findAllBook();

  @Query(
    "SELECT distinct l1 FROM Livre l1 " +
    "INNER JOIN Exemplaire ex0 " +
    "ON l1.id = ex0.livre.id " +
    "WHERE NOT EXISTS (" +
    "  SELECT distinct l2 FROM Livre l2 " +
    "  INNER JOIN Exemplaire ex1 " +
    "  ON l2.id = ex1.livre.id " +
    "  WHERE NOT EXISTS (" +
    "    SELECT ex2 FROM Exemplaire ex2 " +
    "    INNER JOIN Emprunt em " +
    "    ON ex2.id = em.exemplaire.id " +
    "    WHERE em.statut = 0 " +
    "    AND ex1.id = ex2.id" +
    "  ) " +
    "  AND l1.id = l2.id" +
    ") " 
  )
  List<Livre> findLivresLoues();
  
  @Query(
    "SELECT DISTINCT l FROM Livre l " +
    "INNER JOIN Exemplaire ex1 " +
    "ON l.id = ex1.livre.id " +
    "WHERE NOT EXISTS (" +
    "  SELECT ex2 FROM Exemplaire ex2 " +
    "  INNER JOIN Emprunt em " +
    "  ON ex2.id = em.exemplaire.id " +
    "  WHERE em.statut = 0 " +
    "  AND ex1.id = ex2.id" +
    ")"
  )
  List<Livre> findLivresNonLoues();
    
}
