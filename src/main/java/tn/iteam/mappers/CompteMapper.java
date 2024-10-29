package tn.iteam.mappers;

import tn.iteam.dtos.CompteDTO;
import tn.iteam.models.Compte;

public class CompteMapper {

    public static Compte mapToCompte(CompteDTO compteDTO, Compte compte){
        compte.setTypeCompte(compteDTO.getTypeCompte()
        );
        compte.setSolde(compteDTO.getSolde());
        compte.setDate(compteDTO.getDate());
        return compte;
    }
    public static CompteDTO mapToCompteDTO(Compte compte,CompteDTO compteDTO){
        compteDTO.setTypeCompte(compte.getTypeCompte()
        );
        compteDTO.setSolde(compte.getSolde());
        compteDTO.setDate(compte.getDate());
        return compteDTO;
    }
}
