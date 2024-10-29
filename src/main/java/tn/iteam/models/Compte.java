package tn.iteam.models;

import jakarta.persistence.*;
import lombok.*;
import tn.iteam.enums.TypeCompte;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="COMPTES")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "compte_generator")
    @SequenceGenerator(name = "compte_generator", sequenceName = "tcomp_seq", initialValue = 10004)
    private long id;
    private double solde;
    private LocalDate date;
    
    @Enumerated(EnumType.STRING)
    private TypeCompte typeCompte;

    public Compte(Long id, double solde, LocalDate date, TypeCompte typeCompte) {
    }
}
