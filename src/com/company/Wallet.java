package com.company;

import java.util.*;

public class Wallet
{
    // tableau contenant le nombre de pièce(s)/billet(s) que l'on peut utiliser au maximum
    int[] tabmoneyLimite = new int[15];
    //tableau contenant le nombre de pièce(s)/billet(s) rendu
    int[] tabmoney = new int[15];

    // La variable money contient le prix donner par l'utilisateur, rendu contient le prix rendu par le programme et compter contient la même chose que money mais permet de fair les calculs dans les boucles sans toucher à money
    double money, rendu, compter;
    //tableau contenant la valeur des différents pièces/billets
    double[] tabprix = new double[] {500, 200, 100, 50, 20, 10, 5, 2, 1, 0.50, 0.20, 0.10, 0.05, 0.02, 0.01};

    public static void main(String[] args)
    {
        // Création d'un objet Wallet afin d'appeller des variables et méthodes non static dans le main
        Wallet w = new Wallet();

        // La variable money contient le prix donner par l'utilisateur, rendu contient le prix rendu par le programme et compter contient la même chose que money mais permet de fair les calculs dans les boucles sans toucher à money
        w.rendu = 0.00;

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
        w.compter = w.money;

        // Remplissage du tableau tabmoneyLimite
        w.iniTabMoneyLimite();

        // Initialise à 0 le tableau tabmoney contenant le nombre et le type de pièces utilisé pour arriver au prix saisie par l'utilisateur
        for (int i : w.tabmoney)
        {
            w.tabmoney[i] = 0;
        }

        // Boucle pour vérifier si on à rendu le prix exacte
        while (w.rendu != w.money & w.compter > 0.00)
        {
            // Vérifie s'il reste au moins 500 euros à rendre
            if (w.compter - 500.00 >= 0.00 & w.pieceDisponible(0))
            {
                w.calcul(0);
            }
            // Vérifie s'il reste au moins 200 euros à rendre
            else if (w.compter - 200.00 >= 0.00 & w.pieceDisponible(1))
            {
                w.calcul(1);
            }
            // Vérifie s'il reste au moins 100 euros à rendre
            else if (w.compter - 100.00 >= 0.00 & w.pieceDisponible(2))
            {
                w.calcul(2);
            }
            // Vérifie s'il reste au moins 50 euros à rendre
            else if (w.compter - 50.00 >= 0.00 & w.pieceDisponible(3))
            {
                w.calcul(3);
            }
            // Vérifie s'il reste au moins 20 euros à rendre
            else if (w.compter - 20.00 >= 0.00 & w.pieceDisponible(4))
            {
                w.calcul(4);
            }
            // Vérifie s'il reste au moins 10 euros à rendre
            else if (w.compter - 10.00 >= 0.00 & w.pieceDisponible(5))
            {
                w.calcul(5);
            }
            // Vérifie s'il reste au moins 5 euros à rendre
            else if (w.compter - 5.00 >= 0.00 & w.pieceDisponible(6))
            {
                w.calcul(6);
            }
            // Vérifie s'il reste au moins 2 euros à rendre
            else if (w.compter - 2.00 >= 0.00 & w.pieceDisponible(7))
            {
                w.calcul(7);
            }
            // Vérifie s'il reste au moins 1 euro à rendre
            else if (w.compter - 1.00 >= 0.00 & w.pieceDisponible(8))
            {
                w.calcul(8);
            }
            // Vérifie s'il reste au moins 0,50 euro à rendre
            else if (w.compter - 0.50 >= 0.00 & w.pieceDisponible(9))
            {
                w.calcul(9);
            }
            // Vérifie s'il reste au moins 0,20 euro à rendre
            else if (w.compter - 0.20 >= 0.00 & w.pieceDisponible(10))
            {
                w.calcul(10);
            }
            // Vérifie s'il reste au moins 0,10 euro à rendre
            else if (w.compter - 0.10 >= 0.00 & w.pieceDisponible(11))
            {
                w.calcul(11);
            }
            // Vérifie s'il reste au moins 0,05 euro à rendre
            else if (w.compter - 0.05 >= 0.00 & w.pieceDisponible(12))
            {
                w.calcul(12);
            }
            // Vérifie s'il reste au moins 0,02 euro à rendre
            else if (w.compter - 0.02 >= 0.00 & w.pieceDisponible(13))
            {
                w.calcul(13);
            }
            // Vérifie s'il reste au moins 0,01 euro à rendre
            else if (w.compter - 0.01 >= 0.00 & w.pieceDisponible(14))
            {
                w.calcul(14);
            }
            else
            {
                // Vérifie s'il reste suffisament d'argent pour atteindre le prix demandé
                if(!w.resteMoney(w.compter))
                {
                    System.out.println("\n \u001B[31m" +" Veuillez nous excusez, il n'y a plus assez de pièces/billets pour atteindre le prix " +"\u001B[0m");
                }
                else
                {
                    System.out.println("\n" + "money : " + w.money);
                    System.out.println("rendu : " + w.rendu);
                    System.out.println("compter : " + w.compter);
                    System.out.println("\u001B[31m" + "Il y a une erreur !" +"\u001B[0m");

                }
                break;
            }

            // Arrondi à la valeur supérieur afin de minimiser les approximations lors des calculs précédent
            w.rendu = Math.round(w.rendu*100)/100d;
            w.compter = Math.round(w.compter*100)/100d;
        }

        // chaine de caractère qui contient l'affichage final
        StringBuilder rep = new StringBuilder("\n Rendu : \n");

        // Boucle pour afficher le nombre et le type de pièces/billets utilisés
        for (int j = 0 ; j < w.tabmoney.length; j++)
        {
            // Pour les billets
            if (j < 7)
            {
                // S'il y a au moins 1 billet
                if(w.tabmoney[j] > 0)
                {
                    rep.append("\u001B[32m    ").append(w.tabmoney[j]).append(" billet(s) de ").append(w.tabprix[j]).append(" €\u001B[0m ").append("\n");
                }
            }
            // Pour les pièces
            else
            {
                // S'il y a au moins 1 pièce
                if(w.tabmoney[j] > 0)
                {
                    rep.append("\u001B[33m    ").append(w.tabmoney[j]).append(" pièce(s) de ").append(w.tabprix[j]).append(" €\u001B[0m").append("\n");
                }
            }
        }

        rep.append("\n").append("Soit un total de : ") .append(w.rendu).append("€");
        System.out.println(rep);
        sc.close();
    }


