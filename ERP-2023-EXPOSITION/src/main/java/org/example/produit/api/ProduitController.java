package org.example.produit.api;

import org.example.application.IProduitService;
import org.example.dto.ProduitDetailsDto;
import org.example.produit.converter.ProduitConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/produit")
public class ProduitController {

    @Autowired
    IProduitService service;

    @Autowired
    ProduitConverter converter;
    @PostMapping
    public void create(@RequestBody ProduitDetailsDto dto){
        service.create(converter.convertProduitDetailDtoToProduit(dto));
    }
}
