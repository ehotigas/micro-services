package edp.identity_server.user.permition;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edp.identity_server.user.User;

@Repository
public interface IUserPermitionRepository extends JpaRepository<UserPermition, Long> {
    List<UserPermition> findAllByUser(User user);
}
