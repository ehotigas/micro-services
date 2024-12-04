package edp.product_api.product.dto;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateProductDto {
    @Nonnull
    private String name;
    
    @Nonnull
    private Double price;
    
    private String description;
    
    @Nonnull
    private String categoryName;
    
    @Nonnull
    private String imageUrl;
}
