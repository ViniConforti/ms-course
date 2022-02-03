package com.devsuperior.hrworker.resources;

import com.devsuperior.hrworker.domain.Worker;
import com.devsuperior.hrworker.usecases.WorkerUseCase;
import lombok.RequiredArgsConstructor;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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

/* Essa anotaçao deve ser usada em todas as classes que acessam o servidor de configuracao
OBS: é necessária a dependencia do spring boot actuator.
O SpringBoot Actuator permite atualizacao em tempo de execucao das configuracoes.
Se alguma configuracao for atualizada no repositorio remoto, o actuator vai conseguir pegar
essa nova configuracao.
 */
@RefreshScope
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
