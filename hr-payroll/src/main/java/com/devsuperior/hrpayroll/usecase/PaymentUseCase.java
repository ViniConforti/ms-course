package com.devsuperior.hrpayroll.usecase;
import com.devsuperior.hrpayroll.domain.Payment;
import com.devsuperior.hrpayroll.domain.Worker;
import com.devsuperior.hrpayroll.feignclients.WorkerFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentUseCase {

    // @Value busca o valor em uma propriedade no arquivo resources.yml
    /*@Value("${hr-worker.host}")
    private String workerServiceHost;*/

    private final WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days){
        Worker worker = workerFeignClient.findById(workerId).getBody();
        return Payment.builder()
                .days(days)
                .name(worker.getName())
                .dailyIncome(worker.getDailyIncome())
                .build();
    }
}
