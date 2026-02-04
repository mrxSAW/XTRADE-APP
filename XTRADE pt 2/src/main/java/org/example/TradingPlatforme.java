package org.example;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Map.*;


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
        try {
            String name;
        do {
            System.out.println("Enter Trader Name:");
            name = scanner.nextLine();
            if (name == null || name.trim().isEmpty()) {
                System.out.println("  le nom ne pas etre vide ");
            }
            else {
                break;
            }
        }while (true);
       System.out.println("Enter Trader ID:");
       String ID;

       do {
           ID = scanner.nextLine();
           if (ID == null || ID.trim().isEmpty()) {
               System.out.println("  l'ID ne pas etre vide ");
           }else  {
               break;
           }
       }while (true);

       for(Trader trader:TraderList){
           if(ID.equals(trader.getID())){
               throw new IllegalArgumentException("un trader avec cett Id existe deja ");
           }
       }

       System.out.println("Enter SoldeInitial:");
        double SoldeInitial;
       do {
           try {

            SoldeInitial=scanner.nextDouble();
           scanner.nextLine();
           if (SoldeInitial>0) {
              break;
           }else {
               System.out.println("entrer un double supperrieur de 0");
           }

           }catch (InputMismatchException e){
               System.err .println("erreur entrer un nombre valide");
               scanner.nextLine();
           }
       }while (true) ;


       Trader trader= new Trader(name,ID,SoldeInitial);
       TraderList.add(trader);

       System.out.println("trader ajouter avec succes  bienvenue "+trader.getName());

       return trader;
        }catch (IllegalArgumentException e){
            System.err.println("erreur de validation:"+e.getMessage());
            return null;
        }catch (Exception e){
            System.err.println("erreur innattendu :"+e.getMessage());
            return null;
        }
   }


