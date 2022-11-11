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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
