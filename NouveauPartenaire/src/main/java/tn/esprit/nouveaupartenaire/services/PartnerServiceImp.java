package tn.esprit.nouveaupartenaire.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.nouveaupartenaire.entities.Partner;
import tn.esprit.nouveaupartenaire.repositories.PartnerRepository;

import java.util.List;
@Service
public class PartnerServiceImp implements  IPartnerService{

    @Autowired
    PartnerRepository partnerRepository;
    @Override
    public Partner createPartner(Partner partner) {
        return partnerRepository.save(partner);
    }

    @Override
    public Partner findById(Long id) {
        return partnerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Partner> getAllPartners() {
        return partnerRepository.findAll();
    }
}
