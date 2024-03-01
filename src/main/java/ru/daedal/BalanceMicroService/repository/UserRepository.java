package ru.daedal.BalanceMicroService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.daedal.BalanceMicroService.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select user from User user where user.nickname = ?1")
    Optional<User> findByNickname(String nickname);
    @Query(value = "select user from User user where user.id = ?1")
    Optional<User> findById(Long id);
}
