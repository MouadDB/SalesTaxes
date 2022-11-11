package com.itemis.salestaxes;

/**
 *
 * @author Mouad Douieb
 */
public class Utils {

    public static String ContainsItemsInArray(String line, String[] items) {
        for (String item : items) {
            if (line.contains(item)) {
                return item;
            }
        }
        return "others";
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public static double roundToFive(double input) {
        int cents = (int) (input * 100);
        int lastDigit = cents % 10;
        boolean mustAddUnit = false;
        if (lastDigit > 5) {
            mustAddUnit = true;
            lastDigit = 0;
        } else if (lastDigit > 0) {
            lastDigit = 5;
        } else {
            lastDigit = 0;
        }
        cents = cents / 10;
        if (mustAddUnit) {
            cents += 1;
        }
        cents = cents * 10;
        cents = cents + lastDigit;
        return cents / 100F;
    }
}
