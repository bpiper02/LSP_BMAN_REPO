package org.howard.edu.lsp.lspfinal.question3;

/**
 * Driver class to demonstrate the reporting system using Template Method pattern.
 */
public class Driver {
    public static void main(String[] args) {
        // Create and generate a sales report
        AbstractReport salesReport = new SalesReport();
        salesReport.generateReport();
        
        System.out.println(); // Empty line for readability
        
        // Create and generate an inventory report
        AbstractReport inventoryReport = new InventoryReport();
        inventoryReport.generateReport();
    }
} 