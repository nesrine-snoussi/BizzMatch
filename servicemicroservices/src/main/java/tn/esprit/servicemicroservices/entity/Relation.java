package tn.esprit.servicemicroservices.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Relation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "demanding_company_id")
    private Entreprise demandingEntreprise;

    @ManyToOne
    @JoinColumn(name = "accepting_company_id")
    private Entreprise acceptingEntreprise;

    @Enumerated(EnumType.STRING)
    private Status status;// Utilisez un enum ou une chaîne pour représenter le statut.
    private Date creationDate;


}
