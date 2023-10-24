package org.example.devis.api;

import org.example.application.IDevisService;
import org.example.application.exception.DevisNonConformeException;
import org.example.devis.converter.DevisConverter;
import org.example.domaine.Devis;
import org.example.dto.DevisDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class DevisController {

    @Autowired
    IDevisService devisService;

    @Autowired
    DevisConverter converter;
    @PostMapping("/devis")
    public void create(@RequestBody  DevisDetailsDto dto) throws DevisNonConformeException {

        devisService.create(converter.convertDevisDetailsDtoToDevis(dto));
    }

    @GetMapping("/devis/{id}")
    public DevisDetailsDto findById(@PathVariable("id") Long id){
        Devis devis=devisService.findById(id);
        return converter.convertDevisToDevisDetailsDto(devis);
    }
}
