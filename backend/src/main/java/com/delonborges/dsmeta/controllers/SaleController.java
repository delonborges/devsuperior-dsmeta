package com.delonborges.dsmeta.controllers;

import com.delonborges.dsmeta.entities.Sale;
import com.delonborges.dsmeta.services.SaleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    public List<Sale> findSales() {
        return saleService.findSales();
    }

}
