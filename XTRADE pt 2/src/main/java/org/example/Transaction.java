package org.example;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Transaction {


   private String type;
   private String ID;
   private String asset;
   private  int quantity;
   private  double price;
   private LocalDateTime localtime;
   private static ArrayList<Transaction> TransactionList=new ArrayList<>();

    public Transaction(String type,String ID,String asset, int quantity, double price) {
        this.type = type;
        this.ID = ID;
        this.asset = asset;
        this.quantity = quantity;
        this.price = price;
        this.localtime = LocalDateTime.now();
    }


    public static ArrayList<Transaction> getTransactionList() {
        return TransactionList;
    }

    public String getType() {
        return type;
    }

    public String getID() {
        return ID;
    }

    public String getAsset() {  return asset; }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
    public LocalDateTime getLocaltime() {
        return localtime;
    }

    public  String getFormatedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return localtime.format(formatter);
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }













}
