package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.model.ProductRequest;
import com.example.demo.model.ProductResponse;
import com.example.demo.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;


    public void saveProduct(ProductRequest productRequest) {
        Product product= Product.builder()
                .name(productRequest.getName())
                .category(productRequest.getCategory())
                .rating(productRequest.getRating())
                .value(productRequest.getValue())
                .build();

        productRepo.save(product);



    }

    public ProductResponse findById(String id) {

        ProductResponse product=productRepo.findById(id).map(this::mapToProductResponse).get();
        return product;


    }

    private ProductResponse mapToProductResponse(Product product){
        ProductResponse productResponse=ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .category(product.getCategory())
                .value(product.getValue())
                .rating(product.getRating())
                .build();
        return productResponse;
    }

}
