package com.mehdisarf.StartSpringImplMehdiSarf.controllers;

import com.mehdisarf.StartSpringImplMehdiSarf.model.PaymentDetails;
import com.mehdisarf.StartSpringImplMehdiSarf.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Controller’s action that no longer treats the exception case.
    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public ResponseEntity<?> makePayment() {

        PaymentDetails paymentDetails = paymentService.processPayment();

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(paymentDetails);
    }
}
