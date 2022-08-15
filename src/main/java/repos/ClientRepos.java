package repos;

import entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepos extends JpaRepository<Client,Long> {
}
