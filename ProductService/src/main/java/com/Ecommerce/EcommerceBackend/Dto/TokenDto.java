package com.Ecommerce.EcommerceBackend.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenDto {
    private String token;
    private Long userId;
}
