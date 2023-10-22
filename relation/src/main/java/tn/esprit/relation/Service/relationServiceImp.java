package tn.esprit.relation.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import tn.esprit.relation.Entity.Relation;

import java.util.List;
import java.util.Optional;

public interface relationServiceImp {




    ResponseEntity acceptRelation(int id);





    //public Relation refuseRelation(int id) {
    ResponseEntity<Relation> refuseRelation(int id);



    Relation ajouterRelation(Relation relation);

    List<Relation> getAllRelation();
}
