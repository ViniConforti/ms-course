package com.devsuperior.hrworker.resource;

import com.devsuperior.hrworker.domain.Worker;
import com.devsuperior.hrworker.usecase.WorkerUseCase;
import lombok.RequiredArgsConstructor;
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

public class WorkerResource {
    private final WorkerUseCase workerUseCase;

    @GetMapping()
    public ResponseEntity<List<Worker>> list(){
        return new ResponseEntity<>(this.workerUseCase.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable long id){
        return new ResponseEntity<>(this.workerUseCase.findByIdOrThrowBadRequestException(id),
                HttpStatus.OK);
    }
}
