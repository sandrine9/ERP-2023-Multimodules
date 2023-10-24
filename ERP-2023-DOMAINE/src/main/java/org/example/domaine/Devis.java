package org.example.domaine;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Devis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dateDevis")
    private LocalDate date;


    private Long idClient;

    @OneToMany(cascade = CascadeType.ALL)
    private List<LigneDevis> lignes;

    public Devis(LocalDate date, List<LigneDevis> lignes) {
        this.date = date;

        this.lignes = lignes;
    }

    public Devis(Long id, LocalDate date, Long idClient, List<LigneDevis> lignes) {
        this.id = id;
        this.date = date;
        this.idClient = idClient;
        this.lignes = lignes;
    }

    public Devis() {
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

    public Long getIdCLient() {
        return idClient;
    }

    public void setIdCLient(Long idCLient) {
        this.idClient = idCLient;
    }

    public List<LigneDevis> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneDevis> lignes) {
        this.lignes = lignes;
    }
}
