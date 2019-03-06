package com.company;

public class ConsommateurSynchro extends Thread{
    private ZoneCommune commun;
    public ConsommateurSynchro(ZoneCommune commun){
        super("consommateur");
        this.commun = commun;
    }

    public void run(){
        Etudiant etu0;
        for (int i = 1; i<= 10;i++){
            try {
                Thread.sleep((int)(Math.random()*3000));
            } catch(InterruptedException exception) {
                exception.printStackTrace();
            }
            etu0 = commun.getEtudiant();
            System.out.println(etu0);
        }
    }
}
