package com.valueit.gloc.controllers;

import com.valueit.gloc.services.ClientService;
import com.valueit.gloc.dto.ClientDto;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping
    public ResponseEntity<Page<ClientDto>> findAll(Pageable page) {
        return new ResponseEntity<>(clientService.findall(page), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(clientService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<ClientDto> save(@RequestBody ClientDto client) {
        return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable Long id) {
        clientService.DeleteById(id);
        return new ResponseEntity<>("Done: Client deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> updateClient(@RequestBody ClientDto client, @PathVariable Long id) {
        return ResponseEntity.accepted().body(clientService.updateClient(id, client));
    }
}

