package com.valueit.gloc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientDto {
    private long id ;
    private String nom ;
    private String prenom ;
    private int age ;
   private List<String> voitures ;


}
