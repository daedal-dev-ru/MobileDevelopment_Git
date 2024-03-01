package ru.daedal.BalanceMicroService.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String nickname) {
        super("User \"{nickname}\" is already exists!".replace("{nickname}", nickname));
    }
}
