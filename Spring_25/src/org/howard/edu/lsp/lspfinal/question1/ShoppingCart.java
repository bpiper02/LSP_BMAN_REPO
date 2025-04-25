package org.howard.edu.lsp.lspfinal.question1;

/**
 * References:
 * 1. JUnit 5 User Guide - https://junit.org/junit5/docs/current/user-guide/
 * 2. Java HashMap Documentation - https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
 * 3. Java Exception Handling - https://docs.oracle.com/javase/tutorial/essential/exceptions/
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a simple shopping cart that allows adding items,
 * applying discount codes, and calculating the total cost.
 */
public class ShoppingCart {
    private Map<String, Double> items = new HashMap<>();
    private double discountPercentage = 0.0;

    /**
     * Adds an item to the shopping cart.
     * 
     * @param itemName  the name of the item
     * @param price     the price of the item (must be non-negative)
     * @throws IllegalArgumentException if price is negative
     */
    public void addItem(String itemName, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        items.put(itemName, price);
    }

    /**
     * Removes an item from the shopping cart.
     * 
     * @param itemName  the name of the item to remove
     * @throws IllegalArgumentException if the item does not exist in the cart
     */
    public void removeItem(String itemName) {
        if (!items.containsKey(itemName)) {
            throw new IllegalArgumentException("Item '" + itemName + "' not found in cart.");
        }
        items.remove(itemName);
    }

    /**
     * Calculates and returns the total cost of the cart,
     * applying any discounts currently in effect.
     * 
     * @return total cost after applying discount
     */
    public double getTotalCost() {
        double total = 0.0;
        for (double price : items.values()) {
            total += price;
        }
        double discountAmount = total * (discountPercentage / 100.0);
        return total - discountAmount;
    }

    /**
     * Applies a valid discount code to the shopping cart.
     * Supported codes:
     * - "SAVE10": 10% discount
     * - "SAVE20": 20% discount
     * 
     * @param code  the discount code
     * @throws IllegalArgumentException if the code is invalid
     */
    public void applyDiscountCode(String code) {
        switch (code) {
            case "SAVE10":
                discountPercentage = 10.0;
                break;
            case "SAVE20":
                discountPercentage = 20.0;
                break;
            default:
                throw new IllegalArgumentException("Invalid discount code.");
        }
    }

    /**
     * Returns the current discount percentage applied to the cart.
     * Useful for testing.
     * 
     * @return the discount percentage (0.0 if no discount applied)
     */
    public double getDiscountPercentage() {
        return discountPercentage;
    }
} 