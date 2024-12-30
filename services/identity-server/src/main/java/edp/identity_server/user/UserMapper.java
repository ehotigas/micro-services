package edp.identity_server.user;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import edp.identity_server.user.dto.CreateUserDto;
import edp.identity_server.user.dto.UpdateUserDto;


@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "permissions", ignore = true)
    User toEntity(CreateUserDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "username", ignore = true)
    @Mapping(target = "permissions", ignore = true)
    User partialUpdate(@MappingTarget User entity, UpdateUserDto dto);
}
