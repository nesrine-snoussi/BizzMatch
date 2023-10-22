package tn.esprit.servicemicroservices.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Relation;
import javax.persistence.*;

import java.io.Serializable;
import java.util.List;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Entreprise implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String industry;
    private String location;
 //  @OneToMany(mappedBy = "demandingEntreprise")
  //  public List<tn.esprit.servicemicroservices.entity.Relation>  demandingEntreprise;

//@OneToMany(mappedBy = "acceptingEntreprise")
 //  private List<tn.esprit.servicemicroservices.entity.Relation> acceptingEntreprise;

}
