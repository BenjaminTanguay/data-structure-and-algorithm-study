Feature: The binary search tree should keep an internal order where the left < center < right nodes.

  Scenario: All nodes in the binary search tree should maintain an order where left < center < right

    Given a binary search tree is populated in a random order with values
      | 2  |
      | 50 |
      | 23 |
      | 5  |
      | 5  |
      | 88 |
      | 90 |
      | 32 |
      | 74 |

    When the binary search tree is traversed in order

    Then the nodes should be seen in the order
      | 2  |
      | 5  |
      | 23 |
      | 32 |
      | 50 |
      | 74 |
      | 88 |
      | 90 |

  Scenario: All nodes in the binary search tree should maintain an order where left < center < right

    When a binary search tree is populated in a random order with values
      | 2  |
      | 50 |
      | 23 |
      | 5  |
      | 5  |
      | 88 |
      | 90 |
      | 32 |
      | 74 |

    Then the binary search tree should contain the nodes
      | 2  |
      | 50 |
      | 23 |
      | 5  |
      | 88 |
      | 90 |
      | 32 |
      | 74 |
    And the binary search tree should not contain the nodes
      | 3   |
      | 102 |
      | 37  |
      | 8   |

  Scenario: Traversal of the binary search tree in pre-order yields expected nodes

    Given a binary search tree is populated with values
      | 50  |
      | 90  |
      | 30  |
      | 15  |
      | 31  |
      | 30  |
      | 3   |
      | 110 |
      | 90  |

    # Expected tree:
    #              50
    #             / \
    #            /   \
    #           /     \
    #          30     90
    #         /  \      \
    #        15  31     110
    #         \
    #         3

    When I traverse the binary search tree in pre-order

    Then the nodes should be seen in the order
      | 50  |
      | 30  |
      | 15  |
      | 3   |
      | 31  |
      | 90  |
      | 110 |

  Scenario: Traversal of the binary search tree in post-order yields expected nodes

    Given a binary search tree is populated with values
      | 50  |
      | 90  |
      | 30  |
      | 15  |
      | 31  |
      | 30  |
      | 3   |
      | 110 |
      | 90  |

    # Expected tree:
    #              50
    #             / \
    #            /   \
    #           /     \
    #          30     90
    #         /  \      \
    #        15  31     110
    #         \
    #         3

    When I traverse the binary search tree in post-order

    Then the nodes should be seen in the order
      | 3   |
      | 15  |
      | 31  |
      | 30  |
      | 110 |
      | 90  |
      | 50  |