package model;

import java.util.ArrayList;
import java.util.List;

public class Veterinario {
    private Long id_vet;
    private String nom_vet;
    private String end_vet;
    private String tel_vet;
    List<Consulta> consultas = new ArrayList<>();

    public Veterinario() {
    }

    public Veterinario(Long id_vet, String nom_vet, String end_vet, String tel_vet, List<Consulta> consultas) {
        this.id_vet = id_vet;
        this.nom_vet = nom_vet;
        this.end_vet = end_vet;
        this.tel_vet = tel_vet;
        this.consultas = consultas;
    }

    public Long getId_vet() {
        return id_vet;
    }

    public void setId_vet(Long id_vet) {
        this.id_vet = id_vet;
    }

    public String getNom_vet() {
        return nom_vet;
    }

    public void setNom_vet(String nom_vet) {
        this.nom_vet = nom_vet;
    }

    public String getEnd_vet() {
        return end_vet;
    }

    public void setEnd_vet(String end_vet) {
        this.end_vet = end_vet;
    }

    public String getTel_vet() {
        return tel_vet;
    }

    public void setTel_vet(String tel_vet) {
        this.tel_vet = tel_vet;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    @Override
    public String toString() {
        return "\nVeterinario{" +
                "id_vet='" + id_vet + '\'' +
                ", nom_vet='" + nom_vet + '\'' +
                ", end_vet='" + end_vet + '\'' +
                ", tel_vet='" + tel_vet + '\'' +
                '}';
    }
}
