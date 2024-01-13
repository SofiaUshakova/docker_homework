package com.example.authorizationservice.Controller;

import com.example.authorizationservice.Exepction.InvalidCredentials;
import com.example.authorizationservice.Exepction.UnauthorizedUser;
import com.example.authorizationservice.Model.Authorities;
import com.example.authorizationservice.Service.AuthorizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("name") String name, @RequestParam("password") String password) {
        return service.getAuthorities(name, password);
    }
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> icHandler(InvalidCredentials msg){
        return new ResponseEntity<>(msg.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> uaHandler(UnauthorizedUser msg){
        return new ResponseEntity<>(msg.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
