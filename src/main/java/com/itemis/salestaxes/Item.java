package com.itemis.salestaxes;

/**
 * Represent order item (Product) and it has all the product details
 *
 * @author Mouad Douieb
 */
public abstract class Item {

    /**
     * The Default Tax rate for goods
     */
    private static final double INTIAL_TAX_RATE_FOR_GOODS = 0.1;

    /**
     * The default import duty tax rate
     */
    private static final double INTIAL_IMPORT_DUTY_RATE = 0.05;

    /**
     * Product name
     */
    private String name;

    /**
     * Product Price
     */
    private double price;

    private double cost;

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
    private boolean taxable = true;

    /**
     * Sales Taxes
     */
    private double salesTaxes = 0;

    /**
     * Default Constructor
     */
    public Item() {
        this.name = "";
        this.price = 0.00;
    }

    /**
     * Item parameterized constructor
     *
     * @param name
     * @param price
     * @param quantity
     * @param imported
     */
    public Item(String name, double price, int quantity, boolean imported) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imported = imported;
    }

    
    public abstract void calculateSalesTaxes();

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the value of price
     *
     * @return the value of price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the value of price
     *
     * @param price new value of price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get the value of cost
     *
     * @return the value of cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * Set the value of cost
     *
     */
    public void setCost() {
        this.cost = this.quantity * (this.salesTaxes + this.getPrice());
    }

    /**
     * Get the value of quantity
     *
     * @return the value of quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the value of quantity
     *
     * @param quantity new value of quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the value of imported
     *
     * @return the value of imported
     */
    public boolean isImported() {
        return imported;
    }

    /**
     * Set the value of imported
     *
     * @param imported new value of imported
     */
    public void setImported(boolean imported) {
        this.imported = imported;
    }

    /**
     * Get the value of taxable
     *
     * @return the value of taxable
     */
    public boolean isTaxable() {
        return taxable;
    }

    /**
     * Set the value of taxable
     *
     * @param taxable new value of taxable
     */
    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }

    /**
     * Get the value of salesTaxes
     *
     * @return the value of salesTaxes
     */
    public double getSalesTaxes() {
        return salesTaxes;
    }

    /**
     * Set the value of salesTaxes
     *
     * @param salesTaxes new value of salesTaxes
     */
    public void setSalesTaxes(double salesTaxes) {
        this.salesTaxes = salesTaxes;
    }

    /**
     * Get the value of INTIAL_IMPORT_DUTY_RATE
     *
     * @return the value of INTIAL_IMPORT_DUTY_RATE
     */
    public static double getINTIAL_IMPORT_DUTY_RATE() {
        return INTIAL_IMPORT_DUTY_RATE;
    }

    /**
     * Get the value of INTIAL_TAX_RATE_FOR_GOODS
     *
     * @return the value of INTIAL_TAX_RATE_FOR_GOODS
     */
    public static double getINTIAL_TAX_RATE_FOR_GOODS() {
        return INTIAL_TAX_RATE_FOR_GOODS;
    }

}
