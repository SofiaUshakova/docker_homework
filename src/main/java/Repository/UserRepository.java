package Repository;

import Authorization.Authorities;
import Authorization.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authoritiesList = new ArrayList<>();
        if (user.equals("admin") && password.equals("0000")){
            Collections.addAll(authoritiesList, Authorities.READ, Authorities.DELETE, Authorities.WRITE);
        }else if (user.equals("Sonya") && password.equals("1234")){
            Collections.addAll(authoritiesList, Authorities.WRITE, Authorities.READ);
        }
        return authoritiesList;
    }
}
