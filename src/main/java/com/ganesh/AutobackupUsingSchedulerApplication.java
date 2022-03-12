package com.ganesh;

import com.ganesh.user.User;
import com.ganesh.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.stream.IntStream;

@SpringBootApplication
@EnableScheduling
public class AutobackupUsingSchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutobackupUsingSchedulerApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserRepository userRepository){
        return args -> IntStream.rangeClosed(1,30).forEach(i ->{
            User user = new User();
            user.setUsername("user"+ i);
            user.setEmail("user"+ i + "gmail.com");
            user.setPassword("password"+ i);
            user.setRole("role"+ i);
            user.setAuth("auth"+ i);
            userRepository.save(user);
        });
    }
}
