package com.company;

import java.util.*;

public class Wallet
{

    public static void main(String[] args)
    {
        // money contient le prix donner par l'utilisateur, rendu contient le prix rendu par le programme et compter contient la même chose que money mais permet de fair les calcul dans les boucle sans toucher à money
        double money, rendu, compter;
        rendu = 0;

        System.out.print("Donner un prix :");
        Scanner sc = new Scanner(System.in);

        // boucle pour vérifier que la saisie utilisateur est un double, sinon il redemande jusqu'a son obtention
        while(!sc.hasNextDouble())
        {
            System.out.println("\u001B[31m Votre nombre n'est pas nombre decimal de format ##,## \u001B[0m");
            System.out.print("Donner un nouveau prix :");
            sc.next();
        }

        money = sc.nextDouble();
        sc.close();
        compter = money;

        int[] tabmoney = new int[15];
        double[] tabprix = new double[] {500, 200, 100, 50, 20, 10, 5, 2, 1, 0.50, 0.20, 0.10, 0.05, 0.02, 0.01};

        // initialise à 0 le tableau tabmoney contenant le nombre et le type de pièces utiliser pour arriver au prix saisie par l'utilisateur
        for (int i : tabmoney)
        {
            tabmoney[i] = 0;
        }

        // boucle pour vérifier si on à rendu le prix exacte
        while (rendu != money & compter > 0.00)
        {
            // vérifie s'il reste au moins 500 euros à rendre
            if (compter - 500.00 >= 0.00)
            {
                compter = compter - 500.00;
                rendu = rendu + 500.00;
                tabmoney[0] = tabmoney[0] + 1;
            }
            // vérifie s'il reste au moins 200 euros à rendre
            else if (compter - 200.00 >= 0.00)
            {
                compter = compter -200.00;
                rendu = rendu + 200.00;
                tabmoney[1] = tabmoney[1] + 1;
            }
            // vérifie s'il reste au moins 100 euros à rendre
            else if (compter - 100.00 >= 0.00)
            {
                compter = compter -100.00;
                rendu = rendu + 100.00;
                tabmoney[2] = tabmoney[2] + 1;
            }
            // vérifie s'il reste au moins 50 euros à rendre
            else if (compter - 50.00 >= 0.00)
            {
                compter = compter -50.00;
                rendu = rendu + 50.00;
                tabmoney[3] = tabmoney[3] + 1;
            }
            // vérifie s'il reste au moins 20 euros à rendre
            else if (compter - 20.00 >= 0.00)
            {
                compter = compter -20.00;
                rendu = rendu + 20.00;
                tabmoney[4] = tabmoney[4] + 1;
            }
            // vérifie s'il reste au moins 10 euros à rendre
            else if (compter - 10.00 >= 0.00)
            {
                compter = compter -10.00;
                rendu = rendu + 10.00;
                tabmoney[5] = tabmoney[5] + 1;
            }
            // vérifie s'il reste au moins 5 euros à rendre
            else if (compter - 5.00 >= 0.00)
            {
                compter = compter -5.00;
                rendu = rendu + 5.00;
                tabmoney[6] = tabmoney[6] + 1;
            }
            // vérifie s'il reste au moins 2 euros à rendre
            else if (compter - 2.00 >= 0.00)
            {
                compter = compter -2.00;
                rendu = rendu + 2.00;
                tabmoney[7] = tabmoney[7] + 1;
            }
            // vérifie s'il reste au moins 1 euro à rendre
            else if (compter - 1.00 >= 0.00)
            {
                compter = compter -1.00;
                rendu = rendu + 1.00;
                tabmoney[8] = tabmoney[8] + 1;
            }
            // Vérifie s'il reste au moins 0,50 euro à rendre
            else if (compter - 0.50 >= 0.00)
            {
                compter = compter - 0.50;
                rendu = rendu + 0.50;
                tabmoney[9] = tabmoney[9] + 1;
            }
            // Vérifie s'il reste au moins 0,20 euro à rendre
            else if (compter - 0.20 >= 0.00)
            {
                compter = compter - 0.20;
                rendu = rendu + 0.20;
                tabmoney[10] = tabmoney[10] + 1;
            }
            // Vérifie s'il reste au moins 0,10 euro à rendre
            else if (compter - 0.10 >= 0.00)
            {
                compter = (compter - 0.10);
                rendu = rendu + 0.10;
                tabmoney[11] = tabmoney[11] + 1;
            }
            // Vérifie s'il reste au moins 0,05 euro à rendre
            else if (compter - 0.05 >= 0.00)
            {
                compter = compter - 0.05;
                rendu = rendu + 0.05;
                tabmoney[12] = tabmoney[12] + 1;
            }
            // Vérifie s'il reste au moins 0,02 euro à rendre
            else if (compter - 0.02 >= 0.00)
            {
                compter = compter - 0.02;
                rendu = rendu + 0.02;
                tabmoney[13] = tabmoney[13] + 1;
            }
            // Vérifie s'il reste au moins 0,01 euro à rendre
            else if (compter - 0.01 >= 0.00)
            {
                compter = compter - 0.01;
                rendu = rendu + 0.01;
                tabmoney[14] = tabmoney[14] + 1;
            }
            else
            {
                // Vérifie s'il reste moins 0,01 euro à rendre
                if(compter < 0.01)
                {
                    break;
                }
                else
                {
                    System.out.println("money : " + money);
                    System.out.println("rendu : " + rendu);
                    System.out.println("compter : " + compter);
                    System.out.println(" il y a une erreur !");
                }
            }

            // Arrondi à la valeur supérieur afin de minimiser les approsimations lors des calculs précédant
            rendu = Math.round(rendu*100)/100d;
            compter = Math.round(compter*100)/100d;
        }

        StringBuilder rep = new StringBuilder("\n");

        // boucle pour afficher le nombre et le type de pièces/billets utiliser
        for (int j = 0 ; j < tabmoney.length; j++)
        {
            // Pour les billets
            if (j < 7)
            {
                // S'il y a au moins 1 billet
                if(tabmoney[j] > 0)
                {
                    rep.append("\u001B[32m il y a ").append(tabmoney[j]).append(" billet(s) de ").append(tabprix[j]).append("\u001B[0m ").append("\n");
                }
            }
            // Pour les pièces
            else
            {
                // S'il y a au moins 1 pièce
                if(tabmoney[j] > 0)
                {
                    rep.append("\u001B[33m il y a ").append(tabmoney[j]).append(" pièce(s) de ").append(tabprix[j]).append("\u001B[0m").append("\n");
                }
            }
        }
        System.out.println(rep);
    }
}