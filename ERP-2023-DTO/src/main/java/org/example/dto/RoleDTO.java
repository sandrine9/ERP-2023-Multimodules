package org.example.dto;

public class RoleDTO {

    private Long id;
    private String nom;

    public RoleDTO(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public RoleDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
