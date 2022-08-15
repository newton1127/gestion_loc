package Controllers;

import Services.VoitureService;
import entities.Voiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoitureController {
    @Autowired
    private VoitureService voitureService ;
   @PostMapping ("voitureadd")
    public Voiture addVoiture(@RequestBody Voiture voiture){
        return voitureService.save(voiture);
    }
    @GetMapping("voitures")
    public List<Voiture> findAllVoitures(){
       return voitureService.getVoitures();
    }
    @GetMapping("voiture/{id}")
    public Voiture findVoitureById(@PathVariable int id){
       return voitureService.getVoiturebyID(id);
    }
    @GetMapping("voiturebymarque/{marque}")
    public List<Voiture> findVoitureByMarque(@PathVariable String marque){
       return voitureService.getVoitureByMarque(marque);
    }
  @PutMapping ("updatevoiture")
    public Voiture updateVoiture(@RequestBody Voiture voiture){
       return voitureService.updateVoiture(voiture);
    }
    @DeleteMapping("deletevoiture/{id}")
    public String deleteVoiture(@PathVariable int id){
       return voitureService.deleteVoiture(id);
    }

}
