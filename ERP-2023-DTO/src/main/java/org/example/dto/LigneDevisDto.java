package org.example.dto;


import java.math.BigDecimal;

public class LigneDevisDto {

    private Long id;

    private ProduitDetailsDto produit;

    private int qte;

    private BigDecimal remise;

    private BigDecimal montant;

    public LigneDevisDto(Long id, ProduitDetailsDto produit, int qte, BigDecimal remise,BigDecimal montant) {
        this.id = id;
        this.produit = produit;
        this.qte = qte;
        this.remise = remise;
        this.montant = montant;
    }

    public LigneDevisDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProduitDetailsDto getProduit() {
        return produit;
    }

    public void setProduit(ProduitDetailsDto produit) {
        this.produit = produit;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public BigDecimal getRemise() {
        return remise;
    }

    public void setRemise(BigDecimal remise) {
        this.remise = remise;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }
}