public static void afficherTrader(){
        if(TraderList.isEmpty()){
            System.out.println("la list des traders est vide  \n ajouter un trader  ");
            TradingPlatforme.addTrader(new Scanner(System.in));
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
        String codesearch;
        do {
            System.out.println("entrer le code de l'Asset a acheter (BTC/GD): ");
            codesearch = scanner.nextLine().trim().toUpperCase();
            if (!codesearch.isEmpty()){break;} else {
            System.out.println("le code ne doit pas etre vide");}
        } while (true && (!codesearch.equals("BTC") || !codesearch.equals("GD")));

        if(codesearch.equals("BTC")){
            System.out.println("entrer votre ID");
            String idTrader=scanner.nextLine();
            Trader  traderfind=null;
            for(Trader trader:TraderList){
                if(trader.getID().equals(idTrader)){
                   traderfind=trader;
                   break;
                }else {
                    System.out.println("trader not fond ");
                }
            }
            if(traderfind!=null){
                CreptoCurrency btc = getCreptoCurrencyList().getFirst();
                Stock stok = getStockList().getFirst();
                System.out.println("carrency : " + btc.getName());
                System.out.println("code  : " + btc.getCode());
                System.out.println("quantity   : " + btc.getQuantity());
                System.out.println("prix de l'unité: " + btc.getUnitPrice());
                System.out.println("entrer la quantity a acheter de : " + btc.getCode());
                int Qacheter;
                do {

                    Qacheter = scanner.nextInt();
                    scanner.nextLine();
                    if (Qacheter > 0) {

                        break;
                    } else {
                        System.out.println("la quantity ne peut pas etre vide ou null");
                    }

                } while (true);
                if (Qacheter < btc.getQuantity() || Qacheter == btc.getQuantity()) {
                    double prixTotal = btc.getUnitPrice() * Qacheter;
                    if (prixTotal <= traderfind.getPortfolio().getRestsolde()) {
                        double restsolde = traderfind.getPortfolio().getRestsolde() - prixTotal;
                        traderfind.getPortfolio().setRestsolde(restsolde);
                        int soldBtc = traderfind.getPortfolio().getBTC();
                        traderfind.getPortfolio().setBTC(soldBtc + Qacheter);
                        int QexistantBtc = btc.getQuantity();
                        btc.setQuantity(QexistantBtc - Qacheter);
                        traderfind.getPortfolio().setSouldeTotal((btc.getUnitPrice() * traderfind.getPortfolio().getBTC()) + (stok.getUnitPrice() * (traderfind.getPortfolio().getStok())) + traderfind.getPortfolio().getRestsolde());
                        Transaction transaction = new Transaction("achat",traderfind.getID(),"BTC", Qacheter, btc.getUnitPrice());
                        getTransactionList().add(transaction);

                        System.out.println("vous avez acheter avec succes  " + Qacheter + " BTC  " + " votre solde restant est : " + traderfind.getPortfolio().getRestsolde());
                    } else {
                        System.out.println("votre solde est insufusant");
                    }

                } else {
                    System.out.println("la quantity demander non disponible");
                }
            }
        }



        else if(codesearch.equals("GD")){
            System.out.println("entrer votre ID");
            String idTrader=scanner.nextLine();
            Trader  traderfind=null;
            for(Trader trader:TraderList){
                if(trader.getID().equals(idTrader)){
                    traderfind=trader;
                    break;
                }else {
                    System.out.println("trader not fond ");
                }
            }


            Stock  stock=getStockList().getFirst();
            CreptoCurrency btc=getCreptoCurrencyList().getFirst();
            System.out.println("stock : "+stock.getName());
            System.out.println("code  : "+stock.getCode());
            System.out.println("quantity   : "+ stock.getQuantity());
            System.out.println("prix de l'unité  : " + stock.getUnitPrice());
            System.out.println("entrer la quantity a acheter de : " + stock.getCode() );
            int Qacheter;
            do {
                Qacheter = scanner.nextInt();
                scanner.nextLine();
                if(Qacheter>0){
                    break;
                }else {
                    System.out.println("la quantity ne peut pas etre vide ou null");
                }
            }while (true);
            if(Qacheter<stock.getQuantity() ||Qacheter==stock.getQuantity() ){
                double prixTotal= stock.getUnitPrice()*Qacheter;
                if(prixTotal<=traderfind.getPortfolio().getRestsolde()){
                    double restsolde=traderfind.getPortfolio().getRestsolde()-prixTotal;
                    traderfind.getPortfolio().setRestsolde(restsolde);
                    int soldStock=traderfind.getPortfolio().getStok();
                    traderfind.getPortfolio().setStok(soldStock+Qacheter);
                    int QexistantStock=stock.getQuantity();
                    stock.setQuantity(QexistantStock-Qacheter);
                    traderfind.getPortfolio().setSouldeTotal((btc.getUnitPrice()*traderfind.getPortfolio().getBTC())+(stock.getUnitPrice()*(traderfind.getPortfolio().getStok()))+traderfind.getPortfolio().getRestsolde());
                    Transaction transaction=new Transaction("achat",traderfind.getID(),"GD",Qacheter,stock.getUnitPrice());
                    getTransactionList().add(transaction);

                    System.out.println("vous avez acheter avec succes  "+ Qacheter+ "  DG  "+ "votre solde restant est : "+ traderfind.getPortfolio().getRestsolde());
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
        String codesearch;
        do {
            System.out.println("entrer le code de l'Asset a vender (BTC/GD): ");
            codesearch = scanner.nextLine().trim().toUpperCase();
            if (!codesearch.isEmpty()){break;} else {
                System.out.println("le code ne doit pas etre vide");}
        } while (true && (!codesearch.equals("BTC") || !codesearch.equals("GD")));
        if(codesearch.equals("BTC")){
            System.out.println("entrer votre ID");
            String idTrader=scanner.nextLine();
            Trader  traderfind=null;
            for(Trader trader:TraderList){
                if(trader.getID().equals(idTrader)){
                    traderfind=trader;
                    break;
                }else {
                    System.out.println("trader not fond ");
                }
            }
            CreptoCurrency  btc=getCreptoCurrencyList().getFirst();
            Stock  stock=getStockList().getFirst();
            System.out.println("carrency : "+btc.getName());
            System.out.println("code  : "+btc.getCode());
            System.out.println("prix de l'unité: " + btc.getUnitPrice());
            System.out.println("entrer la quantity a vender de : " + btc.getCode() );
            int Qavender ;
            do {
                Qavender = scanner.nextInt();
                scanner.nextLine();
                if (Qavender>0){
                    break;
                }else {
                    System.out.println("la quantity ne peut pas etre vide ");
                }
            }while (true);
            if(Qavender <traderfind.getPortfolio().getBTC() || Qavender ==traderfind.getPortfolio().getBTC() ){
                double prixTotal= btc.getUnitPrice()* Qavender;

                    double restsolde=traderfind.getPortfolio().getRestsolde()+prixTotal;
                    traderfind.getPortfolio().setRestsolde(restsolde);
                    int soldBtc=traderfind.getPortfolio().getBTC();
                    traderfind.getPortfolio().setBTC(soldBtc - Qavender);
                    int QexistantBtc=btc.getQuantity();
                    btc.setQuantity(QexistantBtc + Qavender);
                traderfind.getPortfolio().setSouldeTotal((btc.getUnitPrice()*traderfind.getPortfolio().getBTC())+(stock.getUnitPrice()*(traderfind.getPortfolio().getStok()))+traderfind.getPortfolio().getRestsolde());

                Transaction transaction=new Transaction("vent",traderfind.getID(),"BTC",Qavender,btc.getUnitPrice());
                getTransactionList().add(transaction);
                    System.out.println("vous avez vendu avec succes  "+ Qavender + " BTC  "+ " votre solde restant est : "+ traderfind.getPortfolio().getRestsolde());


            }else {
                System.out.println("la quantity selectionner  non disponible sur votre portfieul");
            }
        }



        else if(codesearch.equals("GD")){
            System.out.println("entrer votre ID");
            String idTrader=scanner.nextLine();
            Trader  traderfind=null;
            for(Trader trader:TraderList){
                if(trader.getID().equals(idTrader)){
                    traderfind=trader;
                    break;
                }else {
                    System.out.println("trader not fond ");
                }
            }
            Stock  stock=getStockList().getFirst();
            CreptoCurrency btc=getCreptoCurrencyList().getFirst();
            System.out.println("stock : "+stock.getName());
            System.out.println("code  : "+stock.getCode());
            System.out.println("prix de l'unité: " + stock.getUnitPrice());
            System.out.println("entrer la quantity a vender de : " + stock.getCode() );
            int Qavender;

            do {
                Qavender = scanner.nextInt();
                scanner.nextLine();
                if (Qavender>0){
                    break;
                }else {
                    System.out.println("la quantity ne peut pas etre vide ");
                }
            }while (true);
            if(Qavender <traderfind.getPortfolio().getStok() || Qavender ==traderfind.getPortfolio().getStok() ){
                double prixTotal= stock.getUnitPrice()* Qavender;

                    double soldeEexistant=traderfind.getPortfolio().getRestsolde();
                    traderfind.getPortfolio().setRestsolde(soldeEexistant+prixTotal);
                    int soldStock=traderfind.getPortfolio().getStok();
                    traderfind.getPortfolio().setStok(soldStock - Qavender);
                    int QexistantStock=stock.getQuantity();
                    stock.setQuantity(QexistantStock + Qavender);
                traderfind.getPortfolio().setSouldeTotal((btc.getUnitPrice()*traderfind.getPortfolio().getBTC())+(stock.getUnitPrice()*(traderfind.getPortfolio().getStok()))+traderfind.getPortfolio().getRestsolde());
                Transaction transaction=new Transaction("vent",traderfind.getID(),"GD",Qavender,stock.getUnitPrice());
                getTransactionList().add(transaction);

                    System.out.println("vous avez vendu avec succes  "+ Qavender + "  DG  "+ "votre solde restant est : "+ traderfind.getPortfolio().getRestsolde());


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
       System.out.println("   type    | Trader ID |   Asset   |  quantity |   price    |      Date                   ");

       for (Transaction trans : TransactionList) {
           StringBuilder sb = new StringBuilder();
           sb.append("   ").append(trans.getType()).append("   ").append("    ").append(trans.getID()).append("     ").append("    ").append(trans.getAsset()).append("    ").append("    ").append(trans.getQuantity()).append("    ").append("         ").append(trans.getPrice()).append("   ").append("      ").append(trans.getFormatedDate());

           System.out.println(sb.toString());

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
        String codeAsset;

        do {
            codeAsset = scanner.nextLine();
            if(!codeAsset.isEmpty()) {
                break;
            }else {
                System.out.println("code asset ne peut pas etre vide");
            }
        }while (true  && (!codeAsset.equals("BTC") || !codeAsset.equals("GD")));
        if(codeAsset.equals(BTC.getCode())){
            System.out.println("code Asset :"+BTC.getCode());
            System.out.println("asset price :"+BTC.getUnitPrice());
            System.out.println("entrer la nouvelle valeur du price :");

            double NewPrice;

           do {
                NewPrice = scanner.nextDouble();
                scanner.nextLine();
                if (NewPrice>0){
                    break;
                }else {
                    System.out.println("price ne pas etre null ou negatif");
                }
           }while (true);

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
            double NewPrice;

            do {
                NewPrice = scanner.nextDouble();
                scanner.nextLine();
                if (NewPrice>0){
                    break;
                }else {
                    System.out.println("price ne pas etre null ou negatif");
                }
            }while (true);
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





    //+++++++++++++++++++++++++Analyse des transactions +++++++++++++++++++++++++++++++++++++

    public static void  analyseDesTransactions(Scanner scanner){
        System.out.println("\n =======analyse Des Transactions===========");
        String choix;
        System.out.println("entrer votre choix \n 1:pour Afficher toutes les transactions d’un trader donné" +
                                     "\n 2:trierTrensaction  \n 3: trier Transaction Par Date  \n 4:trier Transaction Par Montant " +
                                      "\n 5:Volume Totale Echange Par Actif  \n 6:Montant Total Achat  \n 7:MontantTotalVent");
        choix = scanner.nextLine();
        if(choix.equals("1")){
            TradingPlatforme.afficherTransactionsTrader(scanner);
        }else if (choix.equals("2")){
            TradingPlatforme.trierTrensaction(scanner);
        }else if (choix.equals("3")){
            TradingPlatforme.trierTranParDate();
        }else if (choix.equals("4")){
            TradingPlatforme.trierTranParMontant();
        }else if(choix.equals("5")){
            TradingPlatforme.VolumeTotalEchangeParActif();
        }else if (choix.equals("6")){
            TradingPlatforme.MontantTotalAchat();
        }else if (choix.equals("7")){
            TradingPlatforme.MontantTotalVent();
        }


    }


//============================================================================
    public static void afficherTransactionsTrader(Scanner scanner) {
        System.out.println("Entrer l'ID du trader : ");
        String id = scanner.nextLine().trim();

        List<Transaction> result = TradingPlatforme.getTransactionList().stream()
                .filter(t -> t.getID().equals(id))
                .toList();

        if (result.isEmpty()) {
            System.out.println("Aucune transaction trouvée pour ce trader.");
        } else {
            System.out.println("Transactions du trader " + id + " :");
            result.forEach(t-> {
                    System.out.println("------------------------------");
            System.out.println("Type         : " + t.getType());
            System.out.println(" ID          : " + t.getID());
            System.out.println("Asset        : " +t.getQuantity() + t.getAsset());
            System.out.println("Price unite  : " + t.getPrice());
            System.out.println("  date       : " + t.getFormatedDate() );
            }
            );
        }
    }

//===============================================================================
    public static void trierTrensaction(Scanner scanner){
           String choix;
        do {
            System.out.println("pour filtrer transaction :  \n 1:vent \n 2:achat    \n 3:BTC   \n 4:GD ");
            choix = scanner.nextLine().trim();
            if(!choix.isEmpty()){
                break;
            }
        }while(true);
        if (choix.equals("1")) {
            List<Transaction> result = TradingPlatforme.getTransactionList().stream()
                    .filter(t -> t.getType().trim().equalsIgnoreCase("vent"))
                    .toList();

            if (result.isEmpty()) {
                System.out.println("Aucune transaction trouvée ");
            } else {
                System.out.println("Transactions vent " + " :");
                result.forEach(t-> {
                            System.out.println("------------------------------");
                            System.out.println(" Type : " + t.getType() + " ID : " + t.getID()+ "  Asset: " +t.getQuantity() +" "+ t.getAsset()  + " Price unite  : " + t.getPrice() + "  date : " + t.getFormatedDate()      );
                        }
                );
            }
        }
        else if (choix.equals("2")) {
            List<Transaction> result = TradingPlatforme.getTransactionList().stream()
                    .filter(t -> t.getType().trim().equalsIgnoreCase("achat"))
                    .toList();

            if (result.isEmpty()) {
                System.out.println("Aucune transaction trouvée ");
            } else {
                System.out.println("Transactions achat " + " :");
                result.forEach(t-> {
                            System.out.println("------------------------------");
                            System.out.println("  Type : " + t.getType() + " ID : " + t.getID()+ "  Asset: " +t.getQuantity() + " "+t.getAsset()  + " Price unite  : " + t.getPrice() + "  date : " + t.getFormatedDate()      );
                        }
                );
            }
        }
        else if (choix.equals("3")) {
            List<Transaction> result = TradingPlatforme.getTransactionList().stream()
                    .filter(t -> t.getAsset().trim().equalsIgnoreCase("BTC"))
                    .toList();

            if (result.isEmpty()) {
                System.out.println("Aucune transaction trouvée ");
            } else {
                System.out.println("Transactions BTC " + " :");
                result.forEach(t-> {
                            System.out.println("------------------------------");
                            System.out.println(" Type : " + t.getType() + " ID : " + t.getID()+ " Asset: " +t.getQuantity() +" "+ t.getAsset()  + " Price unite  : " + t.getPrice() + "  date : " + t.getFormatedDate()      );
                        }
                );
            }
        }
        else if (choix.equals("4")) {
            List<Transaction> result = TradingPlatforme.getTransactionList().stream()
                    .filter(t -> t.getAsset().trim().equalsIgnoreCase("GD"))
                    .toList();

            if (result.isEmpty()) {
                System.out.println("Aucune transaction trouvée ");
            } else {
                System.out.println("Transactions GD " + " :");
                result.forEach(t-> {
                            System.out.println("------------------------------");
                            System.out.println(" Type : " + t.getType() + " ID : " + t.getID()+ " Asset: " +t.getQuantity() +" "+ t.getAsset()  + " Price unite  : " + t.getPrice() + "  date : " + t.getFormatedDate()      );
                        }
                );
            }
        }

    }


//===================================================================


    public static void trierTranParDate (){
        List<Transaction> sortedByDate =
                getTransactionList().stream()
                        .sorted((t1, t2) -> t1.getFormatedDate().compareTo(t2.getFormatedDate()))
                        .toList();
                System.out.println("================sorted by date ================");
        sortedByDate.forEach(t-> {
            System.out.println("Type : " +t.getType()+ " ID :" +t.getID() + " Asset:"+t.getQuantity()+t.getAsset() +" Price unite  : "+t.getPrice()  +" date :"+ t.getFormatedDate());
        });
    }

    //===================================================================
    public static void trierTranParMontant (){

        List<Transaction> sortedByMontant =
                getTransactionList().stream()
                        .sorted((t1, t2) -> Double.compare((t1.getPrice()* t1.getQuantity()), (t2.getQuantity()* t2.getPrice())))
                        .toList();

        sortedByMontant.forEach(t-> {
            System.out.println("Type : " +t.getType()+ " ID :" +t.getID() + " Asset:"+t.getQuantity()+t.getAsset() +" Price unite  : "+t.getPrice()  +" date :"+ t.getFormatedDate());
        });
    }

//=========================================================

    public static void VolumeTotalEchangeParActif(){
        Map<String, Double> volumeParActif =
                getTransactionList().stream()
                        .collect(Collectors.groupingBy(
                                t -> t.getAsset(),
                                Collectors.summingDouble(t -> t.getQuantity())
                        ));
        System.out.println("volume d'asset echanger ");
        volumeParActif.forEach((k,v)->{
            System.out.println(k + " - " + v.toString());
                                                        });
    }

//===========================================================
    public static void MontantTotalAchat(){
        double totalAchats =
                getTransactionList().stream()
                        .filter(t -> t.getType().equals("achat"))
                        .mapToDouble(t -> (t.getQuantity() * t.getPrice()))
                        .sum();

        System.out.println("montant total d'achat");
        System.out.println(totalAchats);
    }

//===========================================================

    public static void MontantTotalVent(){
        double totalVentes =
                getTransactionList().stream()
                        .filter(t -> t.getType().equals("vent"))
                        .mapToDouble(t -> (t.getQuantity() * t.getPrice()))
                        .sum();

        System.out.println("montant total de vent ");
        System.out.println(totalVentes);
    }



    //+++++++++++++++++++++++++++Analyse de performance par trader+++++++++++

    public static void AnalysePerformanceTrader(Scanner scanner) {
        String choix;
        System.out.println("entrer votre choix \n 1:pour olume Total Echange Par Trader  \n 2:Nombre Total Ordres Passer  \n 3:Classement des Tradre Par Volume Top 3");

        choix = scanner.nextLine();
        if(choix.equals("1")){
           TradingPlatforme.VolumeTotalEchangeParTrader();
        }
        else if(choix.equals("2")){
            TradingPlatforme.NombreTotalOrdresPasse();
        }
        else if (choix.equals("3")){
            TradingPlatforme.ClassementTraderParVolumeTopN();
        }
    }


    //============================================================
    public static void  VolumeTotalEchangeParTrader(){
        Map<String, Double> volumeParTrader =
                getTransactionList().stream()
                        .collect(Collectors.groupingBy(
                                t -> t.getID(),
                                Collectors.summingDouble(t -> (t.getQuantity()* t.getPrice()))
                        ));
    volumeParTrader.forEach( (k,v)->{
        System.out.println("trader : "+k + " - " + v.toString());
    });
    }

//===========================================================

    public static void  NombreTotalOrdresPasse(){

        long nombreTotalOrdres = getTransactionList().stream().count();
        System.out.println("nombre total d'order passer est"+nombreTotalOrdres);
    }

//============================================================

    public static void ClassementTraderParVolumeTopN() {
        int N = 3;

        Map<String, Double> volumeParTrader = TradingPlatforme.getTransactionList().stream()
                                              .collect(Collectors.groupingBy(t -> t.getID(),
                                Collectors.summingDouble(t -> t.getQuantity())
                        ));


        List<Map.Entry<String, Double>> topTraders =
                volumeParTrader.entrySet().stream()
                        .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                        .limit(N)
                        .toList();


        System.out.println(" Top " + N + " Traders par volume :");
        topTraders.forEach(e ->
                System.out.println("Trader id : "+ e.getKey() + " → Volume : " + e.getValue())
        );
    }

//=========================================================




    //+++++++++++++++++++++++++Analyse globale du marché simulé+++++++++++++++++++
   public static void AnalyseGlobaleMarcheSimule(Scanner scanner) {
        String choix;
       System.out.println("entrer votre choix \n 1:Volume Total Echange Par Instrument Financier   " +
               "\n 2:Instrument Plus Echange   \n 3:Montant Total BUY        \n 4:Montant Total SELL");
       choix = scanner.nextLine();
       if(choix.equalsIgnoreCase("1")){
           TradingPlatforme.VolumeTotalEchangeParInstrumentFinancier();
       }else if(choix.equalsIgnoreCase("2")){
           TradingPlatforme.InstrumentPlusEchange();
       }else if(choix.equalsIgnoreCase("3")){
           TradingPlatforme.MontantTotalBUY();
       }else if(choix.equalsIgnoreCase("4")){
           TradingPlatforme.MontantTotalSELL();
       }



   }


    //====================================================================
    public static void VolumeTotalEchangeParInstrumentFinancier () {
        Map<String, Double> volumeParInstrument =
                getTransactionList().stream()
                        .collect(Collectors.groupingBy(t -> t.getAsset(),
                                Collectors.summingDouble(t -> t.getQuantity())
                        ));

                      System.out.println("Volume Total Echanger Par Instrument Financier");
        volumeParInstrument.forEach( (k,v)->{
            System.out.println("instrument finnanciere "+k + " - " + v.toString());
        });
    }


//============================================================
    public static void InstrumentPlusEchange() {

        Map<String, Double> volumeParActif =
                getTransactionList().stream()
                        .collect(Collectors.groupingBy(
                                t -> t.getAsset(),
                                Collectors.summingDouble(t -> t.getQuantity())
                        ));

        String instrumentPlusEchange =
                volumeParActif.entrySet().stream()
                        .max((e1, e2) -> Double.compare(e1.getValue(), e2.getValue()))
                        .get()
                        .getKey();

        System.out.println("Instrument le plus échangé : "
                + instrumentPlusEchange
                + " (Volume : " + volumeParActif.get(instrumentPlusEchange) + ")");
    }

//=========================================================

    public static void  MontantTotalBUY () {
        double totalBuy = getTransactionList().stream()
                        .filter(t -> t.getType().equals("achat"))
                        .mapToDouble(t -> (t.getPrice()* t.getQuantity()))
                        .sum();
        System.out.println("montant total buy :" +totalBuy);

    }

//===========================================================
    public static void MontantTotalSELL () {
        double totalSell =
                getTransactionList().stream()
                        .filter(t -> t.getType().equals("vent"))
                        .mapToDouble(t -> (t.getPrice()* t.getQuantity()))
                        .sum();

        System.out.println("montant total sell : " + totalSell);
    }

















}
