package com.itemis.salestaxes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents receipt calculated
 * 
 * @author Mouad Douieb
 */
public class Receipt {

    ArrayList<String> order = new ArrayList<String>();

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
                    
                    // Adding new order to the list
                    order.add(line);
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
        
        for (String orderItem : order) {
            System.out.printf(orderItem + "\n");
        }

        System.out.printf("\nSales Tax: %.2f \n", 0.00);
        System.out.println("Total: " + 0.00);
    }
}
