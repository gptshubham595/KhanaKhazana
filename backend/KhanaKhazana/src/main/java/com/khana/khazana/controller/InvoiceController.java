package com.khana.khazana.controller;

import com.khana.khazana.model.*;
import com.khana.khazana.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.khana.khazana.service.UserService.isLoggedIn;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

//    @PostMapping(value = "/saveorderinfo", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<DefaultResponse> SaveOrderInfo(@RequestBody Invoice invoice){
//        return new ResponseEntity<>(invoiceService.SaveOrderInfo(invoice), HttpStatus.OK);
//    }

    @PostMapping(value = "/saveorderinfoList", consumes = "application/json", produces = "application/json")
    public ResponseEntity<InvoiceNoTableResponse> SaveOrderInfoList(@RequestBody InvoiceNoTableRequest invoiceNoTableRequest){
        return new ResponseEntity<>(invoiceService.SaveOrderInfoList(invoiceNoTableRequest), HttpStatus.OK);
    }

    @PostMapping(value = "/invoice", consumes = "application/json", produces = "application/json")
    public ResponseEntity<InvoiceResponse> GenerateInvoice(@RequestBody WhichUserRequest whichUserRequest){
        InvoiceResponse invoiceResponse = invoiceService.GenerateInvoice(whichUserRequest);
        if(invoiceResponse.isStatus()){
            return new ResponseEntity<>(invoiceResponse, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
