package ru.daedal.BalanceMicroService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.daedal.BalanceMicroService.model.User;
import ru.daedal.BalanceMicroService.service.BalanceService;
import ru.daedal.BalanceMicroService.service.UserService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BalanceService balanceService;

    @GetMapping()
    public List<User> all() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping(value = "/create/{nickname}", produces = "application/json")
    public User createUser(@PathVariable String nickname) {
        return userService.createUser(nickname);
    }

    @PostMapping(value = "/create/{nickname}", produces = "application/json")
    public User createUserWithBalance(@PathVariable String nickname,
                           @RequestParam(name = "balance") Double amount) {
        User user = userService.createUser(nickname);
        balanceService.setBalance(user, amount);
        return user;
    }

    @GetMapping(value = "/{id}/balance")
    public BigDecimal getUserBalance(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return user.getBalance();
    }

    @PatchMapping(value = "/{id}/balance")
    public void setUserBalance(@PathVariable Long id,
                               @RequestParam(name = "set") Double amount) {
        User user = userService.getUserById(id);
        balanceService.setBalance(user, amount);
    }

    @PatchMapping(value = "/{id}/balance")
    public void userBalanceWithdraw(@PathVariable Long id,
                                    @RequestParam(name="withdraw") Double amount) {
        User user = userService.getUserById(id);
        balanceService.withdraw(user, amount);
    }

    @PatchMapping(value = "/{id}/balance")
    public void userBalanceDeposit(@PathVariable Long id,
                                   @RequestParam(name="deposit") Double amount) {
        User user = userService.getUserById(id);
        balanceService.deposit(user, amount);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
