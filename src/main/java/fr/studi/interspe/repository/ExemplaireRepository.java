package fr.studi.interspe.repository;

import fr.studi.interspe.pojo.Exemplaire;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ExemplaireRepository extends CrudRepository<Exemplaire,Long> {

  @Query("SELECT a FROM Exemplaire a")
  List<Exemplaire> findAllExemplaires();

  @Query(
    "SELECT ex FROM Exemplaire ex " +
    "WHERE NOT EXISTS (" +
    "  SELECT em FROM Emprunt em " +
    "  WHERE ex.id = em.exemplaire.id " +
    "  AND em.statut = 0 " +
    ")" +
    "AND ex.livre.id = ?1"
  )
  List<Exemplaire> findAllExemplairesByLivreId(Long livre_id);

}
