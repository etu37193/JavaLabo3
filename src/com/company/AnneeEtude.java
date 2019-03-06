package com.company;

import java.io.Serializable;

public class AnneeEtude implements Serializable{
    private String intituleEtude;
    private int annee;
    private String niveau;

    public AnneeEtude(String intituleEtude, int annee, String niveau) {
        this.intituleEtude = intituleEtude;
        this.annee = annee;
        this.niveau = niveau;
    }
    /*GETTER ET SETTER*/
    public String getIntituleEtude() {
        return intituleEtude;
    }

    public int getAnnee() {
        return annee;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setIntituleEtude(String intituleEtude) {
        this.intituleEtude = intituleEtude;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    @Override
    public String toString(){
        return this.niveau + " " + this.annee + " en " + this.intituleEtude;
    }
}
