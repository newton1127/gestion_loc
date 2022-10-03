package com.valueit.gloc.services;

import com.valueit.gloc.entities.Client;
import com.valueit.gloc.dto.ClientDto;
import com.valueit.gloc.mapper.ClientMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.valueit.gloc.repos.ClientRepos;

import java.util.Optional;


@Service
public class ClientService {
    @Autowired
    private ClientRepos clientRepos;
    @Autowired
    private ClientMapper clientMapper;

    public ClientService() {
    }
    public static Logger log =  LoggerFactory.getLogger(ClientService.class);

    public Page<ClientDto> findall(Pageable pageable) {
        return clientMapper.toDTO(clientRepos.findAll(pageable));
    }

    public ClientDto findById(long id) {
        Optional<Client> optionalClient = clientRepos.findById(id);
        return clientMapper.toDTO(optionalClient.get());
    }

    public ClientDto save(ClientDto clientDto) {
        return clientMapper.toDTO(clientRepos.save(clientMapper.toEntity(clientDto)));
    }

    public ClientDto updateClient(long id, ClientDto clientDto) {
        findById(id);
        clientDto.setId(id);
        return clientMapper.toDTO(clientRepos.save(clientMapper.toEntity(clientDto)));
    }

    public String DeleteById(long id) {
        findById(id);
        clientRepos.deleteById(id);
        return "deleted";
    }


}
