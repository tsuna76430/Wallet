package com.company;

public class Decimal2 extends Decimal 
{

    public Decimal2() 
    {
        this.entier = 0;
        this.reel = 0;
    }

    public Decimal2(int entier, int reel) 
    {
        this.entier = entier;
        
        if (reel >= 100) 
        {
            String stmp = "" + reel;
            stmp = stmp.substring(0, 2);
            reel = Integer.parseInt(stmp);
        }
        
        this.reel = reel;
    }

    // Methode Addition
    public void addition(Decimal d2) 
    {
        int tmp;
        
        this.setEntier(this.getEntier() + d2.getEntier());
        tmp = this.getReel() + d2.getReel();
        
        if (tmp >= 100) 
        {
            tmp = tmp - 100;
            this.setEntier(this.getEntier() + 1);
        }
        
        this.setReel(tmp);
    }

    // Methode soustraction
    public void soustraction(Decimal d2) 
    {
        int tmp, tmp2;
        
        tmp = this.entier - d2.entier;
        this.setEntier(tmp);

        tmp2 = this.reel - d2.reel;
        
        if (tmp2 < 0) 
        {
            tmp2 = tmp2 + 100;
            this.setEntier(this.getEntier() -1);
        }
        

        this.setReel(tmp2);
    }

    // Methode getNumber
    public double getNumber() 
    {
        double decimal = this.reel;

        return this.entier + decimal/100;
    }


    // Methode setNumber
    public void setNumber(double entier) 
    {
        String x = "" + entier;
        String separateur = " ";
        
        x = x.replace('.', ' ');
        
        String[] part = x.split(separateur);
        
        int a = Integer.parseInt(part[0]);
        int b = Integer.parseInt(part[1]);
        
        this.setEntier(a);
        
        if (part[1].length() == 1) 
        {
            b = b * 10;
        }
        this.setReel(b);
    }
}
