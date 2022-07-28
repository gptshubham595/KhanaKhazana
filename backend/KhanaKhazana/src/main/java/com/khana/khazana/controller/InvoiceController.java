package com.khana.khazana.controller;

import com.khana.khazana.model.DefaultResponse;
import com.khana.khazana.model.Invoice;
import com.khana.khazana.model.InvoiceResponse;
import com.khana.khazana.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @PostMapping(value = "/saveorderinfo", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DefaultResponse> SaveOrderInfo(@RequestBody Invoice invoice){
        return new ResponseEntity<>(invoiceService.SaveOrderInfo(invoice), HttpStatus.OK);
    }

    @GetMapping(value = "/invoice/{userId}")
    public ResponseEntity<InvoiceResponse> GenerateInvoice(@PathVariable long userId){
        return new ResponseEntity<>(invoiceService.GenerateInvoice(userId), HttpStatus.OK);
    }


}
