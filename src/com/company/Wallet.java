package com.company;

import java.util.*;

public class Wallet
{

    // tableau contenant le nombre de pièce(s)/billet(s) que l'on peut utiliser au maximum
    int[] tabMoneyLimite = new int[15];
    //tableau contenant le nombre de pièce(s)/billet(s) rendu
    int[] tabMoney = new int[15];

    // La variable money contient le prix donner par l'utilisateur
    double money;
    // Tableau contenant la valeur des différents pièces/billets
    double[] tabPrix = new double[] {500.00, 200.00, 100.00, 50.00, 20.00, 10.00, 5.00, 2.00, 1.00, 0.50, 0.20, 0.10, 0.05, 0.02, 0.01};

    // Variable pour stocker combien d'argent il reste à rendre
    Decimal2 compter = new Decimal2();
    // Variable pour stocker l'argent rendu
    Decimal2 rendu = new Decimal2(0,0);
    // Variable pour stocker la valeur de la pièce/billet utilisé
    Decimal2 moneyValue = new Decimal2();

    public static void main(String[] args)
    {
        // Création d'un objet Wallet afin d'appeller des variables et méthodes non static dans le main
        Wallet w = new Wallet();

        // La variable money contient le prix donner par l'utilisateur, rendu contient le prix rendu par le programme et compter contient la même chose que money mais permet de fair les calculs dans les boucles sans toucher à money
        w.rendu.setNumber(0.00);

        System.out.print("Donner un prix :");
        // Demande à l'utilisateur de saisir un prix
        Scanner sc = new Scanner(System.in);

        // Boucle pour vérifier que la saisie utilisateur est un double, sinon il redemande jusqu'a son obtention
        while(!sc.hasNextDouble())
        {
            System.out.println("\u001B[31m Votre nombre n'est pas nombre decimal de format ##,## \u001B[0m");
            System.out.print("Donner un nouveau prix :");
            sc.next();
        }

        w.money = sc.nextDouble();
        w.compter.setNumber(w.money);

        // Remplissage du tableau tabMoneyLimite
        w.iniTabMoneyLimite();

        // Initialise à 0 le tableau tabMoney contenant le nombre et le type de pièces utilisé pour arriver au prix saisie par l'utilisateur
        for (int i : w.tabMoney)
        {
            w.tabMoney[i] = 0;
        }

        double transaction;

        // Boucle pour vérifier si on à rendu le prix exacte
        while (w.rendu.getNumber() != w.money & w.compter.getNumber() > 0.00)
        {
            transaction = w.compter.getNumber();
            // Vérifie s'il reste au moins 500 euros à rendre
            if (transaction >= w.tabPrix[0] & w.pieceDisponible(0))
            {
                w.calcul(0);
            }
            // Vérifie s'il reste au moins 200 euros à rendre
            else if (transaction >= w.tabPrix[1] & w.pieceDisponible(1))
            {
                w.calcul(1);
            }
            // Vérifie s'il reste au moins 100 euros à rendre
            else if (transaction >= w.tabPrix[2] & w.pieceDisponible(2))
            {
                w.calcul(2);
            }
            // Vérifie s'il reste au moins 50 euros à rendre
            else if (transaction >= w.tabPrix[3] & w.pieceDisponible(3))
            {
                w.calcul(3);
            }
            // Vérifie s'il reste au moins 20 euros à rendre
            else if (transaction >= w.tabPrix[4] & w.pieceDisponible(4))
            {
                w.calcul(4);
            }
            // Vérifie s'il reste au moins 10 euros à rendre
            else if (transaction >= w.tabPrix[5] & w.pieceDisponible(5))
            {
                w.calcul(5);
            }
            // Vérifie s'il reste au moins 5 euros à rendre
            else if (transaction >= w.tabPrix[6] & w.pieceDisponible(6))
            {
                w.calcul(6);
            }
            // Vérifie s'il reste au moins 2 euros à rendre
            else if (transaction >= w.tabPrix[7] & w.pieceDisponible(7))
            {
                w.calcul(7);
            }
            // Vérifie s'il reste au moins 1 euro à rendre
            else if (transaction >= w.tabPrix[8] & w.pieceDisponible(8))
            {
                w.calcul(8);
            }
            // Vérifie s'il reste au moins 0,50 euro à rendre
            else if (transaction >= w.tabPrix[9] & w.pieceDisponible(9))
            {
                w.calcul(9);
            }
            // Vérifie s'il reste au moins 0,20 euro à rendre
            else if (transaction >= w.tabPrix[10] & w.pieceDisponible(10))
            {
                w.calcul(10);
            }
            // Vérifie s'il reste au moins 0,10 euro à rendre
            else if (transaction >= w.tabPrix[11] & w.pieceDisponible(11))
            {
                w.calcul(11);
            }
            // Vérifie s'il reste au moins 0,05 euro à rendre
            else if (transaction >= w.tabPrix[12] & w.pieceDisponible(12))
            {
                w.calcul(12);
            }
            // Vérifie s'il reste au moins 0,02 euro à rendre
            else if (transaction >= w.tabPrix[13] & w.pieceDisponible(13))
            {
                w.calcul(13);
            }
            // Vérifie s'il reste au moins 0,01 euro à rendre
            else if (transaction >= w.tabPrix[14] & w.pieceDisponible(14))
            {
                w.calcul(14);
            }
            else
            {
                System.out.println("\n \u001B[31m" +" Veuillez nous excusez, il n'y a plus assez de pièces/billets pour atteindre le prix " +"\u001B[0m");
                break;
            }
        }

        // Chaîne de caractère qui contient l'affichage final
        StringBuilder rep = new StringBuilder("\n Rendu : \n");

        // Boucle pour afficher le nombre et le type de pièces/billets utilisés
        for (int j = 0 ; j < w.tabMoney.length; j++)
        {
            // Pour les billets
            if (j < 7)
            {
                // S'il y a au moins 1 billet
                if(w.tabMoney[j] > 0)
                {
                    rep.append("\u001B[32m    ").append(w.tabMoney[j]).append(" billet(s) de ").append(w.tabPrix[j]).append(" €\u001B[0m ").append("\n");
                }
            }
            // Pour les pièces
            else
            {
                // S'il y a au moins 1 pièce
                if(w.tabMoney[j] > 0)
                {
                    rep.append("\u001B[33m    ").append(w.tabMoney[j]).append(" pièce(s) de ").append(w.tabPrix[j]).append(" €\u001B[0m").append("\n");
                }
            }
        }

        rep.append("\n").append("Soit un total de : ") .append(w.rendu.getNumber()).append(" €");
        System.out.println(rep);
        sc.close();
    }


