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

    public Item(String name, double price, int quantity, boolean taxable) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.taxable = taxable;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isImported() {
        return imported;
    }

    public boolean isTaxable() {
        return taxable;
    }

    public static double getINTIAL_TAX_RATE_FOR_GOODS() {
        return INTIAL_TAX_RATE_FOR_GOODS;
    }

    public static double getINTIAL_IMPORT_DUTY_RATE() {
        return INTIAL_IMPORT_DUTY_RATE;
    }

}
