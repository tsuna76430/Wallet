package com.company;

import java.util.*;

public class Wallet
{
    int[] tabmoneyLimite = new int[15];
    double[] tabprix = new double[] {500, 200, 100, 50, 20, 10, 5, 2, 1, 0.50, 0.20, 0.10, 0.05, 0.02, 0.01};
    int[] tabmoney = new int[15];

    double money, rendu, compter;

    public static void main(String[] args)
    {
        // création d'un objet Wallet afin d'appeller des variables et méthodes non static dans le main
        Wallet w = new Wallet();

        // money contient le prix donner par l'utilisateur, rendu contient le prix rendu par le programme et compter contient la même chose que money mais permet de fair les calculs dans les boucles sans toucher à money
        w.rendu = 0.00;

        System.out.print("Donner un prix :");
        Scanner sc = new Scanner(System.in);

        // boucle pour vérifier que la saisie utilisateur est un double, sinon il redemande jusqu'a son obtention
        while(!sc.hasNextDouble())
        {
            System.out.println("\u001B[31m Votre nombre n'est pas nombre decimal de format ##,## \u001B[0m");
            System.out.print("Donner un nouveau prix :");
            sc.next();
        }

        w.money = sc.nextDouble();
        w.compter = w.money;

        // remplissage du tableau tabmoneyLimite
        w.iniTabMoneyLimite();

        // initialise à 0 le tableau tabmoney contenant le nombre et le type de pièces utiliser pour arriver au prix saisie par l'utilisateur
        for (int i : w.tabmoney)
        {
            w.tabmoney[i] = 0;
        }

        // boucle pour vérifier si on à rendu le prix exacte
        while (w.rendu != w.money & w.compter > 0.00)
        {
            // vérifie s'il reste au moins 500 euros à rendre
            if (w.compter - 500.00 >= 0.00 & w.pieceDisponible(0))
            {
                w.calcul(0);
            }
            // vérifie s'il reste au moins 200 euros à rendre
            else if (w.compter - 200.00 >= 0.00 & w.pieceDisponible(1))
            {
                w.calcul(1);
            }
            // vérifie s'il reste au moins 100 euros à rendre
            else if (w.compter - 100.00 >= 0.00 & w.pieceDisponible(2))
            {
                w.calcul(2);
            }
            // vérifie s'il reste au moins 50 euros à rendre
            else if (w.compter - 50.00 >= 0.00 & w.pieceDisponible(3))
            {
                w.calcul(3);
            }
            // vérifie s'il reste au moins 20 euros à rendre
            else if (w.compter - 20.00 >= 0.00 & w.pieceDisponible(4))
            {
                w.calcul(4);
            }
            // vérifie s'il reste au moins 10 euros à rendre
            else if (w.compter - 10.00 >= 0.00 & w.pieceDisponible(5))
            {
                w.calcul(5);
            }
            // vérifie s'il reste au moins 5 euros à rendre
            else if (w.compter - 5.00 >= 0.00 & w.pieceDisponible(6))
            {
                w.calcul(6);
            }
            // vérifie s'il reste au moins 2 euros à rendre
            else if (w.compter - 2.00 >= 0.00 & w.pieceDisponible(7))
            {
                w.calcul(7);
            }
            // vérifie s'il reste au moins 1 euro à rendre
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
                // Vérifie s'il reste moins 0,01 euro à rendre
                if(w.compter < 0.01)
                {
                    break;
                }
                else if(!w.resteMoney(w.compter))
                {
                    System.out.println("\n \u001B[31m Veuillez nous excusez, il n'y a plus assez de pièces/billets pour atteindre le prix \u001B[0m");
                    break;
                }
                else
                {
                    System.out.println("money : " + w.money);
                    System.out.println("rendu : " + w.rendu);
                    System.out.println("compter : " + w.compter);
                    System.out.println(" il y a une erreur !");
                }
            }

            // Arrondi à la valeur supérieur afin de minimiser les approximations lors des calculs précédant
            w.rendu = Math.round(w.rendu*100)/100d;
            w.compter = Math.round(w.compter*100)/100d;
        }

        StringBuilder rep = new StringBuilder("\n rendu : \n");

        // boucle pour afficher le nombre et le type de pièces/billets utiliser
        for (int j = 0 ; j < w.tabmoney.length; j++)
        {
            // Pour les billets
            if (j < 7)
            {
                // S'il y a au moins 1 billet
                if(w.tabmoney[j] > 0)
                {
                    rep.append("\u001B[32m il y a ").append(w.tabmoney[j]).append(" billet(s) de ").append(w.tabprix[j]).append("\u001B[0m ").append("\n");
                }
            }
            // Pour les pièces
            else
            {
                // S'il y a au moins 1 pièce
                if(w.tabmoney[j] > 0)
                {
                    rep.append("\u001B[33m il y a ").append(w.tabmoney[j]).append(" pièce(s) de ").append(w.tabprix[j]).append("\u001B[0m").append("\n");
                }
            }
        }
        System.out.println(rep);
        sc.close();
    }

    public void iniTabMoneyLimite()
    {
        Scanner sc = new Scanner(System.in);

        for (int l = 0; l < tabmoney.length; l++)
        {
            if (l < 7)
            {
                System.out.print("Combien de billet(s) de " + tabprix[l] + " : ");
            }
            else
            {
                System.out.print("Combien de pièce(s) de " + tabprix[l] + " : ");
            }
            tabmoneyLimite[l] = sc.nextInt();
        }
    }

    public void calcul(int i)
    {
        compter = compter - tabprix[i];
        rendu = rendu + tabprix[i];
        tabmoney[i] = tabmoney[i] + 1;
        tabmoneyLimite[i] = tabmoneyLimite[i] - 1;
    }

    public boolean resteMoney(double rendre)
    {
        double reste = 0.00;

        for (int i : tabmoneyLimite)
        {
            reste += tabmoneyLimite[i] * tabprix[i];
        }

        return reste - rendre >= 0;
    }

    public boolean pieceDisponible(int c)
    {
        return tabmoneyLimite[c] >= 1;
    }
}