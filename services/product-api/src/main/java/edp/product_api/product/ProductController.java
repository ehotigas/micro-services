package edp.product_api.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edp.product_api.product.dto.CreateProductDto;
import edp.product_api.product.dto.GetProductDto;
import edp.product_api.product.dto.UpdateProductDto;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService service;

    @GetMapping
    public ResponseEntity<GetProductDto> findAll(
        @RequestParam(name = "id", required = false) Long id,
        @RequestParam(name = "name", required = false) String name,
        @RequestParam(name = "price", required = false) Double price,
        @RequestParam(name = "description", required = false) String description,
        @RequestParam(name = "categoryName", required = false) String categoryName,
        @RequestParam(name = "imageUrl", required = false) String imageUrl
    ) {
        Product filter = new Product(id, name, price, description, categoryName, imageUrl);
        return ResponseEntity.ok().body(service.findAll(filter));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Product> save(@Valid @RequestBody CreateProductDto input) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(input));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") Long id, @Valid @RequestBody UpdateProductDto input) {
        return ResponseEntity.ok().body(service.update(id, input));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> remove(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.remove(id));
    }
}
