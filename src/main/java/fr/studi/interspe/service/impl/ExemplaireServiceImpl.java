package fr.studi.interspe.service.impl;

import fr.studi.interspe.pojo.Exemplaire;
import fr.studi.interspe.repository.ExemplaireRepository;
import fr.studi.interspe.service.ExemplaireService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExemplaireServiceImpl implements ExemplaireService {

    @Autowired
    private ExemplaireRepository exemplaireRepository;

    @Override
    public Exemplaire getExemplaireById(Long id) {
        return exemplaireRepository.findById(id).orElse(null);
    }

    @Override
    public void createExemplaire(Exemplaire exemplaire) {
        exemplaireRepository.save(exemplaire);
    }

    @Override
    public List<Exemplaire> getAllExemplaires() {
        return (List<Exemplaire>) exemplaireRepository.findAllExemplaires();
    }

    @Override
    public void deleteExemplaireById(Long id) {
        exemplaireRepository.deleteById(id);
    }

    @Override
    public void updateExemplaire(Long id, Exemplaire exemplaire) {
        Exemplaire monExemplaire = this.getExemplaireById(id);

        //Si j'ai une Exemplaire
        if(monExemplaire != null){

            //je modifie les informations
			monExemplaire.setId(exemplaire.getId());
			monExemplaire.setUsure(exemplaire.getUsure());
			monExemplaire.setStock(exemplaire.getStock());
			monExemplaire.setLivre(exemplaire.getLivre());

       
           //je le sauvegarde en base
           exemplaireRepository.save(monExemplaire);
        }
    }

    //@Autowired
    public List<Exemplaire> getAllExemplairesByLivreId(Long livre_id) {
        return (List<Exemplaire>) exemplaireRepository.findAllExemplairesByLivreId(livre_id);
    }


}
