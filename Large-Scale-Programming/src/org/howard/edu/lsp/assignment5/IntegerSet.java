//Name: Kofi Agyenim-Boateng

package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IntegerSet {
    private List<Integer> set = new ArrayList<Integer>();

    /**
     * Default Constructor
     */
    public IntegerSet() {
    }

    // Constructor if you want to pass in already initialized
    public IntegerSet(ArrayList<Integer> set) {
        this.set = set;
    }

    /**
     *  Clears the internal representation of the set
     */
    public void clear() {
        set.clear();
    }

    /**
     *  Returns the length of the set
     * @return integer
     */
    
    public int length() {
        return set.size();
    }

    /**
     * Returns true if the 2 sets are equal, false otherwise;
     * Two sets are equal if they contain all of the same values in ANY order.
     * @param set An IntegerSet Type
     * @return Boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        IntegerSet that = (IntegerSet) o;
        return new HashSet<>(set).equals(new HashSet<>(that.set));
    }


    /**
     *  Returns true if the set contains the value, otherwise false
     * @param value Integer
     * @return Boolean
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     *  Returns the largest item in the set; Throws a IntegerSetException if the set is empty 
     * @return Integer
     * @throws Exception
     */
    public int largest() throws IntegerSetException {
        if (set.isEmpty())
            throw new IntegerSetException("Set is empty");
        int max = Integer.MIN_VALUE;
        for (int num : set) {
            max = Math.max(max, num);
        }
        return max;
    }

    /**
     *  Returns the smallest item in the set; Throws a IntegerSetException if the set is empty
     * @return Integer
     * @throws Exception
     */
    public int smallest() throws IntegerSetException {
        if (set.isEmpty())
            throw new IntegerSetException("Set is empty");
        int min = Integer.MAX_VALUE;
        for (int num : set) {
            min = Math.min(min, num);
        }
        return min;
    }

    /**
     *  Adds an item to the set or does nothing it already there	
     * @param item An integer
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set or does nothing if not there
     * @param item An integer
     */
    public void remove(int item) {
        set.remove((Integer) item);
    }

    /**
     *  Set union
     * @param setb
     */
    public void union(IntegerSet intSetb) {
        for (int num : intSetb.set) {
            add(num);
        }
    }

    /**
     *  Set intersection
     * @param setb An IntegerSet Type
     */
    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    /**
     *  Set difference, i.e., seta – setb
     * @param set2 An IntegerSet Type
     */
    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }

    /**
     *  Set Complement
     * @param setb An IntegerSet Type
     */
    public void complement(IntegerSet intSetb) {
        IntegerSet complementSet = new IntegerSet(); // Create a new set to store the complement
        for (int num : set) {
            if (!intSetb.contains(num)) { // Check if the element is not present in intSetb
                complementSet.add(num); // Add the element to the complement set
            }
        }
        set = complementSet.set; // Update the current set with the complement set
    }


    /**
     * Returns true if the set is empty, false otherwise
     * @return Boolean
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     *  Return String representation of your set
     */
    public String toString() {
        return set.toString();
    }
}
