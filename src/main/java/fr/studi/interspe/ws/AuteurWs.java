package fr.studi.interspe.ws;

import fr.studi.interspe.pojo.Auteur;
import fr.studi.interspe.service.AuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController // produit et consomme du JSON
@RequestMapping(ApiRegistration.API_REST + ApiRegistration.AUTEUR)
public class AuteurWs {

    @Autowired
    private AuteurService auteurService;

    //Obtention de toutes les auteurs
    @GetMapping
    public List<Auteur> getAllAuteurs(){
        return auteurService.getAllAuteurs();
    }

    //Obtention d'une auteur
    @GetMapping("/{id}")
    public Auteur getAuteurById(@PathVariable Long id){
        return auteurService.getAuteurById(id);
    }

    @PutMapping("/{id}")
    public void updateAuteur(@PathVariable Long id,@RequestBody Auteur auteur){
        auteurService.updateAuteur(id,auteur);
    }

    @PostMapping
    public void createAuteur(@RequestBody Auteur auteur){
        auteurService.createAuteur(auteur);
    }

    @DeleteMapping("/{id}")
    public void deleteAuteurById(@PathVariable Long id){
        auteurService.deleteAuteurById(id);
    }




}
