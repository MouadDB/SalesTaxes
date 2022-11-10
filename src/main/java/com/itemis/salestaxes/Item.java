package com.itemis.salestaxes;

/**
 * Represent order item (Product) and it has all the product details
 * 
 * @author Mouad Douieb
 */
class Item {
    
    /**
     * The Default Tax rate for goods
     */
    public static final double INTIAL_TAX_RATE_FOR_GOODS = 0.1;

    /** 
     * The default import duty tax rate
     */
    public static final double INTIAL_IMPORT_DUTY_RATE = 0.05;

    /**
     * Product name
     */
    private String name;
    
    /**
     * Product Price
     */
    private double price;
    
    /**
     * Product Quantity 
     */
    private int quantity;
    
    /**
     * Is the Product imported ?
     */
    private boolean imported = false;
    
    /**
     * Is the product taxable ?
     */
    private boolean taxable;
    
    
    
}
