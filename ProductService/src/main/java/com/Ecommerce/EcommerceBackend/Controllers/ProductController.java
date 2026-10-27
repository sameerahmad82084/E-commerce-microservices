package com.Ecommerce.EcommerceBackend.Controllers;

import com.Ecommerce.EcommerceBackend.Client.Authentication;
import com.Ecommerce.EcommerceBackend.Dto.ProductRequestDto;
import com.Ecommerce.EcommerceBackend.Dto.ProductResponseDto;
import com.Ecommerce.EcommerceBackend.EcommerceException.NotFoundException;
import com.Ecommerce.EcommerceBackend.Model.Categories;
import com.Ecommerce.EcommerceBackend.Model.Product;
import com.Ecommerce.EcommerceBackend.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("Products")
public class ProductController {

    private final ProductService productService;
    private Authentication authentication;
    @Autowired
    ProductController(ProductService productService, Authentication authentication){
        this.productService=productService;
        this.authentication=authentication;
    }

    private ProductResponseDto productResponseDto(Product product){
        ProductResponseDto resProduct=new ProductResponseDto();
        resProduct.setId(product.getId());
        resProduct.setName(product.getCategory().getCategoriesName());
        resProduct.setTitle(product.getTitle());
        resProduct.setDescription(product.getDescription());
       return resProduct;

    }
    @GetMapping("/getSingle/{id}")
    public ResponseEntity<ProductResponseDto> getSingleProduct(@RequestHeader  ("token")String toke,
                                                               @RequestHeader("id") Long uId
            ,@PathVariable("id") Long id) throws NotFoundException {
//        TokenDto token=new TokenDto();
//        token.setToken(toke);
//        token.setUserId(uId);
//        if(token.getToken()==null){
//            throw new NotFoundException("user not valid");
//        }
//        if(token.getUserId()==null){
//            throw new NotFoundException("user not valid with token id");
//        }
//        ResponseEntity<UserResponseDto> user=authentication.validate(token.getToken(),token.getUserId());
//        if(!user.getBody().getSessionStatus().equals(SessionStatus.ACTIVE)){
//            throw new NotFoundException("user not valid with token id");
//        }
//        boolean isAdmin=false;
//        for(String role:user.getBody().getRole()){
//            if(role.equals("admin")){
//                isAdmin=true;
//            }
//        }
//        if(!isAdmin){
//            throw new NotFoundException("not a admin"+user.getBody().getName()+" "+user.getBody().getEmail());
//
//        }

        Product product=productService.getProduct(id);
        ProductResponseDto  productResponseDto=productResponseDto(product);
        return new ResponseEntity<>(productResponseDto, HttpStatus.OK);
    }
    @GetMapping("/GetAll")
    public ResponseEntity<List<ProductResponseDto>> getAllProduct() throws NotFoundException {
        List<Product> products=productService.getAll();
        List<ProductResponseDto>responseProduct=new ArrayList<>();
        for(Product product:products) {
            ProductResponseDto resProduct=productResponseDto(product);
            responseProduct.add(resProduct);
        }
        return new ResponseEntity<>(responseProduct,HttpStatus.OK);
    }
    @PostMapping("create")
    public ResponseEntity<ProductResponseDto> CreateProduct(ProductRequestDto p)throws NotFoundException{
        Product product=new Product();
        product.setName(p.getName());
        product.setTitle(p.getTitle());
        product.setDescription(p.getDescription());
        product.setPrice(p.getPrice());
        Categories categories=new Categories();
        categories.setCategoriesName(p.getCategoryName());
        product.setCategory(categories);
        Product rpProduct=productService.addProduct(product);
        return new ResponseEntity<>(productResponseDto(rpProduct),HttpStatus.OK);
    }
    @PatchMapping("/update")
    public ResponseEntity<ProductResponseDto> updateProduct(Long id, ProductRequestDto p)throws NotFoundException{
        Product product=new Product();
        product.setName(p.getName());
        product.setTitle(p.getTitle());
        product.setDescription(p.getDescription());
        product.setPrice(p.getPrice());
        Product rpProduct=productService.updateProduct(id,product);
        return new ResponseEntity<>(productResponseDto(rpProduct),HttpStatus.OK);
    }
    @DeleteMapping("/Delete")
    public ResponseEntity<ProductResponseDto> deleteProduct (Long id)throws NotFoundException{
        Product product= productService.deleteProduct(id);
        return new ResponseEntity<>(productResponseDto(product),HttpStatus.OK);
    }

}
