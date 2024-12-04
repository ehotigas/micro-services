package edp.product_api.product;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import edp.product_api.product.dto.CreateProductDto;
import edp.product_api.product.dto.UpdateProductDto;


@Mapper(componentModel = "spring")
public interface IProductMapper {
    @Mapping(target = "id", ignore = true)
    Product toEntity(CreateProductDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    Product partialUpdate(@MappingTarget Product enity, UpdateProductDto dto);
}
