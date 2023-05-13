package fr.studi.interspe.service;

import fr.studi.interspe.pojo.Editeur;

import java.util.List;

public interface EditeurService {

    Editeur getEditeurById(Long id);

    void createEditeur(Editeur editeur);

    List<Editeur> getAllEditeurs();

    void deleteEditeurById(Long id);

    void updateEditeur(Long id, Editeur editeur);
}
