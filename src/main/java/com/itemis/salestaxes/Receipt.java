package com.itemis.salestaxes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mouad Douieb
 */
public class Receipt {

    ArrayList<String> order = new ArrayList<String>();

    public Receipt() {
        getOrder();
    }

    public void getOrder() {

        Scanner sc = new Scanner(System.in);
        System.out.println("### INPUT:");
        try {
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                if (line.isEmpty()) {
                    break;
                } else {
                    order.add(line);
                }

            }

            sc.close();
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
    }

    public void printReceipt() {
        
        for (String orderItem : order) {
            System.out.printf(orderItem + "\n");

        }

        System.out.printf("\nSales Tax: %.2f \n", 0.00);
        System.out.println("Total: " + 0.00);
    }
}
