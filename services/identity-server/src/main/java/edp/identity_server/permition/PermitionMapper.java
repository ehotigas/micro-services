package edp.identity_server.permition;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import edp.identity_server.permition.dto.CreatePermitionDto;


@Mapper(componentModel = "spring")
public abstract class PermitionMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    public abstract Permition toEntity(CreatePermitionDto dto);

}
