package br.com.ms.hrworker.resources;

import br.com.ms.hrworker.entities.Worker;
import br.com.ms.hrworker.repositories.WorkerRepository;
import br.com.ms.hrworker.services.WorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    @Autowired
    private Environment env;

    @Autowired
    private WorkerService workerService;

    @GetMapping
    public ResponseEntity<List<Worker>> listAll(){
        return ResponseEntity
                .ok()
                .body(workerService.findAll());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){

        logger.info("PORT = " + env.getProperty("local.server.port"));

        return ResponseEntity
                .ok()
                .body(workerService.findById(id)
                        .orElseThrow(() -> new RuntimeException("Not found id: "+ id)));
    }
}
