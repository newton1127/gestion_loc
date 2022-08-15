package mapper;

import dto.ClientDto;
import entities.Client;
import entities.Voiture;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class ClientMapperImpl  {


    public ClientDto clientToDto(Client client) {

        ModelMapper mapper =new ModelMapper();
        ClientDto map = mapper.map(client, ClientDto.class);
        return map;
    }
    public  List<ClientDto> clientToDto(List<Client> clients) {

        return	clients.stream().map(x -> clientToDto(x)).collect(Collectors.toList());

    }


    public  Client dtoToClient(ClientDto clientDto){
        ModelMapper mapper = new ModelMapper();
        Client map = mapper.map(clientDto, Client.class);
        return map;
    }
    public List<Client> dtoToClient(List<ClientDto> dto)
    {

        return dto.stream().map(x -> dtoToClient(x)).collect(Collectors.toList());
    }

}
