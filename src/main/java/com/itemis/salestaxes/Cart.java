package com.itemis.salestaxes;

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
     * @param totalTax new value of totalTax
     */
    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
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
     * @param totalCost new value of totalCost
     */
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

}
