package com.example.authorizationservice.Repository;

import com.example.authorizationservice.Model.Authorities;
import com.example.authorizationservice.Model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private List<User> userRepository = new ArrayList<>();

    {
        userRepository.add(new User("admin", "0000"));
        userRepository.add(new User("Sonya", "1234"));
    }

    public List<Authorities> getUserAuthorities(String name, String password) {
        List<Authorities> authoritiesList = new ArrayList<>();
        for (User user : userRepository) {
            if (user.getName().equals("admin") && user.getPassword().equals("0000")) {
                Collections.addAll(authoritiesList, Authorities.READ, Authorities.DELETE, Authorities.WRITE);
            } else if (user.getName().equals("Sonya") && user.getPassword().equals("1234")) {
                Collections.addAll(authoritiesList, Authorities.WRITE, Authorities.READ);
            }
        }
        return authoritiesList;
    }

}
