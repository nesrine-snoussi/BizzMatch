package tn.esprit.event.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.event.entities.Evenement;

import java.util.Date;
import java.util.List;


public interface EvenementRepository extends JpaRepository<Evenement, Integer> {
    //List<Evenement> findByDate(Date date);
    @Query("SELECT e FROM Evenement e WHERE e.dateDebutEvenement = :date")
    List<Evenement> findByDate(@Param("date") Date date);

    @Query("SELECT e FROM Evenement e WHERE e.dateDebutEvenement >= :dateDebut AND e.dateFinEvenement <= :dateFin")
    List<Evenement> findEvenementsPlanifiesEntreDates(Date dateDebut, Date dateFin);
}
