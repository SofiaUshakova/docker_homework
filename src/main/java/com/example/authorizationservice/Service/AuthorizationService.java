package com.example.authorizationservice.Service;

import com.example.authorizationservice.Model.Authorities;
import com.example.authorizationservice.Exepction.InvalidCredentials;
import com.example.authorizationservice.Exepction.UnauthorizedUser;
import com.example.authorizationservice.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorizationService {
    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String name, String password) {
        if (isEmpty(name) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(name, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + name);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}