package com.mehdisarf.StartSpringImplMehdiSarf.services;

import com.mehdisarf.StartSpringImplMehdiSarf.exceptions.NotEnoughMoneyException;
import com.mehdisarf.StartSpringImplMehdiSarf.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment() {

        throw new NotEnoughMoneyException();
    }
}
