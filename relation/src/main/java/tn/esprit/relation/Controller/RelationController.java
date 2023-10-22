package tn.esprit.relation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.relation.Entity.Relation;
import tn.esprit.relation.Service.relationServiceImp;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/relation")

public class RelationController {

    @Autowired
    relationServiceImp RelationService;
    @PostMapping("/ajouter")
    public Relation ajouterRelation(@RequestBody Relation relation) {
        return RelationService.ajouterRelation(relation);
    }
    @PutMapping("/accept/{id}")
    public ResponseEntity<Relation> acceptRelation(@PathVariable Integer id) {
        Relation acceptedRelation = (Relation) RelationService.acceptRelation(id).getBody();
        if (acceptedRelation != null) {
            return ResponseEntity.ok(acceptedRelation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/refuse/{id}")
    public ResponseEntity<Relation> refuseRelation(@PathVariable Integer id) {
        Relation refusedRelation = RelationService.refuseRelation(id).getBody();
        if (refusedRelation != null) {
            return ResponseEntity.ok(refusedRelation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/list")
    public List<Relation> getAllRelation() {
        return RelationService.getAllRelation();
    }

}

