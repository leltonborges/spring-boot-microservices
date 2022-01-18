package br.com.ms.hrpayroll.resources;

import br.com.ms.hrpayroll.entities.Payment;
import br.com.ms.hrpayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> find(@PathVariable("workerId") Long workerId,
                                        @PathVariable("days") Integer days){
        return ResponseEntity
                .ok()
                .body(paymentService.getInstancePayment(workerId, days));
    }
}
