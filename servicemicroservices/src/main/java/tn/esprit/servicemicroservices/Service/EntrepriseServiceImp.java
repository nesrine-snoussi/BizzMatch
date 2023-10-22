package tn.esprit.servicemicroservices.Service;

import tn.esprit.servicemicroservices.entity.Entreprise;

import java.util.List;

public interface EntrepriseServiceImp {
    Entreprise ajouterEntreprise(Entreprise entreprise);

    List<Entreprise> getAllEntreprises();

    void removeEntreprise(Integer id);

    Entreprise updateEntreprise(Entreprise u);

}
