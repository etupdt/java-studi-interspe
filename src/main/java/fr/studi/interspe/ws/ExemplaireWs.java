package fr.studi.interspe.ws;

import fr.studi.interspe.pojo.Exemplaire;
import fr.studi.interspe.service.ExemplaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController // produit et consomme du JSON
@RequestMapping(ApiRegistration.API_REST + ApiRegistration.EXEMPLAIRE)
public class ExemplaireWs {

    @Autowired
    private ExemplaireService exemplaireService;

    //Obtention de toutes les exemplaires
    @GetMapping
    public List<Exemplaire> getAllExemplaires(){
        return exemplaireService.getAllExemplaires();
    }

    //Obtention d'une exemplaire
    @GetMapping("/{id}")
    public Exemplaire getExemplaireById(@PathVariable Long id){
        return exemplaireService.getExemplaireById(id);
    }

    @PutMapping("/{id}")
    public void updateExemplaire(@PathVariable Long id,@RequestBody Exemplaire exemplaire){
        exemplaireService.updateExemplaire(id,exemplaire);
    }

    @PostMapping
    public void createExemplaire(@RequestBody Exemplaire exemplaire){
        exemplaireService.createExemplaire(exemplaire);
    }

    @DeleteMapping("/{id}")
    public void deleteExemplaireById(@PathVariable Long id){
        exemplaireService.deleteExemplaireById(id);
    }




}
