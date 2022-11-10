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
public class Receipt {

    /**
     * Order array list
     */
    private ArrayList<Map<String, Object>> order = new ArrayList<Map<String, Object>>();

    /**
     * Non Taxable Goods list
     */
    private String[] nonTaxableGoods = new String[]{
        "book",
        "chocolate"
    };

    public Receipt() {
        getOrder();
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
                }

            }

            sc.close();
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
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

        System.out.printf("\nSales Tax: %.2f \n", 0.00);
        System.out.println("Total: " + 0.00);
    }
}
