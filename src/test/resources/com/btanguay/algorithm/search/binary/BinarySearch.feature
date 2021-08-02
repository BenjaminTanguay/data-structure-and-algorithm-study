Feature: The binary search finds a target in a sorted array in log(n) time

  Scenario: The binary search can find an element burried in the middle of the array

    Given a sorted array exists with values
      | 1      |
      | 4      |
      | 9      |
      | 11     |
      | 12     |
      | 45     |
      | 63     |
      | 128634 |

    When a binary search is performed for value 45

    Then the index returned should be 5

  Scenario: The binary search can find an element at the start of the array

    Given a sorted array exists with values
      | 1      |
      | 4      |
      | 9      |
      | 11     |
      | 12     |
      | 45     |
      | 63     |
      | 128634 |

    When a binary search is performed for value 1

    Then the index returned should be 0

  Scenario: The binary search can find an element at the end of the array

    Given a sorted array exists with values
      | 1      |
      | 4      |
      | 9      |
      | 11     |
      | 12     |
      | 45     |
      | 63     |
      | 128634 |

    When a binary search is performed for value 128634

    Then the index returned should be 7

  Scenario: The binary search returns -1 when a non existing value is entered

    Given a sorted array exists with values
      | 1      |
      | 4      |
      | 9      |
      | 11     |
      | 12     |
      | 45     |
      | 63     |
      | 128634 |

    When a binary search is performed for value 21

    Then the index returned should be -1

  Scenario: The binary search finds the value in an array of size 1

    Given a sorted array exists with values
      | 1      |

    When a binary search is performed for value 1

    Then the index returned should be 0

  Scenario: The binary search returns -1 when given an empty array

    Given an empty array

    When a binary search is performed for value 1

    Then the index returned should be -1