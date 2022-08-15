package Services;

import dto.ClientDto;
import entities.Client;
import entities.Voiture;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repos.ClientRepos;
import repos.VoitureRepos;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VoitureService {
    @Autowired
    private VoitureRepos voiture_repos ;
    @Autowired
    private ModelMapper modelMapper ;


   


    public List<Voiture> Listall(){
        return voiture_repos.findAll();
    }
    public Voiture save(Voiture voiture) {
        return voiture_repos.save(voiture);

    }
    public List<Voiture> getVoitures(){
        return voiture_repos.findAll();
    }
    public List<Voiture> getVoitureByMarque(String marque){
        return voiture_repos.findByOrderBymarque(marque);
    }
    public Voiture getVoiturebyID(int id){
        return voiture_repos.findById(id).orElse(null);

    }
    public String deleteVoiture(int id){
        voiture_repos.deleteById(id);
        return "done";

    }
    public Voiture updateVoiture(Voiture voiture){
        Voiture voiture_oldversion = voiture_repos.findById(voiture.getVoiture_Id()).orElse(null);
        voiture_oldversion.setColeur(voiture.getColeur());
        voiture_oldversion.setModele(voiture.getModele());
        voiture_oldversion.setImmatriculation(voiture.getImmatriculation());
        voiture_oldversion.setMarque(voiture.getMarque());
        return voiture_repos.save(voiture_oldversion);
    }
}
