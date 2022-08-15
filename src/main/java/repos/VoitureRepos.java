package repos;

import entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoitureRepos extends JpaRepository<Voiture, Integer> {
    public List<Voiture> findByOrderBymarque(String m);
}
