package tn.esprit.event.services;

import tn.esprit.event.entities.Evenement;

import java.util.Date;
import java.util.List;

public interface IEvenementService {
    public void removeEvenement(Integer idEvenement);
    Evenement updateEtudiant (Evenement e);
    public Evenement addEvenement(Evenement evenement);
    public Evenement getEvenementById(Integer idEvenement);
    public List<Evenement> getAllEvenement();
    public void assignEvenementToUser(Integer idEvenement, Integer id);
    public List<Evenement> getEvenementByDate(Date date);

    List<Evenement> getEvenementsPlanifiesEntreDates(Date dateDebut, Date dateFin);


}
