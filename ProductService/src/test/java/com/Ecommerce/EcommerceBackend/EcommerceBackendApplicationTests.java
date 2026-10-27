package com.Ecommerce.EcommerceBackend;

import com.Ecommerce.EcommerceBackend.Controllers.CategoryController;
import com.Ecommerce.EcommerceBackend.Controllers.ProductController;
import com.Ecommerce.EcommerceBackend.Dto.CategoryRequest;
import com.Ecommerce.EcommerceBackend.Dto.CategoryResponse;
import com.Ecommerce.EcommerceBackend.Dto.ProductRequestDto;
import com.Ecommerce.EcommerceBackend.EcommerceException.NotFoundException;
import com.Ecommerce.EcommerceBackend.Model.Product;
import com.Ecommerce.EcommerceBackend.Service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.Date;

@SpringBootTest
class EcommerceBackendApplicationTests {
    @Autowired
    ProductController ps;
    @Autowired
    CategoryController cs;
	@Test
	void contextLoads() {
	}
    @Test
    void saveData() throws NotFoundException {
        ProductRequestDto p=new ProductRequestDto();
        p.setPrice(244);
        p.setName("shirt");
        p.setDescription("best cotton shirt");
        p.setTitle("Guchi");
        p.setCategoryName("cloth");
       //System.out.println(ps.getSingleProduct(1L).getBody().getName());
       // System.out.print(ps.CreateProduct(p).getBody().getName());

    }
    @Test
    void categoryTest()throws NotFoundException{
        CategoryRequest categoryRequest=new CategoryRequest();
        categoryRequest.setCategoryName("electronicsupdateds");
        categoryRequest.setCreated(new Date().toString());
       // ResponseEntity<CategoryResponse> c=cs.addCategory(categoryRequest);
       // ResponseEntity<CategoryResponse> cp=cs.updateCategory(1L,categoryRequest);
        ResponseEntity<CategoryResponse> cp=cs.deleteCategory(1L);

       // System.out.println(cp.getBody().getCategoryName());

    }

}
