package com.valueit.gloc.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderBy
    private int voiture_Id;
    @Column(length = 20)
    private String marque;
    @Column(length = 20)
    private String immatriculation;
    @Column(length = 10)
    private String couleur;
    private String Modele;
    private Boolean disponibilité ;
    private int tarifs ;

}

