package com.Ecommerce.EcommerceBackend.Repository;

import com.Ecommerce.EcommerceBackend.Model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
}
