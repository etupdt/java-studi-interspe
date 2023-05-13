package fr.studi.interspe.ws;

import fr.studi.interspe.pojo.Adherent;
import fr.studi.interspe.service.AdherentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController // produit et consomme du JSON
@RequestMapping(ApiRegistration.API_REST + ApiRegistration.ADHERENT)
public class AdherentWs {

    @Autowired
    private AdherentService adherentService;

    //Obtention de toutes les adherents
    @GetMapping
    public List<Adherent> getAllAdherents(){
        return adherentService.getAllAdherents();
    }

    //Obtention d'une adherent
    @GetMapping("/{id}")
    public Adherent getAdherentById(@PathVariable Long id){
        return adherentService.getAdherentById(id);
    }

    @PutMapping("/{id}")
    public void updateAdherent(@PathVariable Long id,@RequestBody Adherent adherent){
        adherentService.updateAdherent(id,adherent);
    }

    @PostMapping
    public void createAdherent(@RequestBody Adherent adherent){
        adherentService.createAdherent(adherent);
    }

    @DeleteMapping("/{id}")
    public void deleteAdherentById(@PathVariable Long id){
        adherentService.deleteAdherentById(id);
    }




}
