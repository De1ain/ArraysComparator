Feature: Arrays Long Tests

  Scenario: Test similar, long, randomly populated arrays of same length
    Given randomly populated array of length 1000
    And the second array duplicated from the first one
    And the second array shuffled
    When compare the arrays for similarity
    Then similarity method should return true

  Scenario Outline: Test different, long, randomly populated, arrays of same length
    Given randomly populated array of length 1000
    And another randomly populated array of length 1000
    When I perform test run no.: "<runNum>"
    And elements in both arrays at index 739 set to different integers to make sure the arrays are different
    And compare the arrays for similarity
    Then similarity method should return false
    Examples: Run number
      | runNum |
      | run1   |
      | run2   |
      | run3   |
      | run4   |
      | run5   |

  Scenario: Test similar, very long, randomly populated arrays
    Given randomly populated array of length 1000000
    And the second array duplicated from the first one
    And the second array shuffled
    When compare the arrays for similarity
    Then similarity method should return true

  Scenario: Test similar, extremely long, randomly populated arrays
    Given randomly populated array of length 10000000
    And the second array duplicated from the first one
    And the second array shuffled
    When compare the arrays for similarity
    Then similarity method should return true

  Scenario: Test similar, long, sorted and reverse-sorted arrays
    Given sorted array populated with consecutive numbers of length 100000
    And the second array duplicated from the first one
    And the second array reverse-sorted
    When compare the arrays for similarity
    Then similarity method should return true
