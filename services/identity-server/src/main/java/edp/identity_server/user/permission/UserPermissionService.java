package edp.identity_server.user.permission;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edp.identity_server.global.exception.NotFoundException;
import edp.identity_server.permission.IPermissionService;
import edp.identity_server.permission.Permission;
import edp.identity_server.user.IUserService;
import edp.identity_server.user.User;
import edp.identity_server.user.permission.dto.CreateUserPermissionDto;
import edp.identity_server.user.permission.dto.GetUserPermissionDto;


@Service
public class UserPermissionService implements IUserPermissionService {
    @Autowired
    private IUserPermissionRepository repository;

    @Autowired
    private IUserService userService;

    @Autowired
    private IPermissionService permissionService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public GetUserPermissionDto findAllByUser(Long userId) {
        logger.info("Fetching all user permissions with user id: " + userId);
        User user = userService.findById(userId);
        List<UserPermission> userPermissions = repository.findAllByUser(user);
        return new GetUserPermissionDto(userPermissions);
    }

    @Override
    public UserPermission remove(Long id) {
        logger.info("Removing user permission with id: " + id);
        UserPermission permission = repository.findById(id).orElseThrow(() -> {
            logger.warn("Fail to remove user permission with id: " + id + ". Not found.");
            throw new NotFoundException("Fail to remove user permission with id: " + id + ". Not found.");
        });
        repository.delete(permission);
        return permission;
    }

    @Override
    public UserPermission save(CreateUserPermissionDto input) {
        logger.info("Saving user permission with: " + input);
        User user = userService.findById(input.getUser());
        Permission permission = permissionService.findById(input.getPermission());
        UserPermission userPermission = UserPermission.builder().user(user).permission(permission).build();
        return repository.save(userPermission);
    }
}
