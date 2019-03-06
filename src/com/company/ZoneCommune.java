package com.company;

public class ZoneCommune {
    private Etudiant etudiant;
    private boolean aEcraser = true;

    public synchronized Etudiant getEtudiant(){
        if(aEcraser){
            try {
                wait();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " lit la valeur " + etudiant);
        aEcraser = true;
        notify();
        return etudiant;
    }

    public synchronized void setEtudiant(Etudiant etudiant){
        if (!aEcraser){
            try {
                wait();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        this.etudiant = etudiant;
        System.out.println(Thread.currentThread().getName() + " écrit la valeur " + this.etudiant);
        aEcraser = false;
        notify();
    }
}
