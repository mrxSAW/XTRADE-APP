package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
                   Scanner scanner = new Scanner(System.in);

        CreptoCurrency BTC=new CreptoCurrency("Transparent","bitcoin","BTC",1000,10);
        Stock stock=new Stock("nike","golden","GD",400,10);
        TradingPlatforme.getCreptoCurrencyList().add(BTC);
        TradingPlatforme.getStockList().add(stock);

        String choix;
    do{
            System.out.println("enter votre choix  \n 1:ajouter trader \n 2:afficher les trader \n 3:afficher Assets  \n 4:acheter asset \n 5:vender Asset  \n 6:afficher les transaction  ");

            choix = scanner.nextLine();
            if (choix.equals("1")) {
                TradingPlatforme.addTrader(scanner);
            }
            else if (choix.equals("2")) {
                TradingPlatforme.afficherTrader();
            }
            else if(choix.equals("3")) {
                TradingPlatforme.afficherAsset();
            }
            else if(choix.equals("4")) {
                TradingPlatforme.achat(scanner);
            }
            else if(choix.equals("5")) {
                TradingPlatforme.vent(scanner);
            }
            else if(choix.equals("6")) {
                TradingPlatforme.afficherTransaction();
            }

        }while (!choix.equalsIgnoreCase("Q"));



    }




}