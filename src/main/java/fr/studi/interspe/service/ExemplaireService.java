package fr.studi.interspe.service;

import fr.studi.interspe.pojo.Exemplaire;

import java.util.List;

public interface ExemplaireService {

    Exemplaire getExemplaireById(Long id);

    void createExemplaire(Exemplaire exemplaire);

    List<Exemplaire> getAllExemplairesByLivreId(Long livre_id);

    List<Exemplaire> getAllExemplaires();

    void deleteExemplaireById(Long id);

    void updateExemplaire(Long id, Exemplaire exemplaire);
}
