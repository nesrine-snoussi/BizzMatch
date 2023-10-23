package tn.esprit.event.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.event.entities.Evenement;
import tn.esprit.event.entities.User;
import tn.esprit.event.repositories.EvenementRepository;
import tn.esprit.event.repositories.UserRepository;

import java.util.Date;
import java.util.List;

@Service
public class EvenementService implements IEvenementService {

    @Autowired
    private EvenementRepository evenementRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public void removeEvenement(Integer idEvenement) {
        evenementRepository.deleteById(idEvenement);
    }
    @Override
    public Evenement updateEtudiant(Evenement e) {
        return evenementRepository.save(e);
    }

    @Override
    public Evenement addEvenement(Evenement evenement) {
        return evenementRepository.save(evenement);
    }

    @Override
    public Evenement getEvenementById(Integer idEvenement) {
        return evenementRepository.findById(idEvenement).orElse(null);
    }

    @Override
    public List<Evenement> getAllEvenement() {
        return evenementRepository.findAll();
    }

    @Override
    public void assignEvenementToUser(Integer idEvenement, Integer id) {
        Evenement evenement = evenementRepository.findById(idEvenement).orElse(null);
        User user = userRepository.findUserById(id);
        //evenement.setUsers(user);
       // evenementRepository.save(evenement);
        if (evenement != null && user != null) {
            // Récupérez la liste d'utilisateurs de l'événement
            List<User> users = evenement.getUsers();
            // Ajoutez l'utilisateur à la liste
            users.add(user);
            // Mettez à jour la liste d'utilisateurs de l'événement
            evenement.setUsers(users);
            // Enregistrez l'événement mis à jour
            evenementRepository.save(evenement);
        }
    }
    @Override
    public List<Evenement> getEvenementByDate(Date date) {
        return evenementRepository.findByDate(date);
    }

    @Override
    public List<Evenement> getEvenementsPlanifiesEntreDates(Date dateDebut, Date dateFin) {
        return evenementRepository.findEvenementsPlanifiesEntreDates(dateDebut, dateFin);
    }

}
