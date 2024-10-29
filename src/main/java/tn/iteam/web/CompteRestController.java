package tn.iteam.web;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.iteam.constants.AccountConstant;
import tn.iteam.dtos.CompteDTO;
import tn.iteam.dtos.ResponseDTO;
import tn.iteam.models.Compte;
import tn.iteam.repos.CompteRepo;
import tn.iteam.services.CompteService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CompteRestController {

    private final CompteRepo compteRepo;

    private final CompteService compteService;
    public CompteRestController(CompteRepo compteRepo, CompteService compteService) {
        this.compteRepo = compteRepo;
        this.compteService = compteService;
    }


    @GetMapping("/comptes")
    public List<Compte> lisAllCompte(){
        return compteRepo.findAll();

    }

    @GetMapping("/comptes/{id}")
    public ResponseEntity<CompteDTO> GetCompteById(@PathVariable Long id){
        CompteDTO compteDTO = compteService.fetchCompte(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(compteDTO);
    }





    @PostMapping("/comptes")
public ResponseEntity<ResponseDTO> createAccount(@RequestBody CompteDTO compteDTO){
        compteService.createCompte(compteDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(AccountConstant.STATUS_201, AccountConstant.MESSAGE_201));
    }

    @PutMapping("/comptes/{id}")
    public ResponseEntity<ResponseDTO> UpdateCompte(@PathVariable Long id,
                                                  @RequestBody CompteDTO compteDTO){
        boolean isUpdated = compteService.updateCompte(id, compteDTO);
        if(isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(AccountConstant.STATUS_200, AccountConstant.MESSAGE_201));
        }else{
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(AccountConstant.STATUS_500, AccountConstant.MESSAGE_500));
        }
    }

}