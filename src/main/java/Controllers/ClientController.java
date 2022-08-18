package Controllers;

import Services.ClientService;
import dto.ClientDto;
import entities.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repos.ClientRepos;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
  private Client client ;

    @Autowired
    private ClientService clientService ;

    @GetMapping
    public ResponseEntity<Page<ClientDto>> findAll(Pageable page) {

        return new ResponseEntity<>(clientService.findall(page), HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable  Long id) {
        return new ResponseEntity<>(clientService.findById(id), HttpStatus.OK);
    }
    @PostMapping("/create")
    ResponseEntity<ClientDto> save(@RequestBody ClientDto client) {
        return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> delete(@PathVariable Long id) {
        clientService.DeleteById(id);
        return new ResponseEntity<>("Done: Client deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClientDto> updateClient(@RequestBody ClientDto client, @PathVariable Long id) {
        return ResponseEntity.accepted().body(clientService.updateClient(id,client));
    }
}

