package com.microservice_example.service;

import com.microservice_example.entity.Sale;
import com.microservice_example.model.SaleModel;

public interface SaleService {

    SaleModel getSales(Long salesId);
    Sale getSalesForProductId(Long salesId);

    SaleModel convertToSaleModel(Sale sale);
}
