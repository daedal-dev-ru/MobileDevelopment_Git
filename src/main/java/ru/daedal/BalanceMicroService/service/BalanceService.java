package ru.daedal.BalanceMicroService.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.daedal.BalanceMicroService.exception.NegativeBalanceException;
import ru.daedal.BalanceMicroService.model.User;
import ru.daedal.BalanceMicroService.repository.UserRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class BalanceService implements IBalanceService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void setBalance(User user, BigDecimal newBalance) {
        user.setBalance(newBalance);
        userRepository.save(user);
    }

    @Override
    public void setBalance(User user, Double newBalance) {
        setBalance(user, BigDecimal.valueOf(newBalance));
    }

    @Override
    public void deposit(User user, BigDecimal amount) {
        user.setBalance(user.getBalance().add(amount));
        userRepository.save(user);
    }

    @Override
    public void deposit(User user, Double amount) {
        deposit(user, BigDecimal.valueOf(amount));
    }

    @Override
    public void withdraw(User user, BigDecimal amount) {
        if (user.getBalance().compareTo(amount) > 0) {
            throw new NegativeBalanceException(user);
        }
        user.setBalance(user.getBalance().divide(amount, RoundingMode.DOWN));
        userRepository.save(user);
    }

    @Override
    public void withdraw(User user, Double amount) {
        withdraw(user, BigDecimal.valueOf(amount));
    }

    @Override
    @Transactional
    public boolean transfer(User sender, User receiver, BigDecimal amount) {
        if (sender.getBalance().compareTo(amount) < 0) {
            return false;
        }
        withdraw(sender, amount);
        deposit(receiver, amount);
        return true;
    }
}
