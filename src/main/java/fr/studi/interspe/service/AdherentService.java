package fr.studi.interspe.service;

import fr.studi.interspe.pojo.Adherent;

import java.util.List;

public interface AdherentService {

    Adherent getAdherentById(Long id);

    void createAdherent(Adherent adherent);

    List<Adherent> getAllAdherents();

    void deleteAdherentById(Long id);

    void updateAdherent(Long id, Adherent adherent);
}
