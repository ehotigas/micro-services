package edp.identity_server.permition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPermitionRepository extends JpaRepository<Permition, Long> {
    
}
