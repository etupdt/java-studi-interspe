package fr.studi.interspe.service.impl;

import fr.studi.interspe.pojo.Auteur;
import fr.studi.interspe.repository.AuteurRepository;
import fr.studi.interspe.service.AuteurService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuteurServiceImpl implements AuteurService {

    @Autowired
    private AuteurRepository auteurRepository;

    public AuteurServiceImpl() {
    }

    @Override
    public Auteur getAuteurById(Long id) {
        return auteurRepository.findById(id).orElse(null);
    }

    @Override
    public void createAuteur(Auteur auteur) {
        auteurRepository.save(auteur);
    }

    @Override
    public List<Auteur> getAllAuteurs() {
        return (List<Auteur>) auteurRepository.findAllAuteurs();
    }

    @Override
    public void deleteAuteurById(Long id) {
        auteurRepository.deleteById(id);
    }

    @Override
    public void updateAuteur(Long id, Auteur auteur) {
        Auteur monAuteur = this.getAuteurById(id);

        //Si j'ai une Auteur
        if(monAuteur != null){

            //je modifie les informations
			monAuteur.setId(auteur.getId());
			monAuteur.setPrenom(auteur.getPrenom());
			monAuteur.setNom(auteur.getNom());

       
           //je le sauvegarde en base
           auteurRepository.save(monAuteur);
        }
    }


}
