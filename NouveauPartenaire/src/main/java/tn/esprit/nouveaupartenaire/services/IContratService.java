package tn.esprit.nouveaupartenaire.services;

import tn.esprit.nouveaupartenaire.entities.Contrat;

public interface IContratService {

    public Contrat createContrat(Contrat contrat);
    public Contrat findById(Long id);
}
