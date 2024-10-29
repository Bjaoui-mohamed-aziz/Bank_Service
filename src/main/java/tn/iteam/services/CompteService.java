package tn.iteam.services;

import tn.iteam.dtos.CompteDTO;
import tn.iteam.models.Compte;

public interface CompteService {
    Compte createCompte(CompteDTO compteDTO);

    CompteDTO fetchCompte(Long id);

    boolean updateCompte(Long id,CompteDTO compteDTO);

}
