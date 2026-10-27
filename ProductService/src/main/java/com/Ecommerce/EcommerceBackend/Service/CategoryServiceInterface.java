package com.Ecommerce.EcommerceBackend.Service;

import com.Ecommerce.EcommerceBackend.EcommerceException.NotFoundException;
import com.Ecommerce.EcommerceBackend.Model.Categories;

import java.util.List;

public interface CategoryServiceInterface {
    Categories getCategory(Long id)throws NotFoundException;
    List<Categories> getAllCategory()throws NotFoundException;
    Categories deleteCategory(Long id)throws NotFoundException;
    Categories addCategory(Categories categories)throws NotFoundException;
    Categories updateCategory(Long id,Categories categories)throws NotFoundException;
}
