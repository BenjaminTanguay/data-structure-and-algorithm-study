Feature: The stack should store values in a LIFO (Last in first out) order

  Scenario: The stack respect the LIFO internal storing order

    Given a stack is successively populated with values
      | 3  |
      | 2  |
      | 5  |
      | 40 |
      | 10 |
      | 8  |
      | 1  |
      | 13 |

    When we pop the stack until it is empty and store all the values in a list

    Then the list should follow the order
      | 13 |
      | 1  |
      | 8  |
      | 10 |
      | 40 |
      | 5  |
      | 2  |
      | 3  |

  Scenario: The peek function shouldn't remove elements off the stack

    Given a stack is successively populated with values
      | 3  |
      | 2  |
      | 5  |

    When we peek the top element

    Then the value peeked off the stack should be 5
    And the stack size should be 3