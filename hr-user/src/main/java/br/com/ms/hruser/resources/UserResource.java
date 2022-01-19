package br.com.ms.hruser.resources;

import br.com.ms.hruser.entities.User;
import br.com.ms.hruser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "users")
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id){
        return  ResponseEntity.
                ok(userService.findById(id).orElseThrow(() -> new RuntimeException("Not found id:" + id)));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam(name = "email") String email){
        return  ResponseEntity.
                ok(userService
                        .findbyEmail(email)
                        .orElseThrow(() -> new RuntimeException("Not found email:" + email)));
    }
}
