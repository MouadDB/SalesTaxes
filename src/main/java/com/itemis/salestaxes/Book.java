package com.itemis.salestaxes;

/**
 *
 * @author Mouad Douieb
 */
public class Book extends Item {
    
    /**
     * Book parameterized constructor
     * 
     * @param name
     * @param price
     * @param quantity
     * @param isImported 
     */
    public Book(String name, double price, int quantity,  boolean isImported) {
        super(name, price, quantity, isImported);
    }

    @Override
    public void calculateSalesTaxes() {
        
        if(super.isImported()){
            
            // Add import tax duty to all imported products
            double salesTaxes = super.getSalesTaxes() + (super.getPrice()* this.getINTIAL_IMPORT_DUTY_RATE());
            
            // rounded up to the nearest 0.05
            salesTaxes = (Math.round(salesTaxes * 20) / 20.0);
            this.setSalesTaxes(salesTaxes);
        }
    }
    
    
}
