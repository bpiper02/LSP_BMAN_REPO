/**
 * References:
 * 1. JUnit 5 User Guide - https://junit.org/junit5/docs/current/user-guide/

package org.howard.edu.lsp.lspfinal.question1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test class for ShoppingCart
 */
public class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    @DisplayName("Test for adding valid item")
    void testAddValidItem() {
        cart.addItem("Book", 29.99);
        assertEquals(29.99, cart.getTotalCost(), 0.01);
    }

    @Test
    @DisplayName("Test for adding item with 0 price (expect exception)")
    void testAddItemWithZeroPrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Free Item", 0.0);
        });
    }

    @Test
    @DisplayName("Test for adding item with negative price (expect exception)")
    void testAddItemWithNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Invalid Item", -10.0);
        });
    }

    @Test
    @DisplayName("Test for removing existing item")
    void testRemoveExistingItem() {
        cart.addItem("Book", 20.0);
        cart.addItem("Pen", 5.0);
        assertEquals(25.0, cart.getTotalCost(), 0.01);
        
        cart.removeItem("Book");
        assertEquals(5.0, cart.getTotalCost(), 0.01);
    }

    @Test
    @DisplayName("Test for removing non-existent item (expect exception)")
    void testRemoveNonExistentItem() {
        cart.addItem("Book", 20.0);
        assertThrows(IllegalArgumentException.class, () -> {
            cart.removeItem("NonExistentItem");
        });
    }

    @Test
    @DisplayName("Test for applying \"SAVE10\"")
    void testApplySave10Discount() {
        cart.addItem("Laptop", 1000.0);
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage());
        assertEquals(900.0, cart.getTotalCost(), 0.01);
    }

    @Test
    @DisplayName("Test for applying \"SAVE20\"")
    void testApplySave20Discount() {
        cart.addItem("Phone", 500.0);
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage());
        assertEquals(400.0, cart.getTotalCost(), 0.01);
    }

    @Test
    @DisplayName("Test for applying invalid code (expect exception)")
    void testApplyInvalidDiscountCode() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode("SAVE50");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode("");
        });
    }

    @Test
    @DisplayName("Test total cost without discount")
    void testTotalCostWithoutDiscount() {
        cart.addItem("Book", 20.0);
        cart.addItem("Pen", 5.0);
        cart.addItem("Notebook", 10.0);
        assertEquals(35.0, cart.getTotalCost(), 0.01);
    }

    @Test
    @DisplayName("Test total cost with discount")
    void testTotalCostWithDiscount() {
        cart.addItem("Tablet", 200.0);
        cart.addItem("Case", 30.0);
        cart.applyDiscountCode("SAVE20");
        // Total before discount: 230.0
        // 20% discount on 230.0 = 46.0
        // Expected total: 184.0
        assertEquals(184.0, cart.getTotalCost(), 0.01);
    }

    @Test
    @DisplayName("Test total cost with empty cart")
    void testTotalCostWithEmptyCart() {
        assertEquals(0.0, cart.getTotalCost(), 0.01);
        cart.applyDiscountCode("SAVE10");
        assertEquals(0.0, cart.getTotalCost(), 0.01);
    }
} 