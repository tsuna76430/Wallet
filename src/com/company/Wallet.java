package com.company;

import java.util.*;

public class Wallet
{

    public static void main(String[] args)
    {
        double money, rendu, compter;
        rendu = 0;

        System.out.print("donner un prix :");
        Scanner sc = new Scanner(System.in);

        while( ! sc.hasNextDouble() )
        {
            System.out.println("\u001B[31m Votre nombre n'est pas nombre decimal de format ##,## \u001B[0m");
            sc.next();
        }

        money = sc.nextDouble();

        compter = money;

        int[] tabmoney = new int[15];
        double[] tabprix = new double[] {500, 200, 100, 50, 20, 10, 5, 2, 1, 0.50, 0.20, 0.10, 0.05, 0.02, 0.01};

        sc.close();

        for (int i : tabmoney)
        {
            tabmoney[i] = 0;
        }

        while (rendu != money & compter > 0.00)
        {
            if (compter - 500.00 >= 0.00)
            {
                compter = compter - 500.00;
                rendu = rendu + 500.00;
                tabmoney[0] = tabmoney[0] + 1;
            }
            else if (compter - 200.00 >= 0.00)
            {
                compter = compter -200.00;
                rendu = rendu + 200.00;
                tabmoney[1] = tabmoney[1] + 1;
                //System.out.println("nombre billet de 200 : " +tabmoney[1]);
            }
            else if (compter - 100.00 >= 0.00)
            {
                compter = compter -100.00;
                rendu = rendu + 100.00;
                tabmoney[2] = tabmoney[2] + 1;
            }
            else if (compter - 50.00 >= 0.00)
            {
                compter = compter -50.00;
                rendu = rendu + 50.00;
                tabmoney[3] = tabmoney[3] + 1;
            }
            else if (compter - 20.00 >= 0.00)
            {
                compter = compter -20.00;
                rendu = rendu + 20.00;
                tabmoney[4] = tabmoney[4] + 1;
            }
            else if (compter - 10.00 >= 0.00)
            {
                compter = compter -10.00;
                rendu = rendu + 10.00;
                tabmoney[5] = tabmoney[5] + 1;
            }
            else if (compter - 5.00 >= 0.00)
            {
                compter = compter -5.00;
                rendu = rendu + 5.00;
                tabmoney[6] = tabmoney[6] + 1;
            }
            else if (compter - 2.00 >= 0.00)
            {
                compter = compter -2.00;
                rendu = rendu + 2.00;
                tabmoney[7] = tabmoney[7] + 1;
            }
            else if (compter - 1.00 >= 0.00)
            {
                compter = compter -1.00;
                rendu = rendu + 1.00;
                tabmoney[8] = tabmoney[8] + 1;
            }
            else if (compter - 0.50 >= 0.00)
            {
                compter = compter - 0.50;
                rendu = rendu + 0.50;
                tabmoney[9] = tabmoney[9] + 1;
            }
            else if (compter - 0.20 >= 0.00)
            {
                compter = compter - 0.20;
                rendu = rendu + 0.20;
                tabmoney[10] = tabmoney[10] + 1;
            }
            else if (compter - 0.10 >= 0.00)
            {
                compter = (compter - 0.10);
                rendu = rendu + 0.10;
                tabmoney[11] = tabmoney[11] + 1;
            }
            else if (compter - 0.05 >= 0.00)
            {
                compter = compter - 0.05;
                rendu = rendu + 0.05;
                tabmoney[12] = tabmoney[12] + 1;
            }
            else if (compter - 0.02 >= 0.00)
            {
                compter = compter - 0.02;
                rendu = rendu + 0.02;
                tabmoney[13] = tabmoney[13] + 1;
            }
            else if (compter - 0.01 >= 0.00)
            {
                compter = compter - 0.01;
                rendu = rendu + 0.01;
                tabmoney[14] = tabmoney[14] + 1;
            }
            else
            {
                if(compter < 0.01)
                {
                    break;
                }
                else
                {
                    System.out.println(money);
                    System.out.println("rendu : " + rendu);
                    System.out.println("compter : " + compter);
                    System.out.println(" il y a une erreur !");
                }
            }

            rendu = Math.round(rendu*100)/100d;
            compter = Math.round(compter*100)/100d;
        }

        StringBuilder rep = new StringBuilder("\n");

        for (int j = 0 ; j < tabmoney.length; j++)
        {
            if (j < 7)
            {
                if(tabmoney[j] > 0)
                {
                    rep.append("\u001B[32m il y a ").append(tabmoney[j]).append(" billet(s) de ").append(tabprix[j]).append("\u001B[0m ").append("\n");
                }
            }
            else
            {
                if(tabmoney[j] > 0)
                {
                    rep.append("\u001B[33m il y a ").append(tabmoney[j]).append(" pièce(s) de ").append(tabprix[j]).append("\u001B[0m").append("\n");
                }
            }
        }
        System.out.println(rep);
    }
}