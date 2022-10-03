package com.valueit.gloc.repos;

import com.valueit.gloc.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VoitureRepos extends JpaRepository<Voiture, Integer> {
    public List<Voiture> findByMarque(String marque);
}