    // Méthode pour initialiser tabMoneyLimite en demande combien de pièces/billets pour chaque tranche d'argent
    public void iniTabMoneyLimite()
    {
        Scanner sc = new Scanner(System.in);
        String aff;

        for (int l = 0; l < tabMoney.length; l++)
        {
           if (l < 7)
           {
              aff = "Combien de billet(s) de " + tabPrix[l] + "€ : ";
           }
           else
           {
              aff = "Combien de pièce(s) de " + tabPrix[l] + "€ : ";
           }

           System.out.print(aff);
           while (!sc.hasNextInt())
           {
               System.out.print(aff);
               sc.next();
           }
            tabMoneyLimite[l] = sc.nextInt();
        }
    }


    // Méthode pour calculer l'argent à rendre restant et pour modifier le nombre de pièce/billet limite disponible ainsi que le nombre de pièce/billet utilisé
    public void calcul(int i)
    {
        this.moneyValue.setNumber(this.tabPrix[i]);
        this.compter.soustraction(this.moneyValue);
        this.rendu.addition(this.moneyValue);

        this.tabMoney[i] = this.tabMoney[i] + 1;
        this.tabMoneyLimite[i] = this.tabMoneyLimite[i] - 1;
    }


    // Méthode qui retourne s'il reste au moins 1 pièce/billet dans le tableau tabMoneyLimite à un indice c donné
    public boolean pieceDisponible(int c)
    {
        return tabMoneyLimite[c] >= 1;
    }
}