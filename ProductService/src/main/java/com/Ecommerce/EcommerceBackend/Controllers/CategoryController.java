package com.Ecommerce.EcommerceBackend.Controllers;

import com.Ecommerce.EcommerceBackend.Dto.CategoryRequest;
import com.Ecommerce.EcommerceBackend.Dto.CategoryResponse;
import com.Ecommerce.EcommerceBackend.EcommerceException.NotFoundException;
import com.Ecommerce.EcommerceBackend.Model.Categories;
import com.Ecommerce.EcommerceBackend.Service.CategoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryServiceInterface categoryService;
    private CategoryResponse categoryResponse(Categories categories){
        CategoryResponse categoryResponse=new CategoryResponse();
        categoryResponse.setCategoryName(categories.getCategoriesName());
        categoryResponse.setId(categories.getId());
        return categoryResponse;
    }
    public ResponseEntity<CategoryResponse> getCategory(Long id)throws NotFoundException {
       ResponseEntity<CategoryResponse> category=new ResponseEntity<>(
               categoryResponse(categoryService.getCategory(id)), HttpStatus.OK);
       return category;

    }
    public ResponseEntity<List<CategoryResponse>> getAllCategory()throws NotFoundException{
        List<Categories> categoriesList=categoryService.getAllCategory();
        List<CategoryResponse>responses=new ArrayList<>();
        for(Categories c:categoriesList){
            responses.add(categoryResponse(c));
        }
        ResponseEntity<List<CategoryResponse>> response=new ResponseEntity<>(responses,HttpStatus.OK);
        return response;
    }
    public ResponseEntity<CategoryResponse>deleteCategory(Long id) throws NotFoundException {
        Categories categories= categoryService.deleteCategory(id);
        ResponseEntity<CategoryResponse> response=new ResponseEntity<>(
                categoryResponse(categories),HttpStatus.OK
        );
        return response;
    }
    public ResponseEntity<CategoryResponse>addCategory(CategoryRequest category) throws NotFoundException {
        Categories categories = new Categories();
        categories.setCategoriesName(category.getCategoryName());
        categories.setCreatedAt(category.getCreated());
        ResponseEntity<CategoryResponse>response=new ResponseEntity<>(
                categoryResponse(categoryService.addCategory(categories)),HttpStatus.OK);
        return response;
    }
    public ResponseEntity<CategoryResponse>updateCategory(Long id,CategoryRequest category) throws NotFoundException {
        Categories categories= new Categories();
        categories.setCategoriesName(category.getCategoryName());
        categories.setCreatedAt(category.getCreated());
        ResponseEntity<CategoryResponse> response=new ResponseEntity<>(
                categoryResponse(categoryService.updateCategory(id,categories)),
                HttpStatus.OK);
        return response;
    }

}
