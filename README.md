# ArraysComparator Assignment
<i>By Timur Borodin</i>

## Description

The class <code>ArraysComparator</code> contains a static method - <code>similar</code> that tests 2 arrays for
similarity.

<b>Similarity</b> is defined as both arrays include all elements without respect to order.

## Run Configurations
- <b>JUnitTestSuite</b> - executes all JUnit5 tests
- <b>CucumberTestSuite</b> - executes all Cucumber tests

## Tests
- JUnit5 - <code>ArraysComparatorTest</code> class with tests
  - JUnitTestSuite - suite for running all JUnit5 tests
- Cucumber 
  - ArraysTests.feature - describes tests on short and simple arrays
  - ArraysLongTest.feature - describes tests on long and very long arrays
  - CucumberStepDefs - Cucumber Step Definitions for the 2 feature files
  - CucumberTestSuite - Suite for the 2 feature files
- Utils - Utility methods for tests
  - <code>createArrayWithRandomPositiveNumbers</code>
  - <code>createArrayWithRandomNumbers</code>
  - <code>shuffleArray</code>



## Tools and libraries used:

- Java 17
- Maven
- JUnit 5.9.0
- Cucumber 7.5.0

