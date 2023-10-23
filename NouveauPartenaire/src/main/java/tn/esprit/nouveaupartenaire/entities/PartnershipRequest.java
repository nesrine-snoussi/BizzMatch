package tn.esprit.nouveaupartenaire.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartnershipRequest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String companyName;
    private String contactName;
    private String contactEmail;
    private String additionalInfo;
    private Boolean accepted ;

    @ManyToOne
    private Partner partner;
}
