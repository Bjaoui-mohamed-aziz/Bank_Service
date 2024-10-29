package tn.iteam;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.iteam.enums.TypeCompte;
import tn.iteam.models.Compte;
import tn.iteam.repos.CompteRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
@RequiredArgsConstructor
public class MsBankApplication {

    private final CompteRepo compteRepo;

    public static void main(String[] args) {
        SpringApplication.run(MsBankApplication.class, args);
    }

   // @Bean
    public CommandLineRunner init(CompteRepo compteRepo) {
        return args -> {
            Compte cp1 = new Compte();
            cp1.setId(1L);
            cp1.setSolde(Math.random() * 9000);
            cp1.setTypeCompte(TypeCompte.epargne);
            cp1.setDate(LocalDate.now());
            compteRepo.save(cp1);

            Compte cp2 = new Compte(2, Math.random() * 9000,LocalDate.now(),TypeCompte.epargne);
            compteRepo.save(cp2);

            Compte cp3 = Compte.builder()
                    .solde(Math.random() * 9000)
                    .date(LocalDate.now())
                    .typeCompte(TypeCompte.epargne)
                    .build();
            compteRepo.save(cp3);

            compteRepo.findAll().forEach(compte -> System.out.println(compte.getSolde()));
        };
    }
}
