package fr.studi.interspe.service.impl;

import fr.studi.interspe.pojo.Editeur;
import fr.studi.interspe.repository.EditeurRepository;
import fr.studi.interspe.service.EditeurService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditeurServiceImpl implements EditeurService {

    @Autowired
    private EditeurRepository editeurRepository;

    public EditeurServiceImpl() {
    }

    @Override
    public Editeur getEditeurById(Long id) {
        return editeurRepository.findById(id).orElse(null);
    }

    @Override
    public void createEditeur(Editeur editeur) {
        editeurRepository.save(editeur);
    }

    @Override
    public List<Editeur> getAllEditeurs() {
        return (List<Editeur>) editeurRepository.findAllEditeurs();
    }

    @Override
    public void deleteEditeurById(Long id) {
        editeurRepository.deleteById(id);
    }

    @Override
    public void updateEditeur(Long id, Editeur editeur) {
        Editeur monEditeur = this.getEditeurById(id);

        //Si j'ai une Editeur
        if(monEditeur != null){

            //je modifie les informations
			monEditeur.setId(editeur.getId());
			monEditeur.setNom(editeur.getNom());

       
           //je le sauvegarde en base
           editeurRepository.save(monEditeur);
        }
    }


}
