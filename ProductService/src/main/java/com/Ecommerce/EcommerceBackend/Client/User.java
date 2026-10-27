package com.Ecommerce.EcommerceBackend.Client;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private String passWord;
    private String email;
    private List<Role> role;
}
