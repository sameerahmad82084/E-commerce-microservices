package com.Ecommerce.EcommerceBackend.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity(name="Categories")
public class Categories extends BaseModel {
    private String categoriesName;
    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
