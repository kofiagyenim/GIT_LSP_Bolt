package org.howard.edu.lsp.assignment5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.howard.edu.lsp.assignment4.IntegerSet;
import org.howard.edu.lsp.assignment4.IntegerSetException;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class IntegerSetTest {
    private IntegerSet setA;
    private IntegerSet setB;

    @BeforeEach
    public void setUp() {
        setA = new IntegerSet();
        setB = new IntegerSet();
    }

    @Test
    @DisplayName("Test clearing the set")
    public void testClear() {
        setA.clear();
        assertTrue(setA.isEmpty());
    }

    @Test
    @DisplayName("Test getting the length of the set")
    public void testLength() {
        setA.add(1);
        setA.add(2);
        assertEquals(2, setA.length());
    }

    @Test
    @DisplayName("Test equality of two sets")
    public void testEquals() {
        setA.add(1);
        setA.add(2);
        setB.add(2);
        setB.add(1);
        assertTrue(setA.equals(setB));
    }

    @Test
    @DisplayName("Test if set contains a value")
    public void testContains() {
        setA.add(1);
        assertTrue(setA.contains(1));
        assertFalse(setA.contains(2));
    }

    @Test
    @DisplayName("Test getting the largest value in the set")
    public void testLargest() {
        assertThrows(IntegerSetException.class, () -> setA.largest());
    }

    @Test
    @DisplayName("Test getting the smallest value in the set")
    public void testSmallest() {
        assertThrows(IntegerSetException.class, () -> setA.smallest());
    }

    @Test
    @DisplayName("Test adding an item to the set")
    public void testAdd() {
        setA.add(1);
        assertTrue(setA.contains(1));
        assertFalse(setA.contains(2));
    }

    @Test
    @DisplayName("Test removing an item from the set")
    public void testRemove() {
        setA.add(1);
        assertTrue(setA.contains(1));
        setA.remove(1);
        assertFalse(setA.contains(1));
    }

    @Test
    @DisplayName("Test set union")
    public void testUnion() {
        setA.add(1);
        setB.add(2);
        setA.union(setB);
        assertTrue(setA.contains(1));
        assertTrue(setA.contains(2));
    }

    @Test
    @DisplayName("Test set intersection")
    public void testIntersect() {
        setA.add(1);
        setA.add(2);
        setB.add(2);
        setB.add(3);
        setA.intersect(setB);
        assertTrue(setA.contains(2));
        assertFalse(setA.contains(1));
        assertFalse(setA.contains(3));
    }

    @Test
    @DisplayName("Test set difference")
    public void testDiff() {
        setA.add(1);
        setA.add(2);
        setB.add(2);
        setB.add(3);
        setA.diff(setB);
        assertTrue(setA.contains(1));
        assertFalse(setA.contains(2));
    }

    @Test
    @DisplayName("Test set complement")
    public void testComplement() {
        setA.add(1);
        setA.add(2);
        setB.add(2);
        setB.add(3);
        setA.complement(setB);
        assertFalse(setA.contains(2));
        assertFalse(setA.contains(3));
    }

    @Test
    @DisplayName("Test if the set is empty")
    public void testIsEmpty() {
        assertTrue(setA.isEmpty());
        setA.add(1);
        assertFalse(setA.isEmpty());
    }

    @Test
    @DisplayName("Test string representation of the set")
    public void testToString() {
        setA.add(1);
        setA.add(2);
        assertEquals("[1, 2]", setA.toString());
    }
    
    @Test
    @DisplayName("Test operations with an empty set")
    public void testEmptySet() {
        // Test clearing an empty set
        setA.clear();
        assertTrue(setA.isEmpty());

        // Test getting the length of an empty set
        assertEquals(0, setA.length());

        // Test largest and smallest on an empty set
        assertThrows(IntegerSetException.class, () -> setA.largest());
        assertThrows(IntegerSetException.class, () -> setA.smallest());
    }

    @Test
    @DisplayName("Test operations with a single-element set")
    public void testSingleElementSet() {
        // Test adding a single element
        setA.add(5);
        assertEquals(1, setA.length());
        assertTrue(setA.contains(5));
        assertFalse(setA.contains(10)); // Ensure other elements are not present

        // Test removing a single element
        setA.remove(5);
        assertTrue(setA.isEmpty());
    }

    @Test
    @DisplayName("Test operations with duplicate elements")
    public void testDuplicateElements() {
        // Test adding duplicate elements
        setA.add(1);
        setA.add(2);
        setA.add(1); // Adding duplicate
        assertEquals(2, setA.length()); // Length should remain unchanged
    }

    @Test
    @DisplayName("Test method interactions")
    public void testMethodInteractions() {
        // Test adding and removing elements
        setA.add(1);
        setA.add(2);
        setA.remove(1);
        assertEquals(1, setA.length());
        assertFalse(setA.contains(1));
        assertTrue(setA.contains(2));

        // Test union of two sets
        setB.add(2);
        setB.add(3);
        setA.union(setB);
        assertEquals(2, setA.length());
        assertTrue(setA.contains(2));
        assertTrue(setA.contains(3));
    }

    @Test
    @DisplayName("Test exceptions")
    public void testExceptions() {
        // Test largest and smallest on an empty set
        assertThrows(IntegerSetException.class, () -> setA.largest());
        assertThrows(IntegerSetException.class, () -> setA.smallest());

        // Test removing an element not in the set
        assertDoesNotThrow(() -> setA.remove(100)); // No exception should be thrown
    }

    @Test
    @DisplayName("Test performance with large set")
    public void testPerformance() {
        // Test adding and removing a large number of elements
        for (int i = 0; i < 10000; i++) {
            setA.add(i);
        }
        assertEquals(10000, setA.length());

        for (int i = 0; i < 10000; i++) {
            setA.remove(i);
        }
        assertTrue(setA.isEmpty());
    }
}
