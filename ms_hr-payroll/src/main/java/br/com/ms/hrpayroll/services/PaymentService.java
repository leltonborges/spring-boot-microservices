package br.com.ms.hrpayroll.services;

import br.com.ms.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService {
    public Payment getInstancePayment(Long workerId, Integer days){
        return new Payment("Bob", BigDecimal.TEN, days);
    }
}
