package com.microservice_example.controller;

import com.microservice_example.model.ShippingModel;
import com.microservice_example.service.ShippingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shipping")
@Api(value = "My ShippingController Controller")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @ApiOperation(value = "method that brings only shipping.", notes = "use this method carefully.")
    @GetMapping(value = "/{shippingId}")
    public ShippingModel getShippingForSale(@PathVariable("shippingId") Long shippingId) {
        return shippingService.getShipping(shippingId);
    }

}
