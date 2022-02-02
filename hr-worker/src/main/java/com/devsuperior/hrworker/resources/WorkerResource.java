package com.devsuperior.hrworker.resources;

import com.devsuperior.hrworker.domain.Worker;
import com.devsuperior.hrworker.usecases.WorkerUseCase;
import lombok.RequiredArgsConstructor;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
@RequiredArgsConstructor
@Log4j2
public class WorkerResource {
    private final WorkerUseCase workerUseCase;

    private final Environment environment;

    @Value("${test.config}")
    private String testConfigs;

    @GetMapping()
    public ResponseEntity<List<Worker>> list(){
        return new ResponseEntity<>(this.workerUseCase.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable long id){
        String portInfo = "PORT="+environment.getProperty("local.server.port");
        log.info(portInfo);
        return new ResponseEntity<>(this.workerUseCase.findByIdOrThrowBadRequestException(id),
                HttpStatus.OK);
    }

    @GetMapping(value = "/configs")
    public ResponseEntity<String> getConfigs(){
        return ResponseEntity.ok(this.testConfigs);
    }
}
