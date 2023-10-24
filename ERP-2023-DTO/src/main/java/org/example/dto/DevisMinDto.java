package org.example.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DevisMinDto {
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    private Long idClient;

    private BigDecimal prixTotalTTC;

    public DevisMinDto(Long id, LocalDate date, Long idClient, BigDecimal prixTotalTTC) {
        this.id = id;
        this.date = date;
        this.idClient = idClient;
        this.prixTotalTTC = prixTotalTTC;
    }

    public DevisMinDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public BigDecimal getPrixTotalTTC() {
        return prixTotalTTC;
    }

    public void setPrixTotalTTC(BigDecimal prixTotalTTC) {
        this.prixTotalTTC = prixTotalTTC;
    }
}
