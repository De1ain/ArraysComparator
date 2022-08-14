Feature: Arrays Short Tests

  Scenario Outline: Test similar arrays of equal length
    Given "<array1>" and "<array2>"
    When compare the arrays for similarity
    Then similarity method should return true

    Examples:
      | array1      | array2      |
      | 1 2 3       | 3 2 1       |
      | 7 7 7       | 7 7 7       |
      |             |             |
      | 42          | 42          |
      | 0           | 0           |
      | -125        | -125        |
      | 999999999   | 999999999   |
      | 1 7 2 3 48  | 2 48 3 7 1  |
      | 1 6 2 3 4 6 | 2 3 1 6 6 4 |


  Scenario Outline: Test different arrays of same length
    Given "<array1>" and "<array2>"
    When compare the arrays for similarity
    Then similarity method should return false

    Examples:
      | array1  | array2  |
      | 3 1 1 2 | 1 3 2 3 |
      | 1 2 3   | 2 3 4   |
      | 87 3507 | 4 0     |
      | 32767   | -6782   |
      | 42      | 17      |

  Scenario Outline: Test arrays of different length
    Given "<array1>" and "<array2>"
    When compare the arrays for similarity
    Then similarity method should return false

    Examples:
      | array1  | array2  |
      | 1 2 3   | 2 3 1 4 |
      | 1 1 1   | 1       |
      | 87 3507 | 4       |
      | 32767   |         |
      | 32768   |         |

  Scenario Outline: Test similar shuffled arrays of small length
    Given array "<array>"
    And the second array duplicated from the first one
    And the second array shuffled
    When compare the arrays for similarity
    Then similarity method should return true

    Examples:
      | array                                                                |
      | 1 2 3 7 12 -234 123123 -1 0                                          |
      | 99 -1024 0 42 999999999 11111 987234201                              |
      | 32767                                                                |
      | 617283 -27 1231234 -99999 -2147483648 0 23253546 100 2147483647 -1 1 |
      | -2147483648 -5 -130 -1 -7382 -999999999 -51 -99 -10000               |
      | 2147483647                                                           |