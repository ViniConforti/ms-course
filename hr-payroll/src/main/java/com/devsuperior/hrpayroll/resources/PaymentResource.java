package com.devsuperior.hrpayroll.resources;
import com.devsuperior.hrpayroll.domain.Payment;
import com.devsuperior.hrpayroll.usecases.PaymentUseCase;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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

    @CircuitBreaker(name="hr-payment", fallbackMethod="getPaymentAlternative")
    @GetMapping(path = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable long workerId, @PathVariable int days){
        Payment newPayment = paymentUseCase.getPayment(workerId, days);
        return new ResponseEntity<>(newPayment, HttpStatus.OK);
    }

    // O parametro throwable precisa estar junto quando utilizar o circuit breaker do resilient4j
    public ResponseEntity<Payment> getPaymentAlternative(long workId, int days,Throwable cause) {
            Payment payment = Payment.builder().name("Brann")
                    .dailyIncome(400.0)
                    .days(days)
                    .build();
            return ResponseEntity.ok(payment);
    }
}
