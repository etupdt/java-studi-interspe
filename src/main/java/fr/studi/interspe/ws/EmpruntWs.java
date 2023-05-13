package fr.studi.interspe.ws;

import fr.studi.interspe.pojo.Emprunt;
import fr.studi.interspe.pojo.Exemplaire;
import fr.studi.interspe.service.EmpruntService;
import fr.studi.interspe.service.ExemplaireService;
import fr.studi.interspe.service.impl.ExemplaireServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController // produit et consomme du JSON
@RequestMapping(ApiRegistration.API_REST + ApiRegistration.EMPRUNT)
public class EmpruntWs {

    @Autowired
    private EmpruntService empruntService;

    @Autowired
    private ExemplaireService exemplaireService;

    //Obtention de toutes les emprunts
    @GetMapping
    public List<Emprunt> getAllEmprunts(){
        return empruntService.getAllEmprunts();
    }

    //Obtention d'une emprunt
    @GetMapping("/{id}")
    public Emprunt getEmpruntById(@PathVariable Long id){
        return empruntService.getEmpruntById(id);
    }

    @PutMapping("/{id}")
    public void updateEmprunt(@PathVariable Long id,@RequestBody Emprunt emprunt){
        empruntService.updateEmprunt(id,emprunt);
    }

    @PostMapping
    public void createEmprunt(@RequestBody Emprunt emprunt){
        empruntService.createEmprunt(emprunt);
    }

    @PostMapping("/livre/{livre_id}")
    public void createEmpruntLivre(@PathVariable Long livre_id, @RequestBody Emprunt emprunt){

        List<Exemplaire> exemplaires = exemplaireService.getAllExemplairesByLivreId(livre_id);
        emprunt.setExemplaire(exemplaires.get(0));
        empruntService.createEmprunt(emprunt);
    
    }

    @DeleteMapping("/{id}")
    public void deleteEmpruntById(@PathVariable Long id){
        empruntService.deleteEmpruntById(id);
    }




}
