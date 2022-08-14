package org.assignment;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ArraysComparatorTest {

    @Test
    @DisplayName("Test different length arrays")
    public void testDifferentLengthArrays() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {2, 3, 1, 4};
        assertFalse(ArraysComparator.similar(array1, array2));
    }

    @Test
    @DisplayName("Test same length different arrays with repeating numbers")
    public void testDifferentArraysWithRepeatingNumbers() {
        int[] array1 = {3, 1, 1, 2};
        int[] array2 = {1, 3, 2, 3};
        assertFalse(ArraysComparator.similar(array1, array2));
    }

    @Test
    @DisplayName("Test same length arrays with different numbers")
    public void testSameLengthDifferentArrays() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {2, 3, 4};
        assertFalse(ArraysComparator.similar(array1, array2));
    }

    @Test
    @DisplayName("Test same length similar arrays")
    public void testSameLengthSimilarArrays() {
        int[] array1 = {1, 7, 2, 3, 48};
        int[] array2 = {2, 48, 3, 7, 1};
        assertTrue(ArraysComparator.similar(array1, array2));
    }

    @Test
    @DisplayName("Test same length similar arrays with repeating numbers")
    public void testSameLengthSimilarArraysWithRepeatingNumbers() {
        int[] array1 = {1, 6, 2, 3, 4, 6};
        int[] array2 = {2, 3, 1, 6, 6, 4};
        assertTrue(ArraysComparator.similar(array1, array2));
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    @DisplayName("Test both null arrays")
    public void testTwoNullArrays() {
        int[] array1 = null;
        int[] array2 = null;
        assertTrue(ArraysComparator.similar(array1, array2));
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    @DisplayName("Test one null array and the other with numbers")
    public void testOneNullArray() {
        int[] array1 = {7, 6, 5};
        int[] array2 = null;
        assertFalse(ArraysComparator.similar(array1, array2));
    }

    @Test
    @DisplayName("Test same length and similar arrays (copied), second array shuffled")
    public void testSimilarArraysWithHugeNumbers() {
        int[] array1 = {617283, -27, Integer.MIN_VALUE, 1231234, -99999, -2147483648, 0, 23253546, 100, 2147483647, -1, 1, Integer.MAX_VALUE};
        int arrayLength = array1.length;
        int[] array2;

        array2 = array1.clone();
        Utils.shuffleArray(array2);

        assertTrue(ArraysComparator.similar(array1, array2));
    }

    @Test
    @DisplayName("Test same length and similar arrays with weirdly formatted numbers")
    public void testArraysWithWeirdlyFormattedNumbers() {
        int[] array1 = {01, 5 * 3, 002, -00007, +66, 22 / 2};
        int[] array2 = {002, -00007, 1 * 15, 01, 22 / 2, +66};
        assertTrue(ArraysComparator.similar(array1, array2));
    }

    @Test
    @DisplayName("Test same length and similar arrays (copied) with only negative numbers, second array shuffled")
    public void testSimilarArraysWithAllNegativeNumbers() {
        int[] array1 = {Integer.MIN_VALUE, -5, -130, -1, -7382, -999999999, -51, -99, -10000};
        int arrayLength = array1.length;
        int[] array2;

        array2 = array1.clone();
        Utils.shuffleArray(array2);

        assertTrue(ArraysComparator.similar(array1, array2));
    }

    @Test
    @DisplayName("Test arrays of 1 same number in each array")
    public void testEqualArraysLength1() {
        int[] array1 = {42};
        int[] array2 = {42};
        assertTrue(ArraysComparator.similar(array1, array2));
    }

    @Test
    @DisplayName("Test arrays of 1 different number in each array")
    public void testDifferentArraysLength1() {
        int[] array1 = {42};
        int[] array2 = {17};
        assertFalse(ArraysComparator.similar(array1, array2));
    }

    @Nested
    @DisplayName("Tests using long and very long arrays")
    public class BigArrays {

        @Test
        @DisplayName("Test long (1000 elems) similar and randomly populated arrays")
        public void testLongSimilarRandomArrays() {
            int arrayLength = 1000;
            int[] array1 = Utils.createArrayWithRandomNumbers(arrayLength);
            int[] array2;

            array2 = array1.clone();
            Utils.shuffleArray(array2);

            assertTrue(ArraysComparator.similar(array1, array2));
        }

        @RepeatedTest(5)
        @DisplayName("Test long (1000 elems) different and randomly populated arrays, 5 times")
        public void testLongDifferentRandomArrays() {
            int arrayLength = 1000;
            int[] array1 = Utils.createArrayWithRandomNumbers(arrayLength);
            int[] array2 = Utils.createArrayWithRandomPositiveNumbers(arrayLength);

            array1[552] = 2;
            array2[552] = 7;

            assertFalse(ArraysComparator.similar(array1, array2));
        }

        @Test
        @DisplayName("Test very long (1M elems) similar randomly populated arrays")
        public void testVeryLongSimilarRandomArrays() {
            int arrayLength = 1000000; // 1M
            int[] array1 = Utils.createArrayWithRandomNumbers(arrayLength);
            int[] array2;

            array2 = array1.clone();
            Utils.shuffleArray(array2);

            assertTrue(ArraysComparator.similar(array1, array2));
        }

        @Test
        @Timeout(value = 5000, unit = TimeUnit.MILLISECONDS)
        @DisplayName("Test extremely long (10M elems) similar randomly populated arrays")
        public void testExtremelyLongSimilarRandomArrays() {
            int arrayLength = 10000000; // 10M
            int[] array1 = Utils.createArrayWithRandomNumbers(arrayLength);
            int[] array2;

            array2 = array1.clone();
            Utils.shuffleArray(array2);

            assertTrue(ArraysComparator.similar(array1, array2));
        }

        @Test
        @DisplayName("Test very long (1M elems) similar sorted and reversed arrays")
        public void testVeryLongSimilarSortedAndReversedArrays() {
            int arrayLength = 1000000; // 1M
            int[] array1 = Utils.createArrayWithConsecutivePositiveNumbers(arrayLength);
            int[] array2;

            array2 = array1.clone();
            Utils.reverseArray(array2);

            assertTrue(ArraysComparator.similar(array1, array2));
        }
    }
}