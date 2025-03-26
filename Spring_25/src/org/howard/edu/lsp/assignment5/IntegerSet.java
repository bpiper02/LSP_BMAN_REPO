package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a set of integers with various set operations.
 * This class implements basic set operations like union, intersection, difference, and complement.
 */
public class IntegerSet {
    // Store the set elements in an ArrayList.
    private List<Integer> set = new ArrayList<Integer>();

    /**
     * Default Constructor
     */
    public IntegerSet() {
    }

    /**
     * Constructor that takes an ArrayList of integers
     * @param set The ArrayList containing the initial set elements
     */
    public IntegerSet(ArrayList<Integer> set) {
        this.set = set;
    }

    /**
     * Clears all elements from the set
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set
     * @return The size of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks if two sets are equal
     * @param o The object to compare with
     * @return true if the sets contain the same elements (in any order), false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerSet that = (IntegerSet) o;
        if (set.size() != that.set.size()) return false;
        return set.containsAll(that.set) && that.set.containsAll(set);
    }

    /**
     * Checks if the set contains a specific value
     * @param value The value to check for
     * @return true if the value is in the set, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest element in the set
     * @return The largest integer in the set
     * @throws RuntimeException if the set is empty
     */
    public int largest() {
        if (isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return set.stream().max(Integer::compareTo).get();
    }

    /**
     * Returns the smallest element in the set
     * @return The smallest integer in the set
     * @throws RuntimeException if the set is empty
     */
    public int smallest() {
        if (isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return set.stream().min(Integer::compareTo).get();
    }

    /**
     * Adds an element to the set if it's not already present
     * @param item The integer to add to the set
     */
    public void add(int item) {
        if (!contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an element from the set if it exists
     * @param item The integer to remove from the set
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Performs the union operation with another set
     * @param intSetb The set to union with
     */
    public void union(IntegerSet intSetb) {
        for (Integer item : intSetb.set) {
            add(item);
        }
    }

    /**
     * Performs the intersection operation with another set
     * @param intSetb The set to intersect with
     */
    public void intersect(IntegerSet intSetb) {
        set.removeIf(item -> !intSetb.contains(item));
    }

    /**
     * Performs the set difference operation (this set - intSetb)
     * @param intSetb The set to subtract
     */
    public void diff(IntegerSet intSetb) {
        set.removeIf(intSetb::contains);
    }

    /**
     * Performs the complement operation with respect to another set
     * @param intSetb The set to complement with
     */
    public void complement(IntegerSet intSetb) {
        ArrayList<Integer> temp = new ArrayList<>(set);
        clear();
        for (Integer item : intSetb.set) {
            if (!temp.contains(item)) {
                add(item);
            }
        }
    }

    /**
     * Checks if the set is empty
     * @return true if the set contains no elements, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set
     * @return A string containing the elements of the set in square brackets
     */
    @Override
    public String toString() {
        return set.toString();
    }
} 