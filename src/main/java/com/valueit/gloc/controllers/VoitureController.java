package com.valueit.gloc.controllers;
import com.valueit.gloc.dto.VoitureDto;
import com.valueit.gloc.services.VoitureService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/voitures")
public class VoitureController {
    private final VoitureService voitureService ;

    public VoitureController(VoitureService voitureService) {
        this.voitureService = voitureService;
    }

    @PostMapping
    ResponseEntity<VoitureDto> save(@RequestBody VoitureDto voitureDto) {
        return new ResponseEntity<>(voitureService.save(voitureDto), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Page<VoitureDto>> findAll(Pageable page) {
        return new ResponseEntity<>(voitureService.findall(page), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<VoitureDto> findById(@PathVariable int id) {
        return new ResponseEntity<>(voitureService.findbyID(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable int id) {
        voitureService.DeleteById(id);
        return new ResponseEntity<>("Done: Client deleted successfully", HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<VoitureDto> updateVoiture(@RequestBody VoitureDto voitureDto, @PathVariable int id ) {
        return ResponseEntity.accepted().body(voitureService.updateVoiture(id, voitureDto));
    }
}
