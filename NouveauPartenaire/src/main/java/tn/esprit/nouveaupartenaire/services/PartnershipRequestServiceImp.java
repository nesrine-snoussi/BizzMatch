package tn.esprit.nouveaupartenaire.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.nouveaupartenaire.entities.PartnershipRequest;
import tn.esprit.nouveaupartenaire.repositories.PartnershipRequestRepository;

import java.util.List;

@Service
public class PartnershipRequestServiceImp implements IPartnershipRequestService{

    @Autowired
    PartnershipRequestRepository requestRepository;


    @Override
    public PartnershipRequest createRequest(PartnershipRequest request) {
        return requestRepository.save(request);
    }

    @Override
    public PartnershipRequest findById(Long id) {
        return requestRepository.findById(id).orElse(null);
    }

    @Override
    public List<PartnershipRequest> getPendingRequests() {
        return requestRepository.findByAcceptedFalse();
    }

    @Override
    public void acceptRequest(PartnershipRequest request) {

        request.setAccepted(true);
        requestRepository.save(request);

    }

    @Override
    public void rejectRequest(PartnershipRequest request) {
        requestRepository.delete(request);

    }
}
