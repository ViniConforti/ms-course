package com.devsuperior.hrpayroll.usecase;
import com.devsuperior.hrpayroll.domain.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentUseCase {

    public Payment getPayment(long workerId, int days){
        Payment newPayment = Payment.builder()
                .days(days)
                .name("Bob")
                .dailyIncome(200.0)
                .build();
        return newPayment;

    }
}
