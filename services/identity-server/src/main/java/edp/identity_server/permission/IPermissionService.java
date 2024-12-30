package edp.identity_server.permission;

import edp.identity_server.permission.dto.CreatePermissionDto;
import edp.identity_server.permission.dto.GetPermissionDto;


public interface IPermissionService {
    GetPermissionDto findAll();
    Permission findById(Long id);
    Permission save(CreatePermissionDto input);
    Permission remove(Long id);
}
