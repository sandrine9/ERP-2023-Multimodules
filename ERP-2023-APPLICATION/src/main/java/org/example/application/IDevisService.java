package org.example.application;

import org.example.application.exception.DevisNonConformeException;
import org.example.domaine.Devis;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IDevisService {

    void create(Devis d) throws DevisNonConformeException;

    List<Devis> findAll();

    List<Devis> findAll(Sort s);

    Devis findById(Long id);
}
