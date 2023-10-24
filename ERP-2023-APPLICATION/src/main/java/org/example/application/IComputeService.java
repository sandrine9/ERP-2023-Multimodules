package org.example.application;

import org.example.application.util.ConstantUtil;
import org.example.dto.LigneDevisDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class IComputeService implements ICompute{

    @Override
    public BigDecimal calculPrixTTC(BigDecimal prixHT) {

        System.out.println("FROM APPLICATION PROPERTIES "+prixHT.multiply(new BigDecimal(ConstantUtil.ERP_TAX_RATE_PROPERTIES)));
        System.out.println("FROM CONSTANT CLASS "+new BigDecimal(ConstantUtil.ERP_TAX_RATE));

        return prixHT.multiply(new BigDecimal(ConstantUtil.ERP_TAX_RATE));
    }

    @Override
    public BigDecimal calculTotalDevis(List<LigneDevisDto> lignesDto) {
       return lignesDto
                .stream()
                .map(ligneDevisDto -> ligneDevisDto.getMontant())
                .reduce(BigDecimal::add)
                .get();



     //ou
      // BigDecimal result=BigDecimal.ZERO;
      //  for(LigneDevisDto ldto: lignesDto){
      //      result=result.add(ldto.getMontant());
      //    }
       // return result;

    }

    @Override
    public BigDecimal calculMontantLigne(LigneDevisDto ligne) {

        return ligne
                .getProduit().getPrixHt()
                .multiply(new BigDecimal(ligne.getQte()))
                .subtract(ligne.getRemise());
    }
}
