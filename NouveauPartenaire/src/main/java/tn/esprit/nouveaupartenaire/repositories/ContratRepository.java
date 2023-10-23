package tn.esprit.nouveaupartenaire.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.nouveaupartenaire.entities.Contrat;

@Repository
public interface ContratRepository extends JpaRepository<Contrat , Long> {
}
