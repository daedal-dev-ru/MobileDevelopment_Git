package ru.daedal.BalanceMicroService.service;

import org.springframework.stereotype.Service;
import ru.daedal.BalanceMicroService.model.User;

import java.math.BigDecimal;

@Service
public class BalanceService implements IBalanceService {

    @Override
    public void setBalance(User user, BigDecimal newBalance) {

    }

    @Override
    public void addBalance(User user, BigDecimal amount) {

    }

    @Override
    public void takeBalance(User user, BigDecimal amount) {

    }
}
