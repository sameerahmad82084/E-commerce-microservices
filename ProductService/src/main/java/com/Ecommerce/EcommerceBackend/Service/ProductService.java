package com.Ecommerce.EcommerceBackend.Service;
import com.Ecommerce.EcommerceBackend.EcommerceException.NotFoundException;
import com.Ecommerce.EcommerceBackend.Model.Product;
import com.Ecommerce.EcommerceBackend.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceInterface {

private ProductRepository productRepository;
    @Autowired
    ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    public Product getProduct(Long id) throws NotFoundException{
        Optional<Product>product=productRepository.findById(id);
        if(product.isEmpty()){
            throw new NotFoundException("No any product with "+id);
        }
        return product.get();

    }
    @Override
    public List<Product>getAll()throws NotFoundException{
        List<Product> products=productRepository.findAll();
        if(products.isEmpty()){
            throw new NotFoundException("There is no any product");
        }
        return products;
    }
    public Product addProduct(Product product) throws NotFoundException {
        if(product==null){
            throw new NotFoundException("there is no data");
        }
      Product p=productRepository.save(product);
        return p;

    }
    public Product deleteProduct(Long id) throws NotFoundException {
        Optional<Product> product=productRepository.findById(id);
        if(product.isEmpty()){
            throw new NotFoundException("No product with id "+id);
        }
        productRepository.deleteById(id);
        return product.get();
    }
    public Product updateProduct(Long id,Product product) throws NotFoundException {
        Optional<Product>produc=productRepository.findById(id);
        if(produc.isEmpty()){
            throw new NotFoundException("No product with id "+id);

        }
        product.setId(id);

        return productRepository.save(product);
    }
}
