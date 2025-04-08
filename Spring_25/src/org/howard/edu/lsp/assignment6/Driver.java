package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;

/**
 * Driver class to test the IntegerSet implementation
 */
public class Driver {
    public static void main(String[] args) {
        // Test constructor and toString
        System.out.println("Testing constructor and toString:");
        IntegerSet set1 = new IntegerSet();
        System.out.println("Empty set1: " + set1.toString());
        
        // Test add and contains
        System.out.println("\nTesting add and contains:");
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("Set1 after adding elements: " + set1.toString());
        System.out.println("Set1 contains 2: " + set1.contains(2));
        System.out.println("Set1 contains 4: " + set1.contains(4));
        
        // Test length
        System.out.println("\nTesting length:");
        System.out.println("Length of Set1: " + set1.length());
        
        // Test smallest and largest
        System.out.println("\nTesting smallest and largest:");
        System.out.println("Smallest in Set1: " + set1.smallest());
        System.out.println("Largest in Set1: " + set1.largest());
        
        // Test remove
        System.out.println("\nTesting remove:");
        set1.remove(2);
        System.out.println("Set1 after removing 2: " + set1.toString());
        
        // Test clear and isEmpty
        System.out.println("\nTesting clear and isEmpty:");
        System.out.println("Is Set1 empty? " + set1.isEmpty());
        set1.clear();
        System.out.println("Is Set1 empty after clear? " + set1.isEmpty());
        
        // Test union
        System.out.println("\nTesting union:");
        set1.add(1);
        set1.add(2);
        set1.add(3);
        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        System.out.println("Set1 before union: " + set1.toString());
        System.out.println("Set2 before union: " + set2.toString());
        set1.union(set2);
        System.out.println("Set1 after union: " + set1.toString());
        
        // Test intersection
        System.out.println("\nTesting intersection:");
        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.clear();
        set2.add(2);
        set2.add(3);
        set2.add(4);
        System.out.println("Set1 before intersection: " + set1.toString());
        System.out.println("Set2 before intersection: " + set2.toString());
        set1.intersect(set2);
        System.out.println("Set1 after intersection: " + set1.toString());
        
        // Test difference
        System.out.println("\nTesting difference:");
        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.clear();
        set2.add(2);
        set2.add(3);
        System.out.println("Set1 before difference: " + set1.toString());
        System.out.println("Set2 before difference: " + set2.toString());
        set1.diff(set2);
        System.out.println("Set1 after difference: " + set1.toString());
        
        // Test complement
        System.out.println("\nTesting complement:");
        set1.clear();
        set1.add(1);
        set1.add(2);
        set2.clear();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);
        System.out.println("Set1 before complement: " + set1.toString());
        System.out.println("Set2 before complement: " + set2.toString());
        set1.complement(set2);
        System.out.println("Set1 after complement: " + set1.toString());
        
        // Test equals
        System.out.println("\nTesting equals:");
        set1.clear();
        set1.add(1);
        set1.add(2);
        set2.clear();
        set2.add(2);
        set2.add(1);
        System.out.println("Set1: " + set1.toString());
        System.out.println("Set2: " + set2.toString());
        System.out.println("Are sets equal? " + set1.equals(set2));
        
        // Test with ArrayList constructor
        System.out.println("\nTesting ArrayList constructor:");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        IntegerSet set3 = new IntegerSet(list);
        System.out.println("Set3 created from ArrayList: " + set3.toString());
    }
} 