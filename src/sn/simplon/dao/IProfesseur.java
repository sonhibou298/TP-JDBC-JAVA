package sn.simplon.dao;

import sn.simplon.entities.Professeur;

import java.util.List;

public interface IProfesseur {
    public int add(Professeur professeur);
    public List<Professeur> listeProfesseur();
    public int update(Professeur professeur);
    public Professeur saisieProf();
}
