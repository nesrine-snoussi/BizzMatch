package tn.esprit.relation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.relation.Entity.Relation;

public interface relationRepository extends JpaRepository<Relation, Integer> {
}
