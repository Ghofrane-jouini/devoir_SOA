package com.ghofrane.chanson;
import org.springframework.cloud.openfeign.EnableFeignClients;
import com.ghofrane.chanson.entities.Chanson;
import com.ghofrane.chanson.repos.ChansonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class ChansonMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChansonMicroserviceApplication.class, args);
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }

    @Bean
    CommandLineRunner commandLineRunner(ChansonRepository chansonRepository) {
        return args -> {
            chansonRepository.save(Chanson.builder()
                    .titre("Believer").artiste("Imagine Dragons").genreCode("ROCK").build());
            chansonRepository.save(Chanson.builder()
                    .titre("Shape of You").artiste("Ed Sheeran").genreCode("POP").build());
        };
    }
}