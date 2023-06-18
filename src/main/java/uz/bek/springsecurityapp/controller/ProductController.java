package uz.bek.springsecurityapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.bek.springsecurityapp.entity.Product;
import uz.bek.springsecurityapp.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * GET Products
     * @return List<Product>
     */
    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }

    /**
     * GET Product By Id
     * @param id
     * @return Product
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id){
        Product product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    /**
     * ADD Product
     * @param product
     * @return Product
     */
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product product1 = productService.addProduct(product);
        return ResponseEntity.ok(product1);
    }

    /**
     * EDIT Product
     * @param product
     * @param id
     * @return Product
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> editProduct(@RequestBody Product product, @PathVariable Integer id){
        Product editProduct = productService.editProduct(product, id);
        return ResponseEntity.ok(editProduct);
    }

    /**
     * DELETE Product
     * @param id
     * @return Product
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id){
        String deleteProduct = productService.deleteProduct(id);
        return ResponseEntity.ok(deleteProduct);
    }
}
