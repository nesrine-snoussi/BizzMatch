package tn.esprit.nouveaupartenaire.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.nouveaupartenaire.entities.Contrat;
import tn.esprit.nouveaupartenaire.repositories.ContratRepository;

@Service
public class ContratServiceImp implements IContratService{

    @Autowired
    private ContratRepository contratRepository;



    @Override
    public Contrat createContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat findById(Long id) {
        return contratRepository.findById(id).orElse(null);
    }
}
