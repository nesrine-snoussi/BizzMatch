package tn.esprit.servicemicroservices.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.servicemicroservices.Repository.EntrepriseRepository;
import tn.esprit.servicemicroservices.entity.Entreprise;

import java.util.Collections;
import java.util.List;

@Service

public class EntrepriseService implements  EntrepriseServiceImp {
    @Autowired
    EntrepriseRepository entrepriseRepository;
    @Override
    public Entreprise ajouterEntreprise(Entreprise entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    @Override
    public List<Entreprise> getAllEntreprises() {
        return entrepriseRepository.findAll();
    }

    @Override
    public void removeEntreprise(Integer id) {
      entrepriseRepository.deleteAllById(Collections.singleton(id));
    }

    @Override
    public Entreprise updateEntreprise(Entreprise u) {
        return entrepriseRepository.save(u);
    }

}
