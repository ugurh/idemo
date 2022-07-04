package io.ugurh.products.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    @GetMapping
    public ResponseEntity<String> productInfo(){
        return new ResponseEntity<>("Product Info...",HttpStatus.OK);
    }
}
