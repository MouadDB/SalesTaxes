package com.itemis.salestaxes;

/**
 *
 * @author Mouad Douieb
 */
public class Food extends Item {

    /**
     * Food parameterized constructor
     * 
     * @param name
     * @param price
     * @param quantity
     * @param isImported 
     */
    public Food(String name, double price, int quantity,  boolean isImported) {
        super(name, price, quantity, isImported);
    }

    @Override
    public void calculateSalesTaxes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
