package org.example;

public class Trader extends Person {


   private Double SoldeInitial;
   private Portfolio portfolio;

   public  Trader(String name,String ID,double SoldeInitial) {
       super(name,ID);
       this.SoldeInitial = SoldeInitial;
       this.portfolio = new Portfolio(0, 0, SoldeInitial, SoldeInitial);
   }

    public  Trader(String name,String ID,double SoldeInitial,Portfolio portfolio) {
        super(name,ID);
        this.SoldeInitial = SoldeInitial;
        this.portfolio=portfolio;
   }

    public double getSoldeInitial() {
        return SoldeInitial;
    }

    public void setSoldeInitial(double soldeInitial) {
        SoldeInitial = soldeInitial;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }


    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }




}
