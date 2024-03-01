package ru.daedal.BalanceMicroService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.daedal.BalanceMicroService.model.User;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    @Query(value = "select user from User user where user.nickname = ?1")
    Optional<User> findByNickname(String nickname);

    @Query(value = "select user from User user where user.id = ?1")
    Optional<User> findById(Long id);

    @Override
    @Query(value = "update User user set user.id = ?1 ")
    <S extends User> S save(S user);

    @Override
    <S extends User> Iterable<S> saveAll(Iterable<S> users);

    @Override
    public Optional<User> findByNickname(String nickname);

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public Iterable<User> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends User> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
