package be.bxlforma.projetfilrouge;

import be.bxlforma.projetfilrouge.dal.repositories.StagiaireRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetFilRougeApplication {

    private StagiaireRepository stagiaireRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProjetFilRougeApplication.class, args);
    }

}
