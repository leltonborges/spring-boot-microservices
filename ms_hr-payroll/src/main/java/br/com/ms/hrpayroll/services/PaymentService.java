package br.com.ms.hrpayroll.services;

import br.com.ms.hrpayroll.entities.Payment;
import br.com.ms.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String urlWorker;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getInstancePayment(Long workerId, Integer days){
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", workerId+"");

        Worker worker = restTemplate
                .getForObject(urlWorker+"/workers/{id}", Worker.class, uriVariables);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
