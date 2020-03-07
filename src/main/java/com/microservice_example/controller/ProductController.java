package com.microservice_example.controller;

import com.microservice_example.model.ProductModel;
import com.microservice_example.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
@Api(value = "My Product Controller")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "method that brings only products.",notes = "use this method carefully.")
    @GetMapping(value = "/{productId}")
    public ProductModel getProduct(@PathVariable("productId") Long productId) {
        return productService.getProduct(productId);
    }


}
