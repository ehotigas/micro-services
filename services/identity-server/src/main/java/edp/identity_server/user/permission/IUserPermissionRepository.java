package edp.identity_server.user.permission;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edp.identity_server.user.User;

@Repository
public interface IUserPermissionRepository extends JpaRepository<UserPermission, Long> {
    List<UserPermission> findAllByUser(User user);
}
