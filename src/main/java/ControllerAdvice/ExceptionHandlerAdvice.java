package ControllerAdvice;

import Exepction.InvalidCredentials;
import Exepction.UnauthorizedUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> icHandler(InvalidCredentials msg){
        return new ResponseEntity<>(msg.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> uaHandler(UnauthorizedUser msg){
        return new ResponseEntity<>(msg.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
