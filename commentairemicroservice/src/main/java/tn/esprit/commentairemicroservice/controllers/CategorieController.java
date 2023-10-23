package tn.esprit.blogmicroservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.blogmicroservices.services.ICategorieService;

import java.util.List;

@RestController
@RequestMapping("/categorie")
public class CategorieController {
    @Autowired
    ICategorieService iCategorieService ;

    @PostMapping
    public ResponseEntity addCategorie(@RequestBody Categorie categorie) {

        iCategorieService.addCategorie(categorie);
        return new ResponseEntity<>("categorie ajouté avec sucées!", HttpStatus.OK);
    }

    @PutMapping
    public Categorie updateCategorie(@RequestBody Categorie categorie ) {

        return iCategorieService.updateCategorie(categorie);
    }

    @GetMapping
    public List<Categorie> findAllCategorie() {
        return iCategorieService.getAllCategorie();
    }

    @GetMapping("/{idCategorie}")
    public Categorie findCategorieById(@PathVariable int idCategorie) {
        return iCategorieService.getById(idCategorie);
    }

    @DeleteMapping("/{idCategorie}")
    public ResponseEntity removeCategorie(@PathVariable int idCategorie) {

        iCategorieService.removeCategorie(idCategorie);
        return new ResponseEntity<>("Categorie a été Supprimé!", HttpStatus.OK);

    }

}
