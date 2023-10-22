package tn.esprit.relation.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String industry;
    private String location;
    @OneToMany(mappedBy = "demandingEntreprise")
    private List<Relation> demandingRelations;

    @OneToMany(mappedBy = "acceptingEntreprise")
    private List<Relation> acceptingRelations;
}
