Feature: The MinHeap should have an internal order where the upper nodes are smaller then the child nodes.

  Scenario: The heap returns the expected in order nodes when populated

    Given A min heap is populated with values
      | 2  |
      | 50 |
      | 23 |
      | 88 |
      | 90 |
      | 32 |
      | 74 |
    # Expected tree:
    #              2
    #             / \
    #            /   \
    #           /     \
    #          50     23
    #         /  \   /  \
    #        88  90 32  74


    When I traverse the heap in order

    Then I should get the nodes in the order
      | 88 |
      | 50 |
      | 90 |
      | 2  |
      | 32 |
      | 23 |
      | 74 |

  Scenario: The heap returns the expected pre-order nodes when populated

    Given A min heap is populated with values
      | 2  |
      | 50 |
      | 23 |
      | 88 |
      | 90 |
      | 32 |
      | 74 |
    # Expected tree:
    #              2
    #             / \
    #            /   \
    #           /     \
    #          50     23
    #         /  \   /  \
    #        88  90 32  74


    When I traverse the heap in pre-order

    Then I should get the nodes in the order
      | 2  |
      | 50 |
      | 88 |
      | 90 |
      | 23 |
      | 32 |
      | 74 |

  Scenario: The heap returns the expected post-order nodes when populated

    Given A min heap is populated with values
      | 2  |
      | 50 |
      | 23 |
      | 88 |
      | 90 |
      | 32 |
      | 74 |
    # Expected tree:
    #              2
    #             / \
    #            /   \
    #           /     \
    #          50     23
    #         /  \   /  \
    #        88  90 32  74


    When I traverse the heap in post-order

    Then I should get the nodes in the order
      | 88 |
      | 90 |
      | 50 |
      | 32 |
      | 74 |
      | 23 |
      | 2  |

  Scenario: The heap returns elements from smallest to largest when populated in a random order

    When A min heap is populated in a random order with values
      | 2  |
      | 50 |
      | 23 |
      | 88 |
      | 90 |
      | 32 |
      | 74 |
    # Expected tree:
    #              2
    #             / \
    #            /   \
    #           /     \
    #          50     23
    #         /  \   /  \
    #        88  90 32  74

    Then values should be extracted in this order
      | 2  |
      | 23 |
      | 32 |
      | 50 |
      | 74 |
      | 88 |
      | 90 |
    And the heap should be empty after

  Scenario: A new element added to the heap take its expected position

    Given A min heap is populated with values
      | 4  |
      | 50 |
      | 7  |
      | 55 |
      | 90 |
    # Expected tree:
    #              4
    #             / \
    #            /   \
    #           /     \
    #          50     7
    #         /  \
    #        55  90

    When 2 is added to the heap
    And I traverse the heap in order

    Then I should get the nodes in the order
      | 55 |
      | 50 |
      | 90 |
      | 2  |
      | 7  |
      | 4  |
    # Expected tree:
    #              2
    #             / \
    #            /   \
    #           /     \
    #          50     4
    #         /  \   /
    #        55  90 7