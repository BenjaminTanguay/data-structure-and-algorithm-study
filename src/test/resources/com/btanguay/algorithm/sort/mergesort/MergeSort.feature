Feature: Merge sort should sort an array

  Scenario: Merge sort should sort an array

    Given an array is populated with the values
      | 7 |
      | 4 |
      | 9 |
      | 0 |
      | 2 |
      | 1 |
      | 8 |
      | 5 |
      | 3 |
      | 6 |
      | 4 |

    When the array is sorted by the merge sort algorithm

    Then the resulting array should be
      | 0 |
      | 1 |
      | 2 |
      | 3 |
      | 4 |
      | 4 |
      | 5 |
      | 6 |
      | 7 |
      | 8 |
      | 9 |