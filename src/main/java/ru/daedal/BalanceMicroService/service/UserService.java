package ru.daedal.BalanceMicroService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.daedal.BalanceMicroService.exception.UserAlreadyExistsException;
import ru.daedal.BalanceMicroService.exception.UserNotFoundException;
import ru.daedal.BalanceMicroService.model.User;
import ru.daedal.BalanceMicroService.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void deleteUserById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }

        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }

        throw new UserNotFoundException(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(String nickname) {
        if (userRepository.findByNickname(nickname).isPresent()) {
            throw new UserAlreadyExistsException(nickname);
        }

        User user = new User(nickname);
        userRepository.save(user);
        return user;
    }
}
