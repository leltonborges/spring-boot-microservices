package br.com.ms.hroauth.services;

import br.com.ms.hroauth.entities.User;
import br.com.ms.hroauth.feignClients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserFeignService implements UserDetailsService {
    @Autowired
    private UserFeignClient userFeignClient;

    private  final Logger logger = LoggerFactory.getLogger(UserFeignService.class);

    public Optional<User> findByEmail(String email) {
        Optional<User> user = Optional.of(userFeignClient.findByEmail(email).getBody());
        if(user.equals(null)){
            logger.info("Email not found: "+ email);
            throw new IllegalArgumentException("Email not found");
        }
        logger.info("Email found: "+ email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = Optional.of(userFeignClient.findByEmail(userName).getBody());
        if(user.equals(null)){
            logger.info("Email not found: "+ userName);
            throw new UsernameNotFoundException("Email not found");
        }
        logger.info("Email found: "+ userName);
        return user.get();
    }
}
