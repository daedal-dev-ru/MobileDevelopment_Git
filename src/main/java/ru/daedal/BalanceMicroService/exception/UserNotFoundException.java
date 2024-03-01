package ru.daedal.BalanceMicroService.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long userId) {
        super("User with id {id} is not found!".replace("{id}", String.valueOf(userId)));
    }

    public UserNotFoundException(String nickname) {
        super("User with nickname {nickname} is not found!".replace("{nickname}", nickname));
    }
}
