package fr.studi.interspe.service.impl;

import fr.studi.interspe.pojo.Emprunt;
import fr.studi.interspe.repository.EmpruntRepository;
import fr.studi.interspe.service.EmpruntService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpruntServiceImpl implements EmpruntService {

    @Autowired
    private EmpruntRepository empruntRepository;

    public EmpruntServiceImpl() {
    }

    @Override
    public Emprunt getEmpruntById(Long id) {
        return empruntRepository.findById(id).orElse(null);
    }

    @Override
    public void createEmprunt(Emprunt emprunt) {
        empruntRepository.save(emprunt);
    }

    @Override
    public List<Emprunt> getAllEmprunts() {
        return (List<Emprunt>) empruntRepository.findAllEmprunts();
    }

    @Override
    public void deleteEmpruntById(Long id) {
        empruntRepository.deleteById(id);
    }

    @Override
    public void updateEmprunt(Long id, Emprunt emprunt) {
        Emprunt monEmprunt = this.getEmpruntById(id);

        //Si j'ai une Emprunt
        if(monEmprunt != null){

            //je modifie les informations
			monEmprunt.setId(emprunt.getId());
			monEmprunt.setExemplaire(emprunt.getExemplaire());
			monEmprunt.setAdherent(emprunt.getAdherent());
			monEmprunt.setDateEmprunt(emprunt.getDateEmprunt());
			monEmprunt.setDateRetour(emprunt.getDateRetour());
			monEmprunt.setStatut(emprunt.getStatut());

       
           //je le sauvegarde en base
           empruntRepository.save(monEmprunt);
        }
    }


}
