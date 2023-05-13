package fr.studi.interspe.ws;

import fr.studi.interspe.pojo.Editeur;
import fr.studi.interspe.service.EditeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController // produit et consomme du JSON
@RequestMapping(ApiRegistration.API_REST + ApiRegistration.EDITEUR)
public class EditeurWs {

    @Autowired
    private EditeurService editeurService;

    //Obtention de toutes les editeurs
    @GetMapping
    public List<Editeur> getAllEditeurs(){
        return editeurService.getAllEditeurs();
    }

    //Obtention d'une editeur
    @GetMapping("/{id}")
    public Editeur getEditeurById(@PathVariable Long id){
        return editeurService.getEditeurById(id);
    }

    @PutMapping("/{id}")
    public void updateEditeur(@PathVariable Long id,@RequestBody Editeur editeur){
        editeurService.updateEditeur(id,editeur);
    }

    @PostMapping
    public void createEditeur(@RequestBody Editeur editeur){
        editeurService.createEditeur(editeur);
    }

    @DeleteMapping("/{id}")
    public void deleteEditeurById(@PathVariable Long id){
        editeurService.deleteEditeurById(id);
    }




}
