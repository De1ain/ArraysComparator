package org.assignment.cucumber;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java8.En;

import org.assignment.ArraysComparator;
import org.assignment.Utils;

public class CucumberStepdefs implements En {

    private int[] array1 = null;
    private int[] array2 = null;
    private boolean result;

    public CucumberStepdefs() {

        ParameterType("arrayOfIntegers", "\"([^\"]*)\"", (String numbers) -> {
            if (numbers.length() > 0) {
                return Arrays.stream(numbers.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            } else {
                return null;
            }
        });

        Given("{arrayOfIntegers} and {arrayOfIntegers}", (int[] arr1, int[] arr2) -> {
            array1 = arr1;
            array2 = arr2;
        });

        When("^compare the arrays for similarity$", () -> {
            result = ArraysComparator.similar(array1, array2);
        });

        Then("^similarity method should return true$", () -> {
            assertTrue(result);
        });

        Then("^similarity method should return false$", () -> {
            assertFalse(result);
        });

        Given("array {arrayOfIntegers}", (int[] arr1) -> {
            array1 = arr1;
        });

        And("^the second array duplicated from the first one$", () -> {
            array2 = array1.clone();
        });

        And("^the second array shuffled$", () -> {
            Utils.shuffleArray(array2);
        });

        Given("^randomly populated array of length (\\d+)$", (Integer length) -> {
            array1 = Utils.createArrayWithRandomNumbers(length);
        });

        And("^another randomly populated array of length (\\d+)$", (Integer length) -> {
            array2 = Utils.createArrayWithRandomNumbers(length);
        });

        When("^I perform test run no\\.: \"([^\"]*)\"$", (String arg0) -> {
        });

        And("^elements in both arrays at index (\\d+) set to different integers to make sure the arrays are different$", (Integer idx) -> {
            array1[idx] = 5;
            array2[idx] = 9;
        });

        Given("^sorted array populated with consecutive numbers of length (\\d+)$", (Integer length) -> {
            array1 = Utils.createArrayWithConsecutivePositiveNumbers(length);
        });

        And("^the second array reverse-sorted$", () -> {
            Utils.reverseArray(array2);
        });
    }
}
