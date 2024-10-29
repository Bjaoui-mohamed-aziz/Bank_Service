package tn.iteam.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.iteam.models.Compte;

public interface CompteRepo extends JpaRepository<Compte, Long> {
}
