package org.example;

public class Stock extends Asset {

    private String companyName;


    public Stock(String companyName,String name,String code,double UnitPrice,int quantity) {
        super(name,code,UnitPrice,quantity);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}





