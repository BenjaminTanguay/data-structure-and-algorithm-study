Feature: Radix sort should sort an array

  Scenario: Radix sort should sort an array

    Given an array is populated with the values
      | 170 |
      | 45  |
      | 75  |
      | 90  |
      | 802 |
      | 24  |
      | 2   |
      | 66  |

    When the array is sorted by the radix sort algorithm

    Then the resulting array should be
      | 2   |
      | 24  |
      | 45  |
      | 66  |
      | 75  |
      | 90  |
      | 170 |
      | 802 |