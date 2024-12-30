package edp.identity_server.permission;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edp.identity_server.global.exception.NotFoundException;
import edp.identity_server.permission.dto.CreatePermissionDto;
import edp.identity_server.permission.dto.GetPermissionDto;


@Service
public class PermissionService implements IPermissionService {
    @Autowired
    private IPermissionRepository repository;

    @Autowired
    private PermissionMapper mapper;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    

    @Override
    public GetPermissionDto findAll() {
        logger.info("Fetching all Permissions");
        List<Permission> Permissions = repository.findAll();
        return new GetPermissionDto(Permissions);
    }

    @Override
    public Permission findById(Long id) {
        logger.info("Fetching Permission with id: " + id);
        return repository.findById(id).orElseThrow(() -> {
            logger.warn("Fail to fetch Permission with id: " + id + ". Not found.");
            throw new NotFoundException("Fail to fetch Permission with id: " + id + ". Not found.");
        });
    }

    @Override
    public Permission remove(Long id) {
        logger.info("Removing Permission with id: " + id);
        Permission Permission = repository.findById(id).orElseThrow(() -> {
            logger.warn("Fail to remove Permission with id: " + id + ". Not found.");
            throw new NotFoundException("Fail to remove Permission with id: " + id + ". Not found.");
        });
        repository.delete(Permission);
        return Permission;
    }

    @Override
    public Permission save(CreatePermissionDto input) {
        logger.info("Saving new Permission with: " + input);
        Permission persistPermission = mapper.toEntity(input);
        persistPermission.setCreatedAt(LocalDateTime.now());
        
        return repository.save(persistPermission);
    }
}
