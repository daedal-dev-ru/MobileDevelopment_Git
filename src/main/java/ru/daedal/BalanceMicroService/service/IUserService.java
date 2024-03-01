package ru.daedal.BalanceMicroService.service;

import ru.daedal.BalanceMicroService.model.User;

import java.util.List;

public interface IUserService {

    void deleteUserById(Long id);
    User getUserById(Long id);
    List<User> getAllUsers();
}
