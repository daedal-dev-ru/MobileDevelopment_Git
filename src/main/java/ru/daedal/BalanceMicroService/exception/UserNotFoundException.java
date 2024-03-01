package ru.daedal.BalanceMicroService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User not found")
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User with id {id} is not found!"
                .replace("{id}", String.valueOf(id)));
    }
}
