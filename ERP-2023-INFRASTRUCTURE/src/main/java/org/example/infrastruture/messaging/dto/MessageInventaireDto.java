package org.example.infrastruture.messaging.dto;

public class MessageInventaireDto {
     private Long productId;
     private int qte;

    public MessageInventaireDto(Long productId, int qte) {
        this.productId = productId;
        this.qte = qte;
    }

    public MessageInventaireDto() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
}
