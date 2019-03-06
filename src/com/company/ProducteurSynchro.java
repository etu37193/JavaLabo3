package com.company;

import javax.swing.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ProducteurSynchro extends Thread{
    private ZoneCommune commun;
    public ProducteurSynchro(ZoneCommune commun){
        super("producteur");
        this.commun = commun;
    }

    public void run(){
        for(int i = 1;i<=10;i++) {
            try {
                Thread.sleep((int)(Math.random() * 3000));
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }

            ObjectInputStream entree = null;
            try {
                entree = new ObjectInputStream(new FileInputStream("etudiant.txt"));
                Etudiant etu0;
                etu0 = (Etudiant)entree.readObject(); //Casting Obligatoire
                while (etu0 != null){
                    commun.setEtudiant(etu0);
                    etu0 = (Etudiant) entree.readObject();
                }
            } catch (EOFException eofException){
                System.out.println("Plus d'enregistrement");
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(null, ioException.getMessage());
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage());
            }

            finally {
                if(entree != null){
                    try{
                        entree.close();
                    } catch (IOException ioException) {
                        JOptionPane.showMessageDialog(null, ioException.getMessage());
                    }
                }
            }
        }
    }
}
