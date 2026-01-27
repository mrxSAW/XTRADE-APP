package org.example;

public class Portfolio {


   private  int stok;
   private  int BTC;
   private double restsolde;
   private  double SouldeTotal;


    public Portfolio(int stok, int BTC,double restsolde ,double souldeTotal) {
        this.stok = stok;
        this.BTC = BTC;
        this.restsolde = restsolde;
        this.SouldeTotal = souldeTotal;
    }


    public int getBTC() {
        return BTC;
    }

    public int getStok() {
        return stok;
    }

    public double getSouldeTotal() {
        return SouldeTotal;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void setBTC(int BTC) {
        this.BTC = BTC;
    }

    public void setSouldeTotal(double souldeTotal) {
        SouldeTotal = souldeTotal;
    }

    public double getRestsolde() {
        return restsolde;
    }

    public void setRestsolde(double restsolde) {
        this.restsolde = restsolde;
    }
}
