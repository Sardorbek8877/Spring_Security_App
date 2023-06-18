package uz.bek.springsecurityapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.bek.springsecurityapp.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
