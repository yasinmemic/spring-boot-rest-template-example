package com.microservice_example.controller;

import com.microservice_example.entity.Sale;
import com.microservice_example.model.EntityForReturn;
import com.microservice_example.model.ProductModel;
import com.microservice_example.model.SaleModel;
import com.microservice_example.model.ShippingModel;
import com.microservice_example.service.ProductService;
import com.microservice_example.service.SaleService;
import com.microservice_example.service.ShippingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sale")
@Api(value = "My SaleController")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ShippingService shippingService;

    @ApiOperation(value = "method that brings only sales.",notes = "use this method carefully.")
    @GetMapping(value = "/{saleId}")
    public EntityForReturn getSale(@PathVariable("saleId") Long saleId) {
        EntityForReturn entityForReturn = new EntityForReturn();
        SaleModel saleModel = saleService.getSales(saleId);
        entityForReturn.setSale(saleModel);
        return entityForReturn;
    }

    @ApiOperation(value = "method that brings shopping by shipping.",notes = "use this method carefully.")
    @GetMapping(value = "/{saleId}/shipping")
    public EntityForReturn getSaleByShipping(@PathVariable("saleId") Long saleId) {
        Sale sale = saleService.getSalesForProductId(saleId);

        ShippingModel shippingModel = shippingService.getShipping(saleId);
        ProductModel productModel = productService.getProduct(sale.getProductId());
        SaleModel saleModel = saleService.convertToSaleModel(sale);

        if (shippingModel.getStatus().equalsIgnoreCase("false")) {
            shippingModel.setStatus("Teslim Edilmedi");
        } else {
            shippingModel.setStatus("Teslim Edildi");
        }

        EntityForReturn entities = new EntityForReturn();
        entities.setProduct(productModel);
        entities.setSale(saleModel);
        entities.setShipping(shippingModel);
        return entities;
    }

    @ApiOperation(value = "method that brings shopping by product.",notes = "use this method carefully.")
    @GetMapping(value = "/{saleId}/product")
    public ResponseEntity<EntityForReturn> getSaleByProduct(@PathVariable("saleId") Long saleId) {
        Sale sale = saleService.getSalesForProductId(saleId);
        ProductModel productModel = productService.getProduct(sale.getProductId());
        SaleModel saleModel = saleService.convertToSaleModel(sale);
        EntityForReturn entities = new EntityForReturn();
        entities.setProduct(productModel);
        entities.setSale(saleModel);
        return new ResponseEntity<EntityForReturn>(entities, HttpStatus.OK);
    }
}
