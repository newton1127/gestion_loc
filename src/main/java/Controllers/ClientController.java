package Controllers;

import dto.ClientDto;
import entities.Client;
import mapper.ClientMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repos.ClientRepos;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ClientRepos clientRepos ;
    @Autowired
    ClientMapperImpl clientMapper ;

    @GetMapping("/findclients")
    public List<ClientDto> findall(){
        List<Client> findlist = clientRepos.findAll();
    return clientMapper.clientToDto(findlist);
    }
    @GetMapping("/find/{ID}")
    public ClientDto findById(@PathVariable(value = "ID") Long id) {
        Client client = clientRepos.findById(id).orElse(null);
        return clientMapper.clientToDto(client);

    }

    @PostMapping("/addclient")
    public ClientDto save(@RequestBody ClientDto dto) {

        Client client = clientMapper.dtoToClient(dto);
        client=  clientRepos.save(client);
        return clientMapper.clientToDto(client);
    }

}
