package tn.esprit.nouveaupartenaire.services;

import tn.esprit.nouveaupartenaire.entities.Partner;

import java.util.List;

public interface IPartnerService {

    public Partner createPartner(Partner partner);
    public Partner findById(Long id);
    public List<Partner> getAllPartners();
}
