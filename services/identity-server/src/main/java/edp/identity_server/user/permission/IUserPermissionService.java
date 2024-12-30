package edp.identity_server.user.permission;

import edp.identity_server.user.permission.dto.CreateUserPermissionDto;
import edp.identity_server.user.permission.dto.GetUserPermissionDto;

public interface IUserPermissionService {
    GetUserPermissionDto findAllByUser(Long userId);
    UserPermission save(CreateUserPermissionDto input);
    UserPermission remove(Long id);
}
