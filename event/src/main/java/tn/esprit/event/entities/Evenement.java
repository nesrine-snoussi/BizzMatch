package tn.esprit.event.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Evenement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEvenement ;
    private String titreEvenement;
    private String description;
    private String lieuEvenement;
    @Temporal(TemporalType.DATE)
    private Date dateDebutEvenement;
    @Temporal(TemporalType.DATE)
    private Date dateFinEvenement;
    private String organisateur;
    private int nbrMaxInvite;
    private int nbrMinInvite;


    @OneToMany(mappedBy = "event")
    private List<User> users;


}
