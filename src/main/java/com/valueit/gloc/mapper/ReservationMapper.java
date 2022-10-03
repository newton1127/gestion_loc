package com.valueit.gloc.mapper;

import com.valueit.gloc.dto.ReservationDto;
import com.valueit.gloc.entities.Reservation;
import com.valueit.gloc.exception.EnableToMapNullEntityException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Reservation toEntity(ReservationDto reservationDto){
        if(reservationDto==null){
            throw new EnableToMapNullEntityException("cmdDTO shouldn't be null");
        }
        return modelMapper.map(reservationDto ,Reservation.class);
    }

    public  ReservationDto toDTO(Reservation reservation) {
        if(reservation==null){
            throw new EnableToMapNullEntityException("commande shouldn't be null");
        }
        return modelMapper.map(reservation ,ReservationDto.class);
    }

    public Page<ReservationDto> toDTO(Page<Reservation> reservationPage) {
        return reservationPage.map(cmd -> toDTO(cmd));
    }
}
