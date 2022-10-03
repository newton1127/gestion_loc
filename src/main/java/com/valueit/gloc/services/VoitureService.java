package com.valueit.gloc.services;

import com.valueit.gloc.dto.ClientDto;
import com.valueit.gloc.dto.VoitureDto;
import com.valueit.gloc.entities.Client;
import com.valueit.gloc.entities.Voiture;
import com.valueit.gloc.mapper.VoitureMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.valueit.gloc.repos.VoitureRepos;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VoitureService {
    @Autowired
    private final VoitureRepos voiture_repos ;
@Autowired
   private VoitureMapper voitureMapper ;

    public VoitureService(VoitureRepos voiture_repos) {
        this.voiture_repos = voiture_repos;
    }


    public Page<VoitureDto> findall(Pageable pageable) {
        return voitureMapper.toDTO(voiture_repos.findAll(pageable));
    }



    public VoitureDto findbyID(int id){
        Optional<Voiture> optionalVoiture = voiture_repos.findById(id);
        return voitureMapper.toDTO(optionalVoiture.get());


    }
    public VoitureDto save(VoitureDto voituredto) {
        return voitureMapper.toDTO(voiture_repos.save(voitureMapper.toEntity(voituredto)));
    }
    public String DeleteById(int id) {
        findbyID(id);
        voiture_repos.deleteById(id);
        return "deleted";
    }
    public VoitureDto updateVoiture(int id , VoitureDto voitureDto){
        findbyID(id);
        voitureDto.setVoiture_Id(id);
        return voitureMapper.toDTO(voiture_repos.save(voitureMapper.toEntity(voitureDto)));
    }
}
