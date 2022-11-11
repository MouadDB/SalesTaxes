package com.itemis.salestaxes;

/**
 * Represent the implementation of all other product other than Food, Book etc...
 * 
 * @author Mouad Douieb
 */
public class Others extends Item {
    
    /**
     * Food parameterized constructor
     * 
     * @param name
     * @param price
     * @param quantity
     * @param isImported 
     */
    public Others(String name, double price, int quantity,  boolean isImported) {
        super(name, price, quantity, isImported);
    }

    @Override
    public void calculateSalesTaxes() {
        double salesTaxes = (this.getPrice() * this.getINTIAL_TAX_RATE_FOR_GOODS());
        if(isImported()){
            salesTaxes += (this.getPrice() * this.getINTIAL_IMPORT_DUTY_RATE());
        }

        salesTaxes = (Math.round(salesTaxes * 50) / 50.0);
        this.setSalesTaxes(salesTaxes);
    }

}
