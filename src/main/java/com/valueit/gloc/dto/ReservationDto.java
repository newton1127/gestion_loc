package com.valueit.gloc.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@Data
public class ReservationDto {
    private long id ;
    private float prix ;
    private int durée ;
    private Date date_sortie ;
    private Date date_entrée ;
    private ClientDto client;
    private VoitureDto voiture ;

}
