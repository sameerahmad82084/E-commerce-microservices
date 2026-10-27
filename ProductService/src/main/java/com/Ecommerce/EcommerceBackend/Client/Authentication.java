package com.Ecommerce.EcommerceBackend.Client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Authentication {
    private RestTemplateBuilder restTemplateBuilder;
    public Authentication(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }

    public ResponseEntity<UserResponseDto> validate(String token,Long id){
        UserRequestDto request=new UserRequestDto();
        request.setId(id);
        request.setToken(token);
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<UserResponseDto> userDetails=restTemplate.postForEntity(
                "http://localhost:8080/auth/validate",request,
        UserResponseDto.class);
        return userDetails;
    }
}
