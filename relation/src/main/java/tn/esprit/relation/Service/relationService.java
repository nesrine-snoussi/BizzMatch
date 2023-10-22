package tn.esprit.relation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.relation.Entity.Entreprise;
import tn.esprit.relation.Entity.Relation;
import tn.esprit.relation.Entity.Status;
import tn.esprit.relation.Repository.relationRepository;

import java.util.List;
import java.util.Optional;

@Service

public class relationService implements  relationServiceImp{
    @Autowired
    private relationRepository RelationRepository;






    //public Relation refuseRelation(int id) {
    @Override
        public ResponseEntity<Relation> refuseRelation(int id) {
            Relation relation = RelationRepository.findById(id).orElse(null);
            if (relation != null) {
                if (relation.getStatus() == Status.EN_ATTENTE) {
                    relation.setStatus(Status.REFUSEE);
                    RelationRepository.save(relation);
                    // Autres opérations nécessaires
                    return ResponseEntity.ok(relation);
                } else {
                    return ResponseEntity.badRequest().build(); // Ou toute autre réponse appropriée
                }
            } else {
                return ResponseEntity.notFound().build();
            }
        }

    @Override
    public Relation ajouterRelation(Relation relation) {
        return RelationRepository.save(relation);
    }

    @Override
    public List<Relation> getAllRelation() {
        return RelationRepository.findAll();
    }


    @Override
    public ResponseEntity<Relation> acceptRelation(int id) {
        Relation relation = RelationRepository.findById(id).orElse(null);
        if (relation != null) {
            if (relation.getStatus() == Status.EN_ATTENTE) {
                relation.setStatus(Status.ACCEPTEE);
                RelationRepository.save(relation);
                // Autres opérations nécessaires
                return ResponseEntity.ok(relation);
            } else {
                return ResponseEntity.badRequest().build(); // Ou toute autre réponse appropriée
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    }
