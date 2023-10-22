package tn.esprit.servicemicroservices.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.servicemicroservices.Service.EntrepriseServiceImp;
import tn.esprit.servicemicroservices.entity.Entreprise;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/entreprise")
public class EntrepriseController {

    @Autowired
    EntrepriseServiceImp entrepriseServiceImp;
    @PostMapping("/ajouter")
    public Entreprise ajouterEntreprise(@RequestBody Entreprise entreprise) {
        return entrepriseServiceImp.ajouterEntreprise(entreprise);
    }
    @GetMapping("/list")
    public List<Entreprise> getAllEntrerises() {
        return entrepriseServiceImp.getAllEntreprises();
    }

    @DeleteMapping("sup/{id}")
    public ResponseEntity removeEntrepise(@PathVariable int id) {
        entrepriseServiceImp.removeEntreprise(id);
        return new ResponseEntity<>("Entreprise a été Supprimé!", HttpStatus.OK);
    }


    @PutMapping("modifier/{id}")
    public ResponseEntity<Entreprise> updateEntreprise(@PathVariable Integer id, @RequestBody Entreprise u) {
        // Utilisez le service pour mettre à jour l'utilisateur
        Entreprise entreprise = entrepriseServiceImp.updateEntreprise(u);
        if (entreprise != null) {
            return ResponseEntity.ok(entreprise); // Retournez l'utilisateur mis à jour avec un code HTTP 200 (OK).
        } else {
            return ResponseEntity.notFound().build(); // Retournez une réponse HTTP 404 (Non trouvé) si l'utilisateur n'est pas trouvé.
        }
    }
}
