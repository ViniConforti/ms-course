package com.devsuperior.hrpayroll.usecase;
import com.devsuperior.hrpayroll.domain.Payment;
import com.devsuperior.hrpayroll.domain.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentUseCase {

    private final RestTemplate restTemplate;

    @Value("${hr-worker.host}")
    private String workerServiceHost;

    public Payment getPayment(long workerId, int days){
        Map<String,String> uriVariables = new HashMap<>();

        uriVariables.put("id",String.valueOf(workerId));

        Worker worker = restTemplate
                .getForObject(workerServiceHost + "/workers/{id}", Worker.class,uriVariables);


        return Payment.builder()
                .days(days)
                .name(worker.getName())
                .dailyIncome(worker.getDailyIncome())
                .build();

    }
}
