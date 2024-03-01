package ru.daedal.BalanceMicroService.service;

import ru.daedal.BalanceMicroService.model.User;

import java.math.BigDecimal;

public interface IBalanceService {
    void setBalance(User user, BigDecimal newBalance);
    void addBalance(User user, BigDecimal amount);
    void takeBalance(User user, BigDecimal amount);
}
