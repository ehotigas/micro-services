package edp.product_api.product.dto;

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
public class UpdateProductDto {
    private String name;
    private Double price;
    private String description;
    private String categoryName;
    private String imageUrl;
}
