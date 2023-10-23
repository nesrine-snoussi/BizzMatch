package tn.esprit.nouveaupartenaire.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.nouveaupartenaire.entities.Contrat;
import tn.esprit.nouveaupartenaire.entities.Partner;
import tn.esprit.nouveaupartenaire.entities.PartnershipRequest;
import tn.esprit.nouveaupartenaire.services.IContratService;
import tn.esprit.nouveaupartenaire.services.IPartnerService;
import tn.esprit.nouveaupartenaire.services.IPartnershipRequestService;

import java.util.List;

@RestController
@RequestMapping("/PartnershipManagment")
public class PartnershipManagement {

    @Autowired
    private IContratService contratService;
    @Autowired
    private IPartnerService partnerService;
    @Autowired
    private IPartnershipRequestService requestService;


    //Partner Creation
    @PostMapping("/createPartner")
    public Partner createPartner(@RequestBody Partner partner) {
        return partnerService.createPartner(partner);
    }


    @GetMapping("/partner/{id}")
    public Partner findById(@PathVariable Long id){
        return partnerService.findById(id);
    }


    @GetMapping("/allPartners")
    public List<Partner> getAllPartners(){
        return partnerService.getAllPartners();
    }


    // Contrat Managment
    @PostMapping("/createContrat")
    public Contrat createContrat(@RequestBody Contrat contrat){
        return contratService.createContrat(contrat);
    }

    @GetMapping("/getContrat/{id}")
    public Contrat findContratById(@PathVariable Long id) {
        return contratService.findById(id);
    }

    //Partnership Managment

    @PostMapping("/addPartnership")
    public PartnershipRequest createRequest (@RequestBody PartnershipRequest request) {
        return requestService.createRequest(request);
    }


    @GetMapping("/partnership/{id}")
    public PartnershipRequest findRequestById (@PathVariable Long id) {
        return requestService.findById(id);
    }


    @GetMapping("/allRequests")
    public List<PartnershipRequest> getPendingRequests(){
        return requestService.getPendingRequests();
    }


    @PostMapping("/acceptRequest")
    public void acceptRequest(@RequestBody PartnershipRequest request){
        requestService.acceptRequest(request);

    }



    @DeleteMapping("/refuseRequest")
    public void rejectRequest(@RequestBody PartnershipRequest request){
        requestService.rejectRequest(request);
    }
}
