package tn.iteam.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.iteam.enums.TypeCompte;

import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompteDTO {

    private double solde;
    private LocalDate date;
    private TypeCompte typeCompte;


}
