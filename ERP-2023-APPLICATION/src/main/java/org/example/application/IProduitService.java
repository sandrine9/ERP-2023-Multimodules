package org.example.application;

import org.example.domaine.Produit;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IProduitService {

    void create(Produit p);
    Produit findById(Long id);

    List<Produit> findAll();

    List<Produit> findAll(Sort sort);
}
