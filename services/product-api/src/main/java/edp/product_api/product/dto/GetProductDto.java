package edp.product_api.product.dto;

import java.util.List;

import edp.product_api.product.Product;
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
public class GetProductDto {
    private List<Product> productList;
}
