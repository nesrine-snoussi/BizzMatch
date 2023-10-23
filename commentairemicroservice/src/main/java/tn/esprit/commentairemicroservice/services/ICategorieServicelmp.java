package tn.esprit.blogmicroservices.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.blogmicroservices.repositories.CategorieRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ICategorieServicelmp implements ICategorieService{
    CategorieRepository categorieRepository;

    @Override
    public Categorie addCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public Categorie updateCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public void removeCategorie(Integer IdCategorie) {
        categorieRepository.deleteById(IdCategorie);
    }

    @Override
    public List<Categorie> getAllCategorie() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie getById(Integer IdCategorie) {
        return categorieRepository.findById(IdCategorie).orElse(null);
    }
}
