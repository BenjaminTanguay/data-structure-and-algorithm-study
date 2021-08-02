Feature: A graph should be traversed in a breath first manner

  Scenario: A graph should be traversed in a breath first manner

    Given a graph exists with nodes linked in the following order
    | 0 | 1 |
    | 0 | 4 |
    | 0 | 5 |
    | 1 | 3 |
    | 1 | 4 |
    | 3 | 2 |
    | 3 | 4 |
    | 2 | 1 |

    When the graph is traversed in a breath first manner

    Then the breath first search should yield nodes in the order
    | 0 |
    | 1 |
    | 4 |
    | 5 |
    | 3 |
    | 2 |