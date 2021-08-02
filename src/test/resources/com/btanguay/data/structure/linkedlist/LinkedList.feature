Feature: The linked list should store values properly

  Scenario: The linked list internal integrity is correct

    When a linked list is successively populated with values
      | 3  |
      | 2  |
      | 5  |
      | 40 |
      | 10 |
      | 8  |
      | 1  |
      | 13 |

    Then the linked list should contain values
      | 13 |
      | 1  |
      | 8  |
      | 10 |
      | 40 |
      | 5  |
      | 2  |
      | 3  |
    And the linked list should not contain values
      | 14 |
      | 6  |
      | 9  |
      | 11 |
      | 35 |
      | 4  |
      | 11 |
      | 7  |
    And the value at index 0 should be 3
    And the value at index 1 should be 2
    And the value at index 2 should be 5
    And the value at index 3 should be 40
    And the value at index 4 should be 10
    And the value at index 5 should be 8
    And the value at index 6 should be 1
    And the value at index 7 should be 13

  Scenario: The linked list should allow to add elements at its head

    Given a linked list is successively populated with values
      | 3  |
      | 2  |
      | 5  |
      | 40 |
      | 10 |
      | 8  |
      | 1  |
      | 13 |

    When 9 is added at its head

    Then the value at index 0 should be 9
    And the value at index 1 should be 3
    And the value at index 2 should be 2
    And the value at index 3 should be 5
    And the value at index 4 should be 40
    And the value at index 5 should be 10
    And the value at index 6 should be 8
    And the value at index 7 should be 1
    And the value at index 8 should be 13

  Scenario: The linked list should allow to add elements at its tail

    Given a linked list is successively populated with values
      | 3  |
      | 2  |
      | 5  |
      | 40 |
      | 10 |
      | 8  |
      | 1  |
      | 13 |

    When 9 is added at its tail

    Then the value at index 0 should be 3
    And the value at index 1 should be 2
    And the value at index 2 should be 5
    And the value at index 3 should be 40
    And the value at index 4 should be 10
    And the value at index 5 should be 8
    And the value at index 6 should be 1
    And the value at index 7 should be 13
    And the value at index 8 should be 9

  Scenario: The linked list should preserve its integrity after removing elements

    Given a linked list is successively populated with values
      | 3  |
      | 2  |
      | 5  |
      | 40 |
      | 10 |
      | 8  |
      | 1  |
      | 13 |

    When the element at index 3 is removed

    Then the value at index 0 should be 3
    And the value at index 1 should be 2
    And the value at index 2 should be 5
    And the value at index 3 should be 10
    And the value at index 4 should be 8
    And the value at index 5 should be 1
    And the value at index 6 should be 13

  Scenario: The linked list should preserve its integrity after removing its head

    Given a linked list is successively populated with values
      | 3  |
      | 2  |
      | 5  |
      | 40 |
      | 10 |
      | 8  |
      | 1  |
      | 13 |

    When the element at index 0 is removed

    Then the value at index 0 should be 2
    And the value at index 1 should be 5
    And the value at index 2 should be 40
    And the value at index 3 should be 10
    And the value at index 4 should be 8
    And the value at index 5 should be 1
    And the value at index 6 should be 13

