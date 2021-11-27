package com.ist412.efinance;

import com.ist412.efinance.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;

@SpringBootApplication
public class EFinanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EFinanceApplication.class, args);
    }

}
