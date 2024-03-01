package ru.daedal.BalanceMicroService.exception;

import ru.daedal.BalanceMicroService.model.User;

public class NegativeBalanceException extends RuntimeException {
    public NegativeBalanceException(User user) {
        super(("User {nickname}[{id}] currently has {balance} in his balance. " +
                "Can't withdraw more than this amount.")
                .replace("{nickname}", String.valueOf(user.getId()))
                .replace("{id}", user.getNickname())
                .replace("{balance}", user.getBalance().toPlainString()));
    }
}
