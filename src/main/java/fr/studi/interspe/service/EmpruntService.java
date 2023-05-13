package fr.studi.interspe.service;

import fr.studi.interspe.pojo.Emprunt;

import java.util.List;

public interface EmpruntService {

    Emprunt getEmpruntById(Long id);

    void createEmprunt(Emprunt emprunt);

    List<Emprunt> getAllEmprunts();

    void deleteEmpruntById(Long id);

    void updateEmprunt(Long id, Emprunt emprunt);
}
