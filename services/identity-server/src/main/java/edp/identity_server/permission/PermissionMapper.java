package edp.identity_server.permission;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import edp.identity_server.permission.dto.CreatePermissionDto;


@Mapper(componentModel = "spring")
public abstract class PermissionMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "userPermission", ignore = true)
    public abstract Permission toEntity(CreatePermissionDto dto);

}
