package ru.daedal.BalanceMicroService.service;

import jakarta.transaction.Transactional;
import ru.daedal.BalanceMicroService.model.User;

import java.math.BigDecimal;

public interface IBalanceService {
    void setBalance(User user, BigDecimal newBalance);
    void setBalance(User user, Double newBalance);

    void deposit(User user, BigDecimal amount);
    void deposit(User user, Double amount);

    void withdraw(User user, BigDecimal amount);
    void withdraw(User user, Double amount);

    boolean transfer(User sender, User receiver, BigDecimal amount);
}
