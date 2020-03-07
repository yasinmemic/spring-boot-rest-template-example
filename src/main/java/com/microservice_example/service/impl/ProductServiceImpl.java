package com.microservice_example.service.impl;

import com.microservice_example.entity.Product;
import com.microservice_example.model.ProductModel;
import com.microservice_example.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl implements ProductService {

    private String apiUrl = "http://5e209e06e31c6e0014c60962.mockapi.io/api/products";

    public ProductModel getProduct(Long productId) {
        String getProductUrl = apiUrl + "/" + productId;
        RestTemplate restTemplate = new RestTemplate();
        Product product = restTemplate.getForEntity(getProductUrl, Product.class).getBody();
        ProductModel productModel = convertToProductModel(product);
        return productModel;
    }

    public ProductModel convertToProductModel(Product product) {
        ProductModel productModel = new ProductModel();
        productModel.setId(product.getId());
        productModel.setName(product.getName());
        productModel.setPrice(product.getPrice());
        return productModel;
    }
}
