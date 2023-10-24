package org.example.writer;

import org.example.application.IProduitService;
import org.example.domaine.Produit;
import org.example.infrastruture.data.IProduitRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseProduitWriter implements ItemWriter<Produit> {

    @Autowired
    IProduitService service;

    @Override
    public void write(List<? extends Produit> list) throws Exception {
        for(Produit p:list){
            service.create(p); //Begin commit
        }

    }
}
