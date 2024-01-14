package com.example.authorizationservice.Repository;

import com.example.authorizationservice.Model.Authorities;
import com.example.authorizationservice.Model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    /* Этот вариант всегда выдает ошибку 401, включая ситуацию с незаполненными полями.
    * ниже еще два варианта, пришедших на ум*/
    private List<User> userRepository = new ArrayList<>();

    {
        userRepository.add(new User("admin", "0000"));
        userRepository.add(new User("Sonya", "1234"));
    }

    public List<Authorities> getUserAuthorities(String name, String password) {

        List<Authorities> authoritiesList = new ArrayList<>();
        for (User user : userRepository) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                Collections.addAll(authoritiesList, Authorities.READ, Authorities.DELETE, Authorities.WRITE);
            }
        }
        return authoritiesList;
    }
    /* Этот вариант также всегда выдает ошибку 401 на любого Юзера, включая ситуации с незаполненными полями*/
//    public List<Authorities> getUserAuthorities(String name, String password) {
//    List<Authorities> authoritiesList = new ArrayList<>();
//    if (name.equals("admin") && password.equals("0000")){
//        Collections.addAll(authoritiesList, Authorities.READ, Authorities.DELETE, Authorities.WRITE);
//    }else if (name.equals("Sonya") && password.equals("1234")){
//        Collections.addAll(authoritiesList, Authorities.READ, Authorities.WRITE);
//    }
//    return authoritiesList;
//}

/*   Этот вариант всегда дает ответ на запрос для обоих Юзеров: READ, DELETE, WRITE, WRITE, READ
т.к. проверяется userRepository, а там оба Юзера есть
ошибок при незаполненом параметре name или password не выдает*/
//    private List<User> userRepository = new ArrayList<>();
//
//    {
//        userRepository.add(new User("admin", "0000"));
//        userRepository.add(new User("Sonya", "1234"));
//    }
//    public List<Authorities> getUserAuthorities(String name, String password) {
//
//        List<Authorities> authoritiesList = new ArrayList<>();
//        for (User user : userRepository) {
//            if (user.getName().equals("admin") && user.getPassword().equals("0000")) {
//                Collections.addAll(authoritiesList, Authorities.READ, Authorities.DELETE, Authorities.WRITE);
//            } else if (user.getName().equals("Sonya") && user.getPassword().equals("1234")) {
//                Collections.addAll(authoritiesList, Authorities.WRITE, Authorities.READ);
//            }
//        }
//        return authoritiesList;
//    }

}
