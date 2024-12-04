package edp.product_api.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import edp.product_api.global.exception.NotFoundException;
import edp.product_api.product.dto.CreateProductDto;
import edp.product_api.product.dto.GetProductDto;
import edp.product_api.product.dto.UpdateProductDto;


@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository repository;

    @Autowired
    private IProductMapper mapper;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public GetProductDto findAll(Product filter) {
        logger.info("Fetching all products with: " + filter);
        List<Product> productList = repository.findAll(
            Example.of(filter, ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING))
        );
        return new GetProductDto(productList); 
    }

    @Override
    public Product findById(Long id) {
        logger.info("Fetching product with id: " + id);
        return repository.findById(id).orElseThrow(() -> {
            logger.error("Fail to fetch product with id: " + id + ". Not found");
            throw new NotFoundException("Fail to fetch product with id: " + id + ". Not found");
        });
    }

    @Override
    public Product remove(Long id) {
        logger.info("Removing product with id: " + id);
        Product product = repository.findById(id).orElseThrow(() -> {
            logger.error("Fail to remove product with id: " + id + ". Not found");
            throw new NotFoundException("Fail to remove product with id: " + id + ". Not found");
        });
        repository.delete(product);
        return product;
    }

    @Override
    public Product save(CreateProductDto input) {
        logger.info("Saving new product with: " + input); 
        return repository.save(mapper.toEntity(input));
    }

    @Override
    public Product update(Long id, UpdateProductDto input) {
        logger.info("Updating product with id: " + id);
        Product product = repository.findById(id).orElseThrow(() -> {
            logger.error("Fail to update product with id: " + id + ". Not found");
            throw new NotFoundException("Fail to update product with id: " + id + ". Not found");
        });
        product = mapper.partialUpdate(product, input);
        return repository.save(product);
    }
}
