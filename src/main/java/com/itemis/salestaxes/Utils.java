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
}
