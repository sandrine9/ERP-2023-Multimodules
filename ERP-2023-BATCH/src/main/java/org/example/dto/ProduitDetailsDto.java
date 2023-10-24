package org.example.dto;

import com.opencsv.bean.CsvBindByName;

import java.math.BigDecimal;

public class ProduitDetailsDto {

    @CsvBindByName
    private String nom;

    @CsvBindByName(column="photo")
    private String photoUrl;
    @CsvBindByName(column="prixHT")
    private BigDecimal prixHt;

    @CsvBindByName
    private String description;

    public ProduitDetailsDto( String nom, String photoUrl, BigDecimal prixHt, String description) {

        this.nom = nom;
        this.photoUrl = photoUrl;
        this.prixHt = prixHt;
        this.description = description;
    }

    public ProduitDetailsDto() {
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public BigDecimal getPrixHt() {
        return prixHt;
    }

    public void setPrixHt(BigDecimal prixHt) {
        this.prixHt = prixHt;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
