package edp.product_api.product;

import edp.product_api.product.dto.CreateProductDto;
import edp.product_api.product.dto.GetProductDto;
import edp.product_api.product.dto.UpdateProductDto;


public interface IProductService {
    GetProductDto findAll(Product filter);
    Product findById(Long id);
    Product save(CreateProductDto input);
    Product update(Long id, UpdateProductDto input);
    Product remove(Long id);
}
