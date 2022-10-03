package com.valueit.gloc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VoitureDto {
    private int voiture_Id;
    private String marque;
    private String immatriculation;
    private String modele ;
    private  String couleur;
}
