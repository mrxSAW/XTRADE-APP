package org.example;

public class CreptoCurrency extends Asset {


    private String  blockshaine;

    public CreptoCurrency(String blockshaine,String name,String code ,double UnitPrice,int quantity ) {
        super(name,code,UnitPrice,quantity);
        this.blockshaine = blockshaine;
    }

    public String getBlockshaine() {
        return blockshaine;
    }

    public void setBlockshaine(String blockshaine) {
        this.blockshaine = blockshaine;
    }
}
