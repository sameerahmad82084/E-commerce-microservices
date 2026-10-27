package com.Ecommerce.EcommerceBackend.Repository;

import com.Ecommerce.EcommerceBackend.Model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CategoryRepository extends JpaRepository<Categories,Long> {
    @Override
    Optional<Categories> findById(Long aLong);
    List<Categories>findAll();
    void deleteById(Long id);
}
