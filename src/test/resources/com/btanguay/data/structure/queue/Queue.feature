Feature: The queue should store values in a FIFO (First in first out) order

  Scenario: The queue respect the FIFO internal storing order

    Given a queue is successively populated with values
      | 3  |
      | 2  |
      | 5  |
      | 40 |
      | 10 |
      | 8  |
      | 1  |
      | 13 |

    When we dequeue the queue until it is empty and store all the values in a list

    Then the dequeued list should follow the order
      | 3  |
      | 2  |
      | 5  |
      | 40 |
      | 10 |
      | 8  |
      | 1  |
      | 13 |