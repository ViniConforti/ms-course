package com.devsuperior.hrworker.storages;

import com.devsuperior.hrworker.domain.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerStorage extends JpaRepository<Worker,Long> {}
