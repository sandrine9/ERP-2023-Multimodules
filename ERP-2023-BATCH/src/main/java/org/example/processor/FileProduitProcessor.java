package org.example.processor;

import org.example.domaine.Produit;
import org.example.dto.ProduitDetailsDto;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class FileProduitProcessor implements ItemProcessor<ProduitDetailsDto, Produit> {

    @Override
    public Produit process(ProduitDetailsDto dto) throws Exception {
        Produit p=new Produit();
        p.setNom(dto.getNom());
        p.setDescription(dto.getDescription().length()>=255 ? dto.getDescription().substring(0,250) : dto.getDescription());
        p.setPrixHt(dto.getPrixHt());
        p.setPhotoUrl(dto.getPhotoUrl());
        return p;
    }
}
