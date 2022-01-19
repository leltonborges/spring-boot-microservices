package br.com.ms.hruser.services;

import br.com.ms.hruser.entities.User;
import br.com.ms.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findbyEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public <S extends User> S save(S s) {
        return userRepository.save(s);
    }

    public Optional<User> findById(Long aLong) {
        return userRepository.findById(aLong);
    }
}
