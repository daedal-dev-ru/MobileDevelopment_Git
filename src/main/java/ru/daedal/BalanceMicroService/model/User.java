package ru.daedal.BalanceMicroService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Getter
@ToString
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Id
    private String nickname;
    @Setter
    private BigDecimal balance;

    protected User() { }
    public User(String nickname) {
        this.nickname = nickname;
        this.balance = BigDecimal.valueOf(0);
    }
}
