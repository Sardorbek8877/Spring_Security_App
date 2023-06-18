package uz.bek.springsecurityapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bek.springsecurityapp.entity.Product;
import uz.bek.springsecurityapp.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    /**
     * GET Products
     * @return List<Product>
     */
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    /**
     * GET Product By Id
     * @param id
     * @return Product
     */
    public Product getProduct(Integer id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    /**
     * ADD Product
     * @param product
     * @return Product
     */
    public Product addProduct(Product product){
        productRepository.save(product);
        return product;
    }

    /**
     * EDIT Product
     * @param product
     * @param id
     * @return Product
     */
    public Product editProduct(Product product, Integer id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty())
            return new Product();
        Product editingProduct = optionalProduct.get();
        editingProduct.setName(product.getName());
        productRepository.save(editingProduct);
        return editingProduct;
    }

    /**
     * DELETE Product
     * @param id
     * @return Product
     */
    public String deleteProduct(Integer id){
        productRepository.deleteById(id);
        return "Product deleted";
    }
}
