package ru.daedal.BalanceMicroService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.daedal.BalanceMicroService.model.User;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Can't set negative balance")
public class NegativeBalanceException extends RuntimeException {
    public NegativeBalanceException(User user) {
        super(("User {nickname}[{id}] currently has {balance} in his balance. " +
                "Can't withdraw more than this amount.")
                .replace("{nickname}", user.getNickname())
                .replace("{id}",  String.valueOf(user.getId()))
                .replace("{balance}", user.getBalance().toPlainString()));
    }
}
