package com.itemis.salestaxes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        "chocolate",
        "pills"
    };

    /**
     * To read the order form file
     */
    private String filename = "";

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Receipt() {

    }

    public void startOrder() {
        this.cart = new Cart();

        // Step 1: Process Inputs
        processInputs();

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
    public void processInputs() {

        Scanner sc;

        try {
            // Scan user inputs
            if (this.filename.length() > 0) {
                File file = new File(filename);
                sc = new Scanner(file);
            } else {
                sc = new Scanner(System.in);
                System.out.println("### INPUT:");

            }

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

                    // Remove quantity and imported from product name
                    name = name.replaceAll("\\d+\\s", "");

                    name = name.replaceAll("imported ", "");

                    double price = Double.parseDouble(line.substring(indexOfAt + 4));

                    String[] importedWords = {
                        "imported"
                    };

                    boolean imported = (Utils.ContainsItemsInArray(line, importedWords) == "imported") ? true : false;

                    Map<String, Object> orderItem = new HashMap<>();

                    orderItem.put("name", name);
                    orderItem.put("quantity", quantity);
                    orderItem.put("price", price);
                    orderItem.put("type", type);
                    orderItem.put("imported", imported);

                    this.order.add(orderItem);

                }

            }

            sc.close();
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Receipt.class.getName()).log(Level.SEVERE, null, ex);
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
                Book item = new Book(orderItem.get("name").toString(), (double) orderItem.get("price"), (int) orderItem.get("quantity"), (boolean) orderItem.get("imported"));
                cart.getCartItems().add(item);
            } // Add product as Food type
            else if (orderItem.get("type").equals("chocolate")) {
                Food item = new Food(orderItem.get("name").toString(), (double) orderItem.get("price"), (int) orderItem.get("quantity"), (boolean) orderItem.get("imported"));
                cart.getCartItems().add(item);
            } // Add Medical products
            else if (orderItem.get("type").equals("pills")) {
                Medical item = new Medical(orderItem.get("name").toString(), (double) orderItem.get("price"), (int) orderItem.get("quantity"), (boolean) orderItem.get("imported"));
                cart.getCartItems().add(item);
            } // Any other product
            else {
                Others item = new Others(orderItem.get("name").toString(), (double) orderItem.get("price"), (int) orderItem.get("quantity"), (boolean) orderItem.get("imported"));
                cart.getCartItems().add(item);
            }
        }
    }

    @Override
    public String toString() {

        String output = new String();

        for (Item cartItem : this.cart.getCartItems()) {

            String isImportedString = (cartItem.isImported()) ? "imported " : "";
            output += String.format("%d %s%s: %.2f\n", cartItem.getQuantity(), isImportedString, cartItem.getName(), cartItem.getCost());
        }

        output += String.format("Sales Taxes: %.2f\n", totalSalesTax);
        output += String.format("Total: " + totalPrice);
        output += "\n";
        return output;
    }

    /**
     * Print Receipt cart list, Sales Tax and Total
     *
     */
    public void printReceipt() {
        System.out.print(this.toString());
    }
}
