package mapper;

import dto.ClientDto;
import entities.Client;
import entities.Voiture;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class ClientMapper  {

    @Autowired
    private  ModelMapper modelMapper;

    public  Client toEntity(ClientDto clientDTO){
        return modelMapper.map(clientDTO ,Client.class);
    }

    public  ClientDto toDTO(Client client) {
        return modelMapper.map(client ,ClientDto.class);
    }

    public Page<ClientDto> toDTO(Page<Client> clientPage) {
        return clientPage.map(client -> toDTO(client));
    }

}
