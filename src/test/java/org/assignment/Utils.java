package org.assignment;

/**
 * The Utils class contain utility methods for tests.
 */
public class Utils {

    /**
     * Generates an array of length {@code length} populated with consecutive positive numbers.
     *
     * @param length length of the array to be generated
     * @return array populated with consecutive positive numbers
     */
    public static int[] createArrayWithConsecutivePositiveNumbers(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = i;
        }
        return array;
    }

    /**
     * Generates an array of length {@code length} populated with randomly generated positive numbers.
     *
     * @param length length of the array to be generated
     * @return array populated with randomly generated positive numbers
     */
    public static int[] createArrayWithRandomPositiveNumbers(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * length);
        }
        return array;
    }

    /**
     * Generates an array of length {@code length} populated with randomly generated numbers.
     *
     * @param length length of the array to be generated
     * @return array populated with randomly generated numbers
     */
    public static int[] createArrayWithRandomNumbers(int length) {
        int[] array = new int[length];
        int max = length;
        int min = -length;
        for (int i = 0; i < length; i++) {
            array[i] = (int) Math.floor(Math.random() * (max - min + 1) + min);
        }
        return array;
    }

    /**
     * Shuffles the array.
     *
     * @param array the array to shuffle
     */
    public static void shuffleArray(int[] array) {
        int randomIdx = 0;
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            randomIdx = (int) (Math.random() * array.length);
            temp = array[i];
            array[i] = array[randomIdx];
            array[randomIdx] = temp;
        }
    }

    /**
     * Reverses the array.
     *
     * @param array the array to reverse
     */
    public static void reverseArray(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            temp = array[array.length - 1 - i];
            array[array.length - 1 - i] = array[i];
            array[i] = temp;
        }
    }
}
