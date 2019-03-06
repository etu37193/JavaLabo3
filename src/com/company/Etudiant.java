package com.company;

import java.io.Serializable;

public class Etudiant implements Serializable{
    private String nom;
    private String prenom;
    private AnneeEtude anneeEtude;

    public Etudiant(String nom, String prenom, AnneeEtude anneeEtude) {
        this.nom = nom;
        this.prenom = prenom;
        this.anneeEtude = anneeEtude;
    }

    @Override
    public String toString(){
        return this.prenom + " " + this.nom + " est inscrit en " + this.anneeEtude;
    }
}
