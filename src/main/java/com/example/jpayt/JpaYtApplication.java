package com.example.jpayt;

import com.example.jpayt.model.Author;
import com.example.jpayt.repo.AuthorRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class JpaYtApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaYtApplication.class, args);
    }
    @Bean
    @Transactional
    public CommandLineRunner commandLineRunner(AuthorRepository repository){
        return args -> {
            var author = Author.builder()
                    .firstName("Ayush")
                    .lastName("Tiwari")
                    .age(24)
                    .email("ayush@gmail.com")
                    .createdAt(LocalDateTime.now())
                    .build();
            repository.save(author);
//            author.setAge(30);
            author.setEmail("ayush.kumar@yahoo.com");
        };
    }
}
