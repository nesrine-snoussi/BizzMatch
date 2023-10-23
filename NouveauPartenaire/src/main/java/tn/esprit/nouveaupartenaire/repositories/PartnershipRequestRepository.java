package tn.esprit.nouveaupartenaire.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.nouveaupartenaire.entities.PartnershipRequest;

import java.util.List;

@Repository
public interface PartnershipRequestRepository extends JpaRepository<PartnershipRequest, Long> {

    List<PartnershipRequest> findByAcceptedFalse();


}
