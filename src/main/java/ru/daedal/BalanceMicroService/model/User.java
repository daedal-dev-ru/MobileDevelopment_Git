package ru.daedal.BalanceMicroService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Getter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Id
    private String nickname;
    private BigDecimal balance;

    protected User() { }
    public User(String nickname) {
        this.nickname = nickname;
    }
}
