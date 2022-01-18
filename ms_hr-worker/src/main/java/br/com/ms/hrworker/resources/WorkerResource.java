package br.com.ms.hrworker.resources;

import br.com.ms.hrworker.entities.Worker;
import br.com.ms.hrworker.repositories.WorkerRepository;
import br.com.ms.hrworker.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

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
        return ResponseEntity
                .ok()
                .body(workerService.findById(id)
                        .orElseThrow(() -> new RuntimeException("Not found id: "+ id)));
    }
}
