package tn.esprit.servicemicroservices.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.servicemicroservices.entity.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {
}
