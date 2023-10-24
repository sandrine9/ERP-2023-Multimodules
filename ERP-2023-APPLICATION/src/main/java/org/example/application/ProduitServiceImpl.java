package org.example.application;

import org.example.infrastruture.messaging.IInventaireMessaging;
import org.example.infrastruture.messaging.dto.MessageInventaireDto;
import org.example.domaine.Produit;
import org.example.infrastruture.data.IProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
public class ProduitServiceImpl implements IProduitService {

    @Autowired
    IProduitRepository repository;

    @Autowired
    IInventaireMessaging messageProduit;


    @Override
    @Transactional
    public void create(Produit p) {

        repository.save(p);

        MessageInventaireDto dto=new MessageInventaireDto(p.getId(),1);
        messageProduit.send(dto);

    }

    @Override
    public Produit findById(Long id) {return repository.findById(id).get();}

    @Override
    public List<Produit> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Produit> findAll(Sort sort) {
        return repository.findAll(sort);
    }
}
