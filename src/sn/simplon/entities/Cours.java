package sn.simplon.entities;

import java.util.Date;

public class Cours {
    private int id;
    private String libelle;
    private Date date;
    private String matiere;
    private Professeur professeur = new Professeur();

    public Cours() {
    }

    public Cours(int id, String libelle, Date date, String matiere, Professeur professeur) {
        this.id = id;
        this.libelle = libelle;
        this.date = date;
        this.matiere = matiere;
        this.professeur = professeur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }
}
