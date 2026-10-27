package com.Ecommerce.EcommerceBackend.Service;

import com.Ecommerce.EcommerceBackend.EcommerceException.NotFoundException;
import com.Ecommerce.EcommerceBackend.Model.Categories;
import com.Ecommerce.EcommerceBackend.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements CategoryServiceInterface {
@Autowired
private CategoryRepository categoryRepository;
    @Override
    public Categories getCategory(Long id) throws NotFoundException {
        Optional<Categories>categories=categoryRepository.findById(id);
        if(categories.isEmpty()){
            throw new NotFoundException("No Category With id "+id);
        }
        return categories.get();
    }

    @Override
    public List<Categories> getAllCategory() throws NotFoundException {
        List<Categories>categories=categoryRepository.findAll();
        if(categories.isEmpty()){
            throw new NotFoundException("Not Category");
        }
      return categories;
    }

    @Override
    public Categories deleteCategory(Long id) throws NotFoundException {
      Optional<Categories>categories=categoryRepository.findById(id);
      if(categories.isEmpty()){
          throw new NotFoundException("No category With id "+id);
      }
      categoryRepository.deleteById(id);
      return categories.get();
    }

    @Override
    public Categories addCategory(Categories categories) throws NotFoundException {
        if(categories==null){
            throw new NotFoundException("Categories don't have a data");
        }
        Categories categories1=categoryRepository.save(categories);

        return categories1;
    }

    @Override
    public Categories updateCategory(Long id, Categories categories) throws NotFoundException {
        Optional<Categories>categories1= categoryRepository.findById(id);
        if(categories1.isEmpty()){
            throw new NotFoundException("categories not found");
        }
        categories.setId(id);
        categoryRepository.save(categories);
        return categoryRepository.save(categories);
    }

}
