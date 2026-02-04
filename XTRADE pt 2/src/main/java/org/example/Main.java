package org.example;

import java.util.*;

public class Main {

    public static void main(String[] args) {
                   Scanner scanner = new Scanner(System.in);

        CreptoCurrency BTC=new CreptoCurrency("Transparent","bitcoin","BTC",1000,10);
        Stock stock=new Stock("nike","golden","GD",400,10);
        Trader trader1=new Trader("ali","V",2000);
        TradingPlatforme.getTraderList().add(trader1);
        TradingPlatforme.getCreptoCurrencyList().add(BTC);
        TradingPlatforme.getStockList().add(stock);

        String choix;
    do{

            System.out.println(  "enter votre choix  \n 1:ajouter trader \n 2:afficher les trader \n 3:afficher Assets " +
                                 " \n 4:acheter asset \n 5:vender Asset  \n 6:afficher les transaction  " +" \n 7:changer Asset price " +
                                 " \n 8:afficher les transaction d'un trader"+" \n 9:trier transaction "+"\n A:analyse Des Transactions  "+" \n B:Analyser Performance Trader"+
                                    "\n C:Analyse Globale du Marché Simulé  "  + "\n E:exporter les transaction en csv ");



            choix = scanner.nextLine();
            if (choix.equals("1")) {
                TradingPlatforme.addTrader(scanner);
            } else if (choix.equals("2")) {
                TradingPlatforme.afficherTrader();
            } else if (choix.equals("3")) {
                TradingPlatforme.afficherAsset();
            } else if (choix.equals("4")) {
                TradingPlatforme.achat(scanner);
            } else if (choix.equals("5")) {
                TradingPlatforme.vent(scanner);
            } else if (choix.equals("6")) {
                TradingPlatforme.afficherTransaction();
            } else if (choix.equals("7")) {
                TradingPlatforme.changerPriceAsset(scanner);
            }else if (choix.equals("8")) {
              TradingPlatforme.afficherTransactionsTrader(scanner);
            }else if(choix.equals("9")){
                TradingPlatforme.trierTrensaction(scanner);
            }else if (choix.equalsIgnoreCase("E")) {
                TradingPlatforme.exporterTransaction();
            }else if(choix.equalsIgnoreCase("A")) {
                TradingPlatforme.analyseDesTransactions(scanner);
            }else if(choix.equalsIgnoreCase("B")) {
                TradingPlatforme.AnalysePerformanceTrader(scanner);
            }else if(choix.equalsIgnoreCase("C")) {
                TradingPlatforme.AnalyseGlobaleMarcheSimule(scanner);
            }
            else {
                System.out.println("choix invalide");
            }


        try {
            Trader trader=TradingPlatforme.getTraderList().getFirst();
            trader.getPortfolio().setSouldeTotal((BTC.getUnitPrice()*trader.getPortfolio().getBTC())+(stock.getUnitPrice()*(trader.getPortfolio().getStok()))+trader.getPortfolio().getRestsolde());
        } catch (Exception e) {
            System.out.println("Aucun trader disponible pour calculer le solde total.");
        }


    }while (!choix.equalsIgnoreCase("Q"));



    }




}



