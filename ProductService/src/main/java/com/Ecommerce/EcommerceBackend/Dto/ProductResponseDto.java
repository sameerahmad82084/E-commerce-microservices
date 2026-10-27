package com.Ecommerce.EcommerceBackend.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
@Getter
@Setter
@Component
public class ProductResponseDto {
    private double price;
    private String name;
    private Long id;
    private String CategoryName;
    private String title;
    private String description;
}
