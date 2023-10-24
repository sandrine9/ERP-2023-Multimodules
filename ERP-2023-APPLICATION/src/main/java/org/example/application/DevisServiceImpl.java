package org.example.application;

import org.example.application.exception.DevisNonConformeException;
import org.example.domaine.Devis;
import org.example.infrastruture.data.IDevisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DevisServiceImpl implements IDevisService {

    @Autowired
    IDevisRepository repository;
    @Override
    public void create(Devis d) throws DevisNonConformeException {
        if(d.getDate().isAfter(LocalDate.now())){
            throw new DevisNonConformeException("La date du devis est postérieure à aujourd'hui");

        }
        repository.save(d);
    }

    @Override
    public List<Devis> findAll() {




        return repository.findAll();
    }

    @Override
    public List<Devis> findAll(Sort s) {
        return repository.findAll(s);
    }

    @Override
    public Devis findById(Long id) {
        return repository.findById(id).get();
    }
}
