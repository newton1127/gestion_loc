package dto;

import entities.Voiture;

import java.util.List;

public class ClientDto {
    private long id ;
    private String nom ;
    private String prenom ;
   private List<String> voitures ;

    public long getId() {
        return id;
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<String> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<String> voitures) {
        this.voitures = voitures;
    }

    public ClientDto(String nom, String prenom, List<String> voitures) {
        this.nom = nom;
        this.prenom = prenom;
        this.voitures = voitures ;
    }

    public ClientDto() {
    }
}
