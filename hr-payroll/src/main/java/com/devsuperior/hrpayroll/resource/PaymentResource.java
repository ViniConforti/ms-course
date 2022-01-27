package com.devsuperior.hrpayroll.resource;

import com.devsuperior.hrpayroll.domain.Payment;
import com.devsuperior.hrpayroll.usecase.PaymentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/payments")

public class PaymentResource {
    private final PaymentUseCase paymentUseCase;

    @GetMapping(path = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable long workerId, @PathVariable int days){
        Payment newPayment = paymentUseCase.getPayment(workerId, days);
        return new ResponseEntity<>(newPayment, HttpStatus.OK);
    }
}
