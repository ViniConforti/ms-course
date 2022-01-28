package com.devsuperior.hrworker.resource;

import com.devsuperior.hrworker.domain.Worker;
import com.devsuperior.hrworker.usecase.WorkerUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
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
}
