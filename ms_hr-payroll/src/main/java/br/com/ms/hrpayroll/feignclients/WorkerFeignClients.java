package br.com.ms.hrpayroll.feignclients;

import br.com.ms.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker",
        url = "localhost:8001",
        path = "/workers")
public interface WorkerFeignClients {

    @GetMapping(value = "{id}")
    ResponseEntity<Worker> findById(@PathVariable Long id);
}
