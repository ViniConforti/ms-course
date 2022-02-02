package com.devsuperior.hrworker.usecases;

import com.devsuperior.hrworker.domain.Worker;
import com.devsuperior.hrworker.storages.WorkerStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class WorkerUseCase {
    private final WorkerStorage workerRepository;

    public List<Worker> listAll(){
        return workerRepository.findAll();
    }

    public Worker findByIdOrThrowBadRequestException(long id) {
        return this.workerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Worker not found"));
    }
}
