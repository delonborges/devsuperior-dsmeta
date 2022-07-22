package com.delonborges.dsmeta.controllers;

import com.delonborges.dsmeta.entities.Sale;
import com.delonborges.dsmeta.services.SaleService;
import com.delonborges.dsmeta.services.SmsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    private final SaleService saleService;
    private final SmsService smsService;

    public SaleController(SaleService saleService, SmsService smsService) {
        this.saleService = saleService;
        this.smsService = smsService;
    }

    @GetMapping
    public Page<Sale> findSales(@RequestParam(value = "minDate", defaultValue = "") String minDate,
                                @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
                                Pageable pageable) {
        return saleService.findSales(minDate, maxDate, pageable);
    }

    @GetMapping(value = "/{id}/notifications")
    public void smsNotification(@PathVariable Long id) {
        smsService.sendSms(id);
    }
}
