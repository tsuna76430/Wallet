package com.company;

public abstract class Decimal 
{

    public int entier;
    public int reel;

    // Getter & Setter entier
    public int getEntier() 
    {
        return entier;
    }
    
    public void setEntier(int entier) 
    {
        this.entier = entier;
    }

    // Getter & Setter reel
    public int getReel() 
    {
        return reel;
    }
    
    public void setReel(int reel) 
    {
        this.reel = reel;
    }

    // Les méthodes 
    abstract void addition(Decimal d2);
    abstract void soustraction(Decimal d2);
    abstract void setNumber(double entier);
    
    abstract double getNumber();
}
