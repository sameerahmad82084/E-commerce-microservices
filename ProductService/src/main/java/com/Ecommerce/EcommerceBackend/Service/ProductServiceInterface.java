package com.Ecommerce.EcommerceBackend.Service;

import com.Ecommerce.EcommerceBackend.EcommerceException.NotFoundException;
import com.Ecommerce.EcommerceBackend.Model.Categories;
import com.Ecommerce.EcommerceBackend.Model.Product;

import java.util.List;

public interface ProductServiceInterface {
    Product getProduct(Long id)throws NotFoundException;
    List<Product> getAll()throws NotFoundException;
    Product deleteProduct(Long id)throws NotFoundException;
    Product addProduct(Product product)throws NotFoundException;
    Product updateProduct(Long id,Product product)throws NotFoundException;
}
