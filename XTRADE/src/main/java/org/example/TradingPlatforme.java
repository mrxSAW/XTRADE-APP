package org.example;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            System.out.println("restsolde : "+trader.getPortfolio().getRestsolde());
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




    public static void achat(Scanner scanner){
        System.out.println("Asset desponible");
        afficherAsset();
        System.out.println("entrer le code de l'Asset a acheter  ");
        String codesearch=scanner.nextLine();
        if(codesearch.equals("BTC")){
            Trader trader= getTraderList().getFirst();
          CreptoCurrency  btc=getCreptoCurrencyList().getFirst();
          Stock stok=getStockList().getFirst();
            System.out.println("carrency : "+btc.getName());
            System.out.println("code  : "+btc.getCode());
            System.out.println("quantity   : "+btc.getQuantity());
            System.out.println("prix de l'unité: " + btc.getUnitPrice());
            System.out.println("entrer la quantity a acheter de : " + btc.getCode() );
            int Qacheter=scanner.nextInt();
            scanner.nextLine();
            if(Qacheter<btc.getQuantity() ||Qacheter==btc.getQuantity() ){
                double prixTotal= btc.getUnitPrice()*Qacheter;
                if(prixTotal<=trader.getPortfolio().getRestsolde()){
                   double restsolde=trader.getPortfolio().getRestsolde()-prixTotal;
                    trader.getPortfolio().setRestsolde(restsolde);
                    int soldBtc=trader.getPortfolio().getBTC();
                    trader.getPortfolio().setBTC(soldBtc+Qacheter);
                    int QexistantBtc=btc.getQuantity();
                    btc.setQuantity(QexistantBtc-Qacheter);
                    trader.getPortfolio().setSouldeTotal((btc.getUnitPrice()*trader.getPortfolio().getBTC())+(stok.getUnitPrice()*(trader.getPortfolio().getStok()))+trader.getPortfolio().getRestsolde());
                    Transaction transaction=new Transaction(" achat "," BTC ",Qacheter,btc.getUnitPrice());
                    getTransactionList().add(transaction);
                    System.out.println("vous avez acheter avec succes  "+ Qacheter+ " BTC  "+ " votre solde restant est : "+ trader.getPortfolio().getRestsolde());
                }else {
                    System.out.println("votre solde est insufusant");
                }

            }else {
                System.out.println("la quantity demander non disponible");
            }
        }



        else if(codesearch.equals("GD")){
            Trader trader= getTraderList().getFirst();
            Stock  stock=getStockList().getFirst();
            CreptoCurrency btc=getCreptoCurrencyList().getFirst();
            System.out.println("stock : "+stock.getName());
            System.out.println("code  : "+stock.getCode());
            System.out.println("quantity   : "+ stock.getQuantity());
            System.out.println("prix de l'unité  : " + stock.getUnitPrice());
            System.out.println("entrer la quantity a acheter de : " + stock.getCode() );
            int Qacheter=scanner.nextInt();
            scanner.nextLine();
            if(Qacheter<stock.getQuantity() ||Qacheter==stock.getQuantity() ){
                double prixTotal= stock.getUnitPrice()*Qacheter;
                if(prixTotal<=trader.getPortfolio().getRestsolde()){
                    double restsolde=trader.getPortfolio().getRestsolde()-prixTotal;
                    trader.getPortfolio().setRestsolde(restsolde);
                    int soldStock=trader.getPortfolio().getStok();
                    trader.getPortfolio().setStok(soldStock+Qacheter);
                    int QexistantStock=stock.getQuantity();
                    stock.setQuantity(QexistantStock-Qacheter);
                    trader.getPortfolio().setSouldeTotal((btc.getUnitPrice()*trader.getPortfolio().getBTC())+(stock.getUnitPrice()*(trader.getPortfolio().getStok()))+trader.getPortfolio().getRestsolde());
                    Transaction transaction=new Transaction("achat ","GD ",Qacheter,stock.getUnitPrice());
                    getTransactionList().add(transaction);
                    System.out.println("vous avez acheter avec succes  "+ Qacheter+ "  DG  "+ "votre solde restant est : "+ trader.getPortfolio().getRestsolde());
                }else {
                    System.out.println("votre solde est insufusant");
                }

            }else {
                System.out.println("la quantity demander non disponible");
            }
        }else {
            System.out.println("choix d'Asset invalide");
        }

    }









    public static void vent(Scanner scanner){
        System.out.println("Asset que vous posseder");
        System.out.println("stock : "+getTraderList().getFirst().getPortfolio().getStok() +" GD");
        System.out.println("BTC   :  "+getTraderList().getFirst().getPortfolio().getBTC() + " BTC");
        System.out.println("entrer le code de l'Asset a vendre  ");
        String codesearch=scanner.nextLine();
        if(codesearch.equals("BTC")){
            Trader trader= getTraderList().getFirst();
            CreptoCurrency  btc=getCreptoCurrencyList().getFirst();
            Stock  stock=getStockList().getFirst();
            System.out.println("carrency : "+btc.getName());
            System.out.println("code  : "+btc.getCode());
            System.out.println("prix de l'unité: " + btc.getUnitPrice());
            System.out.println("entrer la quantity a vender de : " + btc.getCode() );
            int Qavender =scanner.nextInt();
            scanner.nextLine();
            if(Qavender <trader.getPortfolio().getBTC() || Qavender ==trader.getPortfolio().getBTC() ){
                double prixTotal= btc.getUnitPrice()* Qavender;

                    double restsolde=trader.getPortfolio().getRestsolde()+prixTotal;
                    trader.getPortfolio().setRestsolde(restsolde);
                    int soldBtc=trader.getPortfolio().getBTC();
                    trader.getPortfolio().setBTC(soldBtc - Qavender);
                    int QexistantBtc=btc.getQuantity();
                    btc.setQuantity(QexistantBtc + Qavender);
                trader.getPortfolio().setSouldeTotal((btc.getUnitPrice()*trader.getPortfolio().getBTC())+(stock.getUnitPrice()*(trader.getPortfolio().getStok()))+trader.getPortfolio().getRestsolde());

                Transaction transaction=new Transaction("vent "," TBC ",Qavender,btc.getUnitPrice());
                getTransactionList().add(transaction);
                    System.out.println("vous avez vendu avec succes  "+ Qavender + " BTC  "+ " votre solde restant est : "+ trader.getPortfolio().getRestsolde());


            }else {
                System.out.println("la quantity selectionner  non disponible sur votre portfieul");
            }
        }



        else if(codesearch.equals("GD")){
            Trader trader= getTraderList().getFirst();
            Stock  stock=getStockList().getFirst();
            CreptoCurrency btc=getCreptoCurrencyList().getFirst();
            System.out.println("stock : "+stock.getName());
            System.out.println("code  : "+stock.getCode());
            System.out.println("prix de l'unité: " + stock.getUnitPrice());
            System.out.println("entrer la quantity a vender de : " + stock.getCode() );
            int Qavender =scanner.nextInt();
            scanner.nextLine();
            if(Qavender <trader.getPortfolio().getStok() || Qavender ==trader.getPortfolio().getStok() ){
                double prixTotal= stock.getUnitPrice()* Qavender;

                    double soldeEexistant=trader.getPortfolio().getRestsolde();
                    trader.getPortfolio().setRestsolde(soldeEexistant+prixTotal);
                    int soldStock=trader.getPortfolio().getStok();
                    trader.getPortfolio().setStok(soldStock - Qavender);
                    int QexistantStock=stock.getQuantity();
                    stock.setQuantity(QexistantStock + Qavender);
                trader.getPortfolio().setSouldeTotal((btc.getUnitPrice()*trader.getPortfolio().getBTC())+(stock.getUnitPrice()*(trader.getPortfolio().getStok()))+trader.getPortfolio().getRestsolde());
                Transaction transaction=new Transaction("vent "," GD ",Qavender,stock.getUnitPrice());
                getTransactionList().add(transaction);

                    System.out.println("vous avez vendu avec succes  "+ Qavender + "  DG  "+ "votre solde restant est : "+ trader.getPortfolio().getRestsolde());


            }else {
                System.out.println("la quantity demander non disponible sur votre portfieul");
            }
        }else {
            System.out.println("choix d'Asset invalide");
        }

    }





   public static void afficherTransaction(){
        if (TransactionList.isEmpty()){
            System.out.println("la liste des transactions est vide");
        }

       System.out.println("============ la list des transaction=============");
       System.out.println("  type   |  Asset   | quantity |     price     | date ");
        for (int i=0;i< TransactionList.size();i++){
            Transaction trans=TransactionList.get(i);
            System.out.println(trans.getType() +"     "+trans.getAsset()+"         "+trans.getQuantity()+"           "+trans.getPrice()+"            "+trans.getFormatedDate());


        }
   }






     public static void exporterTransaction(){
        if (TransactionList.isEmpty()){
            System.out.println("la liste des transactions est vide");
            return;
        }

        String date= java.time.LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));
        String nomFichier ="C:\\Users\\arkka\\Downloads " + date + ".csv";

        final String SEPARATOR = ";";
         DecimalFormat df = new DecimalFormat("#0.00");
         df.setDecimalSeparatorAlwaysShown(true);

         try (FileWriter writer = new FileWriter(nomFichier)){
             // type   |  Asset   | quantity |     price     | date
             writer.append(" type " + SEPARATOR + "Asset" + SEPARATOR +
                            "quantity"+SEPARATOR +" price " + SEPARATOR +
                            " totale price" + SEPARATOR + "date \n");

           int totalTransaction=0;
           for (Transaction transaction:TransactionList){
             String line=String.join(SEPARATOR, transaction.getType(),transaction.getAsset(),
                                      String.valueOf(transaction.getQuantity()),
                                       df.format(transaction.getPrice()),
                                        df.format(transaction.getPrice()*transaction.getQuantity()),
                                       transaction.getFormatedDate())  + "\n";

             writer.append(line);


             totalTransaction++;

                                                }


            writer.append("Total Transactions: " + totalTransaction + "\n");

             System.out.println("exporter transaction successful");
             System.out.println("fichier cree" + nomFichier);
             System.out.println("transaction exporter " + totalTransaction);
         }catch (Exception e) {
             System.err.println("Erreur lors de l'export: " + e.getMessage());
             e.printStackTrace();
         }
     }







    public static  void changerPriceAsset(Scanner scanner){
        CreptoCurrency BTC=getCreptoCurrencyList().getFirst();
        Stock stock=getStockList().getFirst();
        afficherAsset();
        System.out.println("entrer le code de Asset voulu pour changer le prix : ");
        String codeAsset=scanner.nextLine();

        if(codeAsset.equals(BTC.getCode())){
            System.out.println("code Asset :"+BTC.getCode());
            System.out.println("asset price :"+BTC.getUnitPrice());
            System.out.println("entrer la nouvelle valeur du price :");
            double NewPrice=scanner.nextDouble();
            scanner.nextLine();
            if (NewPrice>0){
                BTC.setUnitPrice(NewPrice);
                System.out.println("price modifier avec succees!  nouveau BTC price : " + BTC.getUnitPrice());
            }else {
                System.out.println("pas de pix negatif ");
            }
        }

         else if(codeAsset.equals(stock.getCode())){
            System.out.println("code Asset :"+stock.getCode());
            System.out.println("asset price :"+stock.getUnitPrice());
            System.out.println("entrer la nouvelle valeur du price :");
            double NewPrice=scanner.nextDouble();
            scanner.nextLine();
            if (NewPrice>0){
                stock.setUnitPrice(NewPrice);
                System.out.println("price modifier avec succees!  nouveau stock price : " + stock.getUnitPrice());
            }else {
                System.out.println("pas de pix negatif ");
            }
        }
         else {
            System.out.println("code entrer invalide");

        }




    }








}
