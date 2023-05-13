package fr.studi.interspe.service;

import fr.studi.interspe.pojo.Auteur;

import java.util.List;

public interface AuteurService {

    Auteur getAuteurById(Long id);

    void createAuteur(Auteur auteur);

    List<Auteur> getAllAuteurs();

    void deleteAuteurById(Long id);

    void updateAuteur(Long id, Auteur auteur);
}
