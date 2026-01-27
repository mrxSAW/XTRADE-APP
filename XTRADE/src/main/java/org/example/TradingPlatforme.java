package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class TradingPlatforme {


    private static ArrayList<Trader>TraderList=new ArrayList<>();
    private static ArrayList<Stock>StockList=new ArrayList<>();
    private static ArrayList<CreptoCurrency> CreptoCurrencyList =new ArrayList<>();
    private static ArrayList<Transaction>TransactionList=new ArrayList<>();


    public static ArrayList<Trader> getTraderList() {
        return TraderList;
    }
    public static ArrayList<CreptoCurrency> getCreptoCurrencyList() {
        return CreptoCurrencyList;
    }
    public static ArrayList<Transaction> getTransactionList() {
        return TransactionList;
    }

    public static ArrayList<Stock> getStockList() {
        return StockList;
    }

    public static Trader addTrader(Scanner scanner){
       System.out.println("Enter Trader Name:");
       String name=scanner.nextLine();
       System.out.println("Enter Trader ID:");
       String ID=scanner.nextLine();
       System.out.println("Enter SoldeInitial:");
       double SoldeInitial=scanner.nextDouble();
       scanner.nextLine();

       Trader trader= new Trader(name,ID,SoldeInitial);
       TraderList.add(trader);

       System.out.println("trader ajouter avec succes  bienvenue "+trader.getName());

       return trader;
   }


public static void afficherTrader(){
        if(TraderList.isEmpty()){
            System.out.println("la list des traders est vide");
        }
    System.out.println("=============traders list ==============");
        for(int i=0;i<TraderList.size();i++){
            Trader trader=TraderList.get(i);
            System.out.println("trader : "+(i+1));
            System.out.println("name   : "+trader.getName());
            System.out.println("ID     : "+trader.getID());
            System.out.println("SoldeInitial : "+trader.getSoldeInitial());
            System.out.println("========folio===========");
            System.out.println("stok   : " +trader.getPortfolio().getStok());
            System.out.println("BTC    :  "+trader.getPortfolio().getBTC());
            System.out.println("restsolde"+trader.getPortfolio().getRestsolde());
            System.out.println("SouldeTotal : "+trader.getPortfolio().getSouldeTotal());
            System.out.println("________________________________________________");
        }
                                      }


   public static void afficherAsset(){
        if(CreptoCurrencyList.isEmpty() && StockList.isEmpty() ){
            System.out.println("la list des assets est vide");
        }

       System.out.println("=============stok list ==============");
       for(int i = 0; i< StockList.size(); i++){
           Stock asset= StockList.get(i);
           System.out.println("Asset : "+(i+1));
           System.out.println("code  : "+ asset.getCode());
           System.out.println("nom   : "+ asset.getName());
           System.out.println("unit price   : "+ asset.getUnitPrice());
           System.out.println("quantity   : "+ asset.getQuantity());
           System.out.println("societé : "+ asset.getCompanyName());
           System.out.println("________________________________________________");
       }

       System.out.println("=============Crepto currency list ==============");
       for(int i = 0; i< CreptoCurrencyList.size(); i++){
           CreptoCurrency asset1 = CreptoCurrencyList.get(i);
           System.out.println("Asset : "+(i+1));
           System.out.println("code  : "+ asset1.getCode());
           System.out.println("name   : "+ asset1.getName());
           System.out.println("unit price   : "+ asset1.getUnitPrice());
           System.out.println("name   : "+ asset1.getQuantity());
           System.out.println("blockshaine  : "+ asset1.getBlockshaine());
           System.out.println("________________________________________________");
       }

    }










}
