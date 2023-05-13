package fr.studi.interspe.service.impl;

import fr.studi.interspe.pojo.Adherent;
import fr.studi.interspe.repository.AdherentRepository;
import fr.studi.interspe.service.AdherentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdherentServiceImpl implements AdherentService {

    @Autowired
    private AdherentRepository adherentRepository;

    public AdherentServiceImpl() {
    }

    @Override
    public Adherent getAdherentById(Long id) {
        return adherentRepository.findById(id).orElse(null);
    }

    @Override
    public void createAdherent(Adherent adherent) {
        adherentRepository.save(adherent);
    }

    @Override
    public List<Adherent> getAllAdherents() {
        return (List<Adherent>) adherentRepository.findAllAdherents();
    }

    @Override
    public void deleteAdherentById(Long id) {
        adherentRepository.deleteById(id);
    }

    @Override
    public void updateAdherent(Long id, Adherent adherent) {
        Adherent monAdherent = this.getAdherentById(id);

        //Si j'ai une Adherent
        if(monAdherent != null){

            //je modifie les informations
           monAdherent.setNom(adherent.getNom());
           monAdherent.setPrenom(adherent.getPrenom());
           monAdherent.setTelephone(adherent.getTelephone());
           monAdherent.setEmail(adherent.getEmail());
           monAdherent.setCaution(adherent.getCaution());
       
           //je le sauvegarde en base
           adherentRepository.save(monAdherent);
        }
    }


}
