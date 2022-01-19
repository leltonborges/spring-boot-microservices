package br.com.ms.hroauth.resources;

import br.com.ms.hroauth.entities.User;
import br.com.ms.hroauth.services.UserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserFeignService userFeignService;

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam(name = "email") Optional<String> email){
        if(email.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        Optional<User> userOptional = userFeignService.findByEmail(email.get());

        if(userOptional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(userOptional.get());
    }
}
