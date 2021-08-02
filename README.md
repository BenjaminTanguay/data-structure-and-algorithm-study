# Project purpose
This project's goal is to serve as a practice test bench for data-structure and algorithm implementation questions. The idea behind this is that to easily answer a data-structure and algorithm question, being able to easily implement any of the common structure is a pre-requisite. More often then not in programming, practice is required to master anything. Thus, the idea for this project was born.

# How to use
The project contains pre-defined interfaces and tests for some well known data structures and algorithm. The user that wants to practice implementing one of those elements simply needs to open one of the classes under com.btanguay, delete the content and reimplement it. The project was more design as a personal tool then something broadly used, although I wouldn't mind someone else using it to help them study.

The command used to launch the tests is the following:

```./gradlew :test --tests "com.btanguay.RunCucumberTest"```

# What is supported
## Data structures
- Graph
- Linked list
- Queue
- Stack
- Tree
  - AVL Tree
  - Binary search tree
  - Heap

## Algorithm
- Binary search
- Depth First
- Breath First
- Bucket Sort

# I plan on adding the following eventually:

## Data structures
- Red-Black trees

## Algorithm
- Bidirectional search
- Radix search
- Merge search
- Quick search

# Project Description
The implementation for the data-structures and algorithms was made in Java since this is the language that naturally comes to mind when I code. The tests were made with Kotlin because it is a language I've grown to love. I used cucumber to present the tests using a Gherkins syntax to make everything easier to read. I also had the idea of documenting important things to remember in the feature files although I havn't done it yet.