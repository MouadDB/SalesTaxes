package com.itemis.salestaxes;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents order cart that has order items
 *
 * @author Mouad Douieb
 */
public class Cart {
    
    /**
     * Cart Items list
     */
    private List<Item> cartItems;

    /**
     * Total cart tax
     */
    private double totalTax;

    /**
     * Total cart cost
     * 
     */
    private double totalCost;

    /**
     * Default Constructor
     * 
     */
    public Cart() {
        this.cartItems = new ArrayList<>();;
    }


    /**
     * Get the value of cartItems
     *
     * @return the value of cartItems
     */
    public List<Item> getCartItems() {
        return cartItems;
    }

    /**
     * Set the value of cartItems
     *
     * @param cartItems new value of cartItems
     */
    public void setCartItems(List<Item> cartItems) {
        this.cartItems = cartItems;
    }

    /**
     * Get the value of totalTax
     *
     * @return the value of totalTax
     */
    public double getTotalTax() {
        return totalTax;
    }

    /**
     * Set the value of totalTax
     *
     */
    public void setTotalTax() {
        double sum = 0;
        sum = this.cartItems.stream().map((item) -> item.getSalesTaxes()).reduce(sum, (accumulator, _item) -> accumulator + _item);
        this.totalTax = sum;
    }

    /**
     * Get the value of totalCost
     *
     * @return the value of totalCost
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * Set the value of totalCost
     *
     */
    public void setTotalCost() {
        double sum = 0;
        sum = this.cartItems.stream().map((item) -> item.getCost()).reduce(sum, (accumulator, _item) -> accumulator + _item);
        
        this.totalCost = Utils.round(sum, 2);
    }

    public void calculateTax() {
        this.getCartItems().stream().map((item) -> {

            item.calculateSalesTaxes();
            return item;
        }).forEachOrdered((item) -> {
            item.setCost();
        });
        this.setTotalTax();
        this.setTotalCost();
    }
}
