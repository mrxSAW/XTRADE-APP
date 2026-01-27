package org.example;
import java.util.Date;

public class Transaction {


   private String type;
   private  int quantity;
   private  double price;
   private Date  localtime;


    public Transaction(String type, int quantity, double price, Date localtime) {
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.localtime = localtime;
    }


    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Date getLocaltime() {
        return localtime;
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

    public void setLocaltime(Date localtime) {
        this.localtime = localtime;
    }











}
