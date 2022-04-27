package main;

import sn.simplon.dao.IProfesseur;
import sn.simplon.dao.ProfesseurImpl;
import sn.simplon.entities.Professeur;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rep = 0;
        do {
            System.out.println("============== SIMPLONLINE ==============\n");
            System.out.println("--> 1 : Ajouter un Professeur");
            System.out.println("--> 2 : Ajouter un Cours ");
            System.out.println("--> 3 : Voir la liste des professeurs ");
            System.out.println("--> 4 : Voir la liste des cours");
            System.out.println("==> Faite votre choix");
            rep = sc.nextInt();
        }while (rep > 4);

        switch (rep){
            case 1 :
                System.out.println("--- BIENVENUE SUR L'ESPACE AJOUT PROFESSEUR --\n");
                Professeur professeur = new Professeur();
                IProfesseur ip = new ProfesseurImpl();
                professeur = ip.saisieProf();
                ip.add(professeur);
                break;

            case 2:
                System.out.println("\n--- BIENVENUE SUR L'ESPACE AJOUT COURS --\n");
                break;

            case 3:
                System.out.println("\n--- BIENVENUE SUR L'ESPACE LISTE DES PROFESSEUR --\n");
                break;

            case 4:
                System.out.println("\n--- BIENVENUE SUR L'ESPACE LISTE DES COURS --\n");
                break;
            default:
        }
    }
}
