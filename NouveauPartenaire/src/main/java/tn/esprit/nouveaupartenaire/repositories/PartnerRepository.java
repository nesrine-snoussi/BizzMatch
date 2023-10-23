package tn.esprit.nouveaupartenaire.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.nouveaupartenaire.entities.Partner;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
}
