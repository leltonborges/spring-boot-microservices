package br.com.ms.hrpayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsHrPayrollApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsHrPayrollApplication.class, args);
    }

}
