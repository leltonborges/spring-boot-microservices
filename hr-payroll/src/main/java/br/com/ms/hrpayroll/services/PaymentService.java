package br.com.ms.hrpayroll.services;

import br.com.ms.hrpayroll.entities.Payment;
import br.com.ms.hrpayroll.entities.Worker;
import br.com.ms.hrpayroll.feignclients.WorkerFeignClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClients workerFeignClients;

    public Payment getInstancePayment(Long workerId, Integer days){

        Worker worker = workerFeignClients.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
