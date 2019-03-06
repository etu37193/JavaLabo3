package com.company;

import javax.swing.*;
import java.io.*;

import static javax.swing.JOptionPane.ERROR_MESSAGE;


public class Main {

    public static void main(String[] args) {
        /*
        //Écriture
        ObjectOutputStream sortie = null;
        try{
            sortie = new ObjectOutputStream(new FileOutputStream("etudiant.txt"));
            sortie.writeObject(new Etudiant("Michaux", "William", new AnneeEtude("Info", 2, "bac")));
            sortie.writeObject(new Etudiant("Mosselman", "Quentin", new AnneeEtude("Info", 3, "bac")));
            sortie.writeObject(new Etudiant("Dieudonne", "Cedric", new AnneeEtude("Info", 2, "bac")));
            sortie.writeObject(new Etudiant("Matin", "Martin", new AnneeEtude("Info", 1, "bac")));
            sortie.writeObject(new Etudiant("Hitler", "Adolf", new AnneeEtude("Info", 1, "master")));
            sortie.writeObject(new Etudiant("Michel", "Michel", new AnneeEtude("Market", 3, "bac")));
        } catch (IOException iOException){
            JOptionPane.showMessageDialog(null, iOException.getMessage());
        }

        finally {
            if (sortie != null) {
                try{
                    sortie.close();
                } catch (IOException ioException){
                    JOptionPane.showMessageDialog(null, ioException.getMessage());
                }
            }
        }
        //Lecture
        ObjectInputStream entree = null;
        try {
            entree = new ObjectInputStream(new FileInputStream("etudiant.txt"));
            Etudiant etu0;
            etu0 = (Etudiant)entree.readObject(); //Casting Obligatoire
            while (etu0 != null){
                System.out.println(etu0);
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
        }*/
        ZoneCommune zone = new ZoneCommune();

        ProducteurSynchro producteur = new ProducteurSynchro(zone);
        ConsommateurSynchro consommateur = new ConsommateurSynchro(zone);

        producteur.start();
        consommateur.start();
    }
}
