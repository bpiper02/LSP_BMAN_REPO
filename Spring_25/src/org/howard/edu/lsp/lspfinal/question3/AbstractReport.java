package org.howard.edu.lsp.lspfinal.question3;

/**
 * References:
 * 1. Design Patterns: Elements of Reusable Object-Oriented Software (Gang of Four) - Template Method Pattern
 *    ISBN: 978-0201633610
 * 2. Head First Design Patterns - Template Method Pattern
 *    ISBN: 978-0596007126
 * 3. Java Documentation on Abstract Classes - https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html
 * 4. Refactoring Guru - Template Method Pattern - https://refactoring.guru/design-patterns/template-method
 */

/**
 * Abstract base class for reports implementing the Template Method pattern.
 * Defines the skeleton of the report generation algorithm.
 */
public abstract class AbstractReport {
    
    /**
     * Template method that defines the algorithm for generating a report.
     * This method is final to prevent subclasses from changing the workflow.
     */
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }
    
    /**
     * Hook method for loading data specific to each report type.
     * Must be implemented by concrete subclasses.
     */
    protected abstract void loadData();
    
    /**
     * Hook method for formatting data specific to each report type.
     * Must be implemented by concrete subclasses.
     */
    protected abstract void formatData();
    
    /**
     * Hook method for printing the report in a format specific to each report type.
     * Must be implemented by concrete subclasses.
     */
    protected abstract void printReport();
} 