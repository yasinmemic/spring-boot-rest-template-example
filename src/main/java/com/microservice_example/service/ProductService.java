package com.microservice_example.service;

import com.microservice_example.entity.Product;
import com.microservice_example.model.ProductModel;

public interface ProductService {

    ProductModel getProduct(Long productId);

    ProductModel convertToProductModel(Product product);
}
