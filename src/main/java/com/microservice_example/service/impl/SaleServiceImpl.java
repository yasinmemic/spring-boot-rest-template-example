package com.microservice_example.service.impl;

import com.microservice_example.entity.Sale;
import com.microservice_example.model.SaleModel;
import com.microservice_example.service.SaleService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SaleServiceImpl implements SaleService {

    private String apiUrl = "http://5e209e06e31c6e0014c60962.mockapi.io/api/sales";

    public SaleModel getSales(Long salesId) {
        String getSalesUrl = apiUrl + "/" + salesId;
        RestTemplate restTemplate = new RestTemplate();
        Sale sale = restTemplate.getForEntity(getSalesUrl, Sale.class).getBody();
        SaleModel saleModel = convertToSaleModel(sale);
        return saleModel;
    }

    public Sale getSalesForProductId(Long salesId) {
        String getSalesUrl = apiUrl + "/" + salesId;
        RestTemplate restTemplate = new RestTemplate();
        Sale sale = restTemplate.getForEntity(getSalesUrl, Sale.class).getBody();
        return sale;
    }


    public SaleModel convertToSaleModel(Sale sale) {
        SaleModel saleModel = new SaleModel();
        saleModel.setId(sale.getId());
        saleModel.setSaleCode(sale.getSaleCode());
        return saleModel;
    }

}
