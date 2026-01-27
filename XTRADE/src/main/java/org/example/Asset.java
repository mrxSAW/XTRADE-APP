package org.example;

public class Asset {

      private String code;
      private String name;
      private double UnitPrice;
      private int quantity;

    public Asset(String name, String code, double UnitPrice, int quantity) {
        this.name = name;
        this.code = code;
        this.UnitPrice = UnitPrice;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
