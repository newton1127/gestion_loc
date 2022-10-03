package com.valueit.gloc.mapper;

import com.valueit.gloc.entities.Client;
import com.valueit.gloc.dto.ClientDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Client toEntity(ClientDto clientDTO) {
        return modelMapper.map(clientDTO, Client.class);
    }

    public ClientDto toDTO(Client client) {
        return modelMapper.map(client, ClientDto.class);
    }

    public Page<ClientDto> toDTO(Page<Client> clientPage) {
        return clientPage.map(client -> toDTO(client));
    }

}
