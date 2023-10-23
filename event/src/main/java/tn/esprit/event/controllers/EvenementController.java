package tn.esprit.event.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.event.entities.Evenement;
import tn.esprit.event.services.IEvenementService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/EVENT")
public class EvenementController {

    @Autowired
    private IEvenementService iEvenementService;

    @DeleteMapping("/sup/{idEvenement}")
    public ResponseEntity removeEvenement(@PathVariable int idEvenement) {
        iEvenementService.removeEvenement(idEvenement);
        return new ResponseEntity<>("Evenement a été Supprimé!", HttpStatus.OK);
    }

    @PutMapping("modifier/{id}")
    public ResponseEntity<Evenement> updateEvenement(@PathVariable Integer id, @RequestBody Evenement e) {
        // Utilisez le service pour mettre à jour l'utilisateur
        Evenement evenement = iEvenementService.updateEtudiant(e);
        if (evenement != null) {
            return ResponseEntity.ok(evenement); // Retournez l'evenement mis à jour avec un code HTTP 200 (OK).
        } else {
            return ResponseEntity.notFound().build(); // Retournez une réponse HTTP 404 (Non trouvé) si l'evenement n'est pas trouvé.
        }
    }

    @PostMapping("/ajouterevenement")
    public Evenement addCandidature(@RequestBody Evenement evenement) {
        return iEvenementService.addEvenement(evenement);
    }

    @GetMapping("/allevenement")
    public List<Evenement> findAllEvenement() {
        return iEvenementService.getAllEvenement();
    }

    @GetMapping("/evenementById/{idEvenement}")
    public Evenement findEvenementById(@PathVariable int idEvenement) {
        return iEvenementService.getEvenementById(idEvenement);
    }

    @PutMapping("/assigner-evenement/{idEvenement}/{id}")
    public ResponseEntity assignerEvenementAUtilisateur(@PathVariable Integer idEvenement, @PathVariable Integer id) {
        iEvenementService.assignEvenementToUser(idEvenement, id);
        return new ResponseEntity<>("evenement Affecté ", HttpStatus.OK);
    }


    @GetMapping("/evenements-by-date")
    public List<Evenement> getEvenementsByDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        return iEvenementService.getEvenementByDate(date);
    }

    @GetMapping("/evenementsplanifies")
    public List<Evenement> getEvenementsPlanifiesEntreDates(@RequestParam("dateDebut") Date dateDebut, @RequestParam("dateFin") Date dateFin) {
        return iEvenementService.getEvenementsPlanifiesEntreDates(dateDebut, dateFin);
    }
}
