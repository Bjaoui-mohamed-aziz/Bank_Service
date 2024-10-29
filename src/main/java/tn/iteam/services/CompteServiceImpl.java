package tn.iteam.services;

import org.springframework.stereotype.Service;
import tn.iteam.dtos.CompteDTO;
import tn.iteam.exceptions.RessourceNotFoundException;
import tn.iteam.mappers.CompteMapper;
import tn.iteam.models.Compte;
import tn.iteam.repos.CompteRepo;


@Service
public class CompteServiceImpl implements CompteService {

    private final CompteRepo compteRepository;

    public CompteServiceImpl(CompteRepo compteRepository) {
        this.compteRepository = compteRepository;
    }

    @Override
    public Compte createCompte(CompteDTO compteDTO) {
        Compte compte = CompteMapper.mapToCompte(compteDTO, new Compte());
        Compte savedCompte = compteRepository.save( compte);
        return savedCompte;
    }

    @Override
    public CompteDTO fetchCompte(Long id) {
        Compte compte = compteRepository.findById(id).orElseThrow(
                ()-> new RessourceNotFoundException("Compte","id",id.toString())
        );
        CompteDTO compteDTO = CompteMapper.mapToCompteDTO(compte, new CompteDTO());
        return compteDTO;
    }

    @Override
    public boolean updateCompte(Long id, CompteDTO compteDTO) {
        boolean isUpdated = false;
        if (compteDTO!=null){
            Compte compte = compteRepository.findById(id).orElseThrow(
                    () -> new RessourceNotFoundException("Compte", "compteID", id.toString())
            );
            CompteMapper.mapToCompte(compteDTO,compte);
            compteRepository.save(compte);
            isUpdated = true;
        }

        return isUpdated;
    }
}
