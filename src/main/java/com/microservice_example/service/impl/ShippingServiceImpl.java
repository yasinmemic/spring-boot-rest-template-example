package com.microservice_example.service.impl;

import com.microservice_example.entity.Shipping;
import com.microservice_example.model.ShippingModel;
import com.microservice_example.service.ShippingService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShippingServiceImpl implements ShippingService {

    private String apiUrl = "http://5e209e06e31c6e0014c60962.mockapi.io/api/shipping";

    public ShippingModel getShipping(Long shippingId) {
        String getShippingUrl = apiUrl + "/" + shippingId;
        RestTemplate restTemplate = new RestTemplate();
        Shipping shipping = restTemplate.getForEntity(getShippingUrl, Shipping.class).getBody();
        ShippingModel shippingModel = convertToShipingModel(shipping);
        return shippingModel;
    }

    public ShippingModel convertToShipingModel(Shipping shipping){
        ShippingModel shippingModel = new ShippingModel();
        shippingModel.setStatus(shipping.getStatus().toString());
        return shippingModel;
    }
}
