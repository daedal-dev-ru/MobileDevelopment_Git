package ru.daedal.BalanceMicroService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "User already exists")
public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String nickname) {
        super("User \"{nickname}\" is already exists!".replace("{nickname}", nickname));
    }
}
