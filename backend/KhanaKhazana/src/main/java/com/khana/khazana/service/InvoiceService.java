package com.khana.khazana.service;

import com.khana.khazana.model.DefaultResponse;
import com.khana.khazana.model.Invoice;
import com.khana.khazana.model.InvoiceResponse;
import com.khana.khazana.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    public DefaultResponse SaveOrderInfo(Invoice invoice){
        DefaultResponse defaultResponse = new DefaultResponse();
        try{
            invoiceRepository.save(invoice);
            defaultResponse.setStatus(true);
            defaultResponse.setMessage("Order info saved");
        }catch (Exception e){
            defaultResponse.setStatus(false);
            defaultResponse.setMessage("Error occurred while saving order info. \n"+e.toString());
        }

        return defaultResponse;
    }

    public InvoiceResponse GenerateInvoice(long userId) {
        List<Invoice> OrderHistory =  invoiceRepository.findAllByuserIdOrderBytimestampDesc(userId);
        InvoiceResponse invoiceResponse = new InvoiceResponse();
        invoiceResponse.setEntries(OrderHistory);
        return invoiceResponse;
    }
}
