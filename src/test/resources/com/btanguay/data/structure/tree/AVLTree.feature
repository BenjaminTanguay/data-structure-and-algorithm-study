Feature: The AVL tree should keep an internal order where the left < center < right nodes and the tree should stay balanced on insertion.

  Scenario: All nodes in the AVL tree should maintain an order where left < center < right

    Given an AVL tree is populated in order with values
      | 13 |
      | 14 |
      | 15 |
      | 12 |
      | 11 |
      | 17 |
      | 16 |
      | 8  |
      | 9  |
      | 1  |

    When the AVL tree is traversed in order

    Then the nodes in the AVL tree should be traversed in the order
      | 1  |
      | 8  |
      | 9  |
      | 11 |
      | 12 |
      | 13 |
      | 14 |
      | 15 |
      | 16 |
      | 17 |