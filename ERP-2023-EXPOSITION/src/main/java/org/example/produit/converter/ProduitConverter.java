package org.example.produit.converter;

import org.example.domaine.Produit;
import org.example.dto.ProduitDetailsDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProduitConverter {



    public Produit convertProduitDetailDtoToProduit(ProduitDetailsDto dto){
        ModelMapper mapper=new ModelMapper();
        return mapper.map(dto,Produit.class);
    }
}
