package org.assignment;

import java.util.Arrays;

/**
 * The ArraysComparator class contain methods for arrays comparisons.
 */
public class ArraysComparator {

    /**
     * Returns true if the two specified arrays of integer are similar to one another.
     * Two arrays are considered similar if both arrays include all elements without respect to order.
     * Also, two array references are considered similar if both are null.
     *
     * @param array1 one array to be tested for equality
     * @param array2 the other array to be tested for equality
     * @return true if the two arrays are similar, otherwise - false
     * @implNote sorts both arrays then compares elements one by one.
     */
    public static boolean similar(int[] array1, int[] array2) {
        if (array1 == null && array2 == null) {
            return true;
        } else if (array1 != null && array2 != null && array1.length == array2.length) {
            Arrays.sort(array1);
            Arrays.sort(array2);
            for (int i = 0; i < array1.length; i++) {
                if (array1[i] != array2[i]) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}