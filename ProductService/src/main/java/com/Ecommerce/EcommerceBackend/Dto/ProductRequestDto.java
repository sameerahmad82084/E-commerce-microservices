package com.Ecommerce.EcommerceBackend.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class ProductRequestDto {
    private double price;
    private String name;
    private Long id;
    private String CategoryName;
    private String title;
    private String description;
}
