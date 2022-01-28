package com.devsuperior.hrpayroll.feignclients;
import com.devsuperior.hrpayroll.domain.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Anotação que informa que esse componente será gerenciado pelo spring
@Component
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeignClient {

    @GetMapping(path = "/{id}")
    ResponseEntity<Worker> findById(@PathVariable long id);

}
