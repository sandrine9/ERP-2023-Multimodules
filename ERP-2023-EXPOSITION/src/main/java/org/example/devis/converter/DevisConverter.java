package org.example.devis.converter;

import org.example.application.IComputeService;
import org.example.domaine.Devis;
import org.example.domaine.LigneDevis;
import org.example.dto.DevisDetailsDto;
import org.example.dto.DevisMinDto;
import org.example.dto.LigneDevisDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DevisConverter {

    @Autowired
    IComputeService computeService;

    public Devis convertDevisDetailsDtoToDevis(DevisDetailsDto dto){

        Devis devis=new Devis();
        devis.setDate(dto.getDate());


        List<LigneDevis> lignes=dto.getLignes()
                .stream()
                .map((ligneDto)-> convertLigneDtoToLigneDevis(ligneDto))
                .collect(Collectors.toList());
        devis.setLignes(lignes);
        return devis;
     }

    public DevisDetailsDto convertDevisToDevisDetailsDto(Devis devis){
        DevisDetailsDto devisDto=new DevisDetailsDto();
        devisDto.setDate(devis.getDate());
        devisDto.setLignes(devis.getLignes()
                .stream()
                .map((ligne)->convertLigneDevisToLigneDto(ligne))
                .collect(Collectors.toList()));

        devisDto.setPrixTotalTTC(computeService.calculTotalDevis(devisDto.getLignes()));
        return devisDto;
    }

    public DevisMinDto convertDevisToDevisMinDto(Devis d){
       return null;
    }

    public LigneDevis convertLigneDtoToLigneDevis(LigneDevisDto ligneDto){
        ModelMapper mapper=new ModelMapper();
        return mapper.map(ligneDto,LigneDevis.class);
    }

    public LigneDevisDto convertLigneDevisToLigneDto(LigneDevis ligne){
        ModelMapper mapper=new ModelMapper();
        LigneDevisDto ldevisDto=mapper.map(ligne,LigneDevisDto.class);
        ldevisDto.setMontant(computeService.calculMontantLigne(ldevisDto));
        return ldevisDto;
    }

}