    // Méthode pour initialiser tabmoneyLimite en demande combien de pièces/billets pour chaque tranche d'argent
    public void iniTabMoneyLimite()
    {
        Scanner sc = new Scanner(System.in);
        String aff;

        for (int l = 0; l < tabmoney.length; l++)
        {
           if (l < 7)
           {
              aff = "Combien de billet(s) de " + tabprix[l] + "€ : ";
           }
           else
           {
              aff = "Combien de pièce(s) de " + tabprix[l] + "€ : ";
           }

           System.out.print(aff);
           while (!sc.hasNextInt())
           {
               System.out.print(aff);
               sc.next();
           }
            tabmoneyLimite[l] = sc.nextInt();
        }
    }


    // Méthode pour calculer l'argent à rendre restant et pour modifier le nombre de pièce/billet limite disponible ainsi que le nombre de pièce/billet utilisé
    public void calcul(int i)
    {
        compter = compter - tabprix[i];
        rendu = rendu + tabprix[i];
        tabmoney[i] = tabmoney[i] + 1;
        tabmoneyLimite[i] = tabmoneyLimite[i] - 1;
    }


    // Méthode qui permet de savoir s'il y a assez d'argent pour atteindre le prix
    public boolean resteMoney(double rendre)
    {
        double reste = 0.00;

        for (int i = 0; i < tabmoneyLimite.length; i++)
        {
            if(tabmoneyLimite[i] <= 0)
            {
                reste += 0;
            }
            else
            {
                reste += tabmoneyLimite[i] * tabprix[i];
            }
        }

        return reste - rendre >= 0;
    }


    // Méthode qui retourne s'il reste au moins 1 pièce/billet dans le tableau tabmoneyLimite à un indice c donné
    public boolean pieceDisponible(int c)
    {
        return tabmoneyLimite[c] >= 1;
    }
}