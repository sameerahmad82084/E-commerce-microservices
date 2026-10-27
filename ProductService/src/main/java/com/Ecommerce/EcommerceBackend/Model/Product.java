package com.Ecommerce.EcommerceBackend.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="Products")
public class Product extends BaseModel {
    private String name;
    private String title;
    private String Description;
    private double price;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Categories category;
}
