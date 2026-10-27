package com.Ecommerce.EcommerceBackend.Client;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class UserResponseDto {
    private String name;
    private ArrayList<String> role;
    private  String email;
    private SessionStatus sessionStatus;
}
