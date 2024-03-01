package ru.daedal.BalanceMicroService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.daedal.BalanceMicroService.service.BalanceService;
import ru.daedal.BalanceMicroService.service.UserService;

@Configuration
public class ApplicationConfig {
    @Bean
    public BalanceService balanceService() {
        return new BalanceService();
    }

    @Bean
    public UserService userService() {
        return new UserService();
    }
}
