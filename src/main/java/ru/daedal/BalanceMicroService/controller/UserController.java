package ru.daedal.BalanceMicroService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.daedal.BalanceMicroService.model.User;
import ru.daedal.BalanceMicroService.service.BalanceService;
import ru.daedal.BalanceMicroService.service.UserService;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final BalanceService balanceService;

    @GetMapping()
    public List<User> all() {
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public User getUser(@PathVariable Long id) {
    }

    @GetMapping(value = "/{nickname}", produces = "application/json")
    public User getUser(@PathVariable String nickname) {
    }

    @PostMapping(value = "/create/{nickname}", produces = "application/json")
    public User createUser(@PathVariable String nickname) {
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
    }
}
