package tn.esprit.nouveaupartenaire.services;

import tn.esprit.nouveaupartenaire.entities.PartnershipRequest;

import java.util.List;

public interface IPartnershipRequestService {
    public PartnershipRequest createRequest (PartnershipRequest request);
    public PartnershipRequest findById (Long id);
    public List<PartnershipRequest> getPendingRequests();
    public void acceptRequest(PartnershipRequest request);
    public void rejectRequest(PartnershipRequest request);
}
