package com.itemis.salestaxes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Represents receipt calculated
 *
 * @author Mouad Douieb
 */
public final class Receipt {

    /**
     * Order array list
     */
    private ArrayList<Map<String, Object>> order = new ArrayList<Map<String, Object>>();

    /**
     * Cart object
     */
    private Cart cart;

    /**
     * Total Sales tax
     */
    private double totalSalesTax;

    /**
     * Total receipt price
     */
    private double totalPrice;

    /**
     * Non Taxable Goods list
     */
    private String[] nonTaxableGoods = {
        "book",
        "chocolate"
    };

    public Receipt() {

        this.cart = new Cart();

        // Step 1: Get the order
        getOrder();

        // Step 2: Process the order
        processOrder();

        // Step 3: Calculate Taxes
        this.cart.calculateTax();

        totalSalesTax = cart.getTotalTax();
        totalPrice = cart.getTotalCost();
    }

    /**
     * Get user input from console and process it
     *
     */
    public void getOrder() {

        // Scan user inputs
        Scanner sc = new Scanner(System.in);
        System.out.println("### INPUT:");

        try {
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                // Break the loop if the user entered an empty line
                if (line.isEmpty()) {
                    break;
                } else {
                    String[] words = line.split(" ");

                    int quantity = Integer.parseInt(words[0]);

                    // Get item type
                    String type = Utils.ContainsItemsInArray(line, this.nonTaxableGoods);

                    int indexOfAt = line.indexOf(" at");

                    String name = line.substring(0, indexOfAt);

                    double price = Double.parseDouble(line.substring(indexOfAt + 4));

                    Map<String, Object> orderItem = new HashMap<>();

                    orderItem.put("quantity", quantity);
                    orderItem.put("name", name);
                    orderItem.put("price", price);
                    orderItem.put("type", type);

                    this.order.add(orderItem);

                }

            }

            sc.close();
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Process user order, Adding item to cart and calculating taxes and total
     *
     */
    public void processOrder() {

        for (Map<String, Object> orderItem : order) {

            // Add product as Book type
            if (orderItem.get("type").equals("book")) {
                Book item = new Book(orderItem.get("name").toString(), (double) orderItem.get("price"), (int) orderItem.get("quantity"), false);
                cart.getCartItems().add(item);
            } // Add product as Food type
            else if (orderItem.get("type").equals("chocolate")) {
                Food item = new Food(orderItem.get("name").toString(), (double) orderItem.get("price"), (int) orderItem.get("quantity"), false);
                cart.getCartItems().add(item);
            } // Any other product
            else {
                Others item = new Others(orderItem.get("name").toString(), (double) orderItem.get("price"), (int) orderItem.get("quantity"), false);
                cart.getCartItems().add(item);
            }
        }
    }

    /**
     * Print Receipt cart list, Sales Tax and Total
     *
     */
    public void printReceipt() {

        for (Map<String, Object> orderItem : order) {
            System.out.printf(orderItem.toString() + "\n");
        }

        System.out.printf("\nSales Tax: %.2f \n", totalSalesTax);
        System.out.println("Total: " + totalPrice);
    }
}
