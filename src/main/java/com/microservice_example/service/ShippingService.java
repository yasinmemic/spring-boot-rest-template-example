package com.microservice_example.service;

import com.microservice_example.entity.Shipping;
import com.microservice_example.model.ShippingModel;

public interface ShippingService {

    ShippingModel getShipping(Long shippingId);

    ShippingModel convertToShipingModel(Shipping shipping);

}
