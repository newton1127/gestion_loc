package Services;

import dto.ClientDto;
import entities.Client;
import mapper.ClientMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import repos.ClientRepos;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientService {
    @Autowired
    private ClientRepos clientRepos ;
    @Autowired
    private ClientMapper clientMapper ;

    public Page<ClientDto> findall(Pageable pageable){
        return clientMapper.toDTO(clientRepos.findAll(pageable));
    }

    public ClientDto findById(long id){
        Optional<Client> optionalClient =clientRepos.findById(id);
        return clientMapper.toDTO(optionalClient.get());
    }
    public ClientDto save(ClientDto clientDto){
        return clientMapper.toDTO(clientRepos.save(clientMapper.toEntity(clientDto)));
    }
 public ClientDto updateClient(long id , ClientDto clientDto){
        findById(id);
        clientDto.setId(id);
        return clientMapper.toDTO(clientRepos.save(clientMapper.toEntity(clientDto)));
 }
 public String DeleteById(long id){
        findById(id);
        clientRepos.deleteById(id);
        return "deleted";
 }




}
