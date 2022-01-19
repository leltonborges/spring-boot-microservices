package br.com.ms.hrpayroll.resources;

import br.com.ms.hrpayroll.entities.Payment;
import br.com.ms.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentService paymentService;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable("workerId") Long workerId,
                                        @PathVariable("days") Integer days){
        return ResponseEntity
                .ok()
                .body(paymentService.getInstancePayment(workerId, days));
    }

    public ResponseEntity<Payment> getPaymentAlternative(Long workerID, Integer days){
        return ResponseEntity
                .ok()
                .body(new Payment("Beta", BigDecimal.ZERO, days));
    }

}
