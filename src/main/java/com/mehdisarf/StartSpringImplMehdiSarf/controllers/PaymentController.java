package com.mehdisarf.StartSpringImplMehdiSarf.controllers;

import com.mehdisarf.StartSpringImplMehdiSarf.exceptions.NotEnoughMoneyException;
import com.mehdisarf.StartSpringImplMehdiSarf.model.ErrorDetails;
import com.mehdisarf.StartSpringImplMehdiSarf.model.PaymentDetails;
import com.mehdisarf.StartSpringImplMehdiSarf.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public ResponseEntity<?> makePayment() {

        try {
            PaymentDetails paymentDetails = paymentService.processPayment();

            return ResponseEntity.
                    status(HttpStatus.ACCEPTED).
                    body(paymentDetails);

        } catch (NotEnoughMoneyException e) {

            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("Not enough money to make the payment.");

            return ResponseEntity.
                    badRequest().
                    body(errorDetails);
        }

    }
}
