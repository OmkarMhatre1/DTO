package com.example.demo.controller;

import com.example.demo.model.ProductRequest;
import com.example.demo.model.ProductResponse;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;


    @PostMapping
    public ResponseEntity<ProductRequest> saveProduct(@RequestBody ProductRequest productRequest){
        productService.saveProduct(productRequest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") String id){

        ProductResponse productResponse = productService.findById(id);
        return new ResponseEntity<>(productResponse,HttpStatus.OK);

    }


}
