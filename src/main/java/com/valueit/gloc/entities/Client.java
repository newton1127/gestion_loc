package com.valueit.gloc.entities;



import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
@Table
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long Client_ID ;
    @Column(length = 50)
    private String nom ;
    @Column(length = 50)
    private String prenom ;
    @Column(length = 2)
    private int age ;

    @OneToMany(targetEntity = Voiture.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="voiture_Id")
    private List<Voiture>  voiture ;


}
