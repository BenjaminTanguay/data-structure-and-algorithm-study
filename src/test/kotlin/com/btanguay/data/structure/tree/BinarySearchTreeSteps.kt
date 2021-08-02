package com.btanguay.data.structure.tree

import com.google.inject.Inject
import io.cucumber.guice.ScenarioScoped
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.cucumber.java8.En
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat

@ScenarioScoped
class BinarySearchTreeSteps @Inject constructor(private val binarySearchTree: BinarySearchTree): En {

    lateinit var order: List<Int>

    @Given("a binary search tree is populated with values")
    fun `a binary search tree is populated with values`(list: List<Int>) {
        list.forEach { binarySearchTree.insert(it) }
    }

    @Given("a binary search tree is populated in a random order with values")
    fun `given a binary search tree is populated in a random order with values`(list: List<Int>) {
        list.shuffled()
            .forEach { binarySearchTree.insert(it) }
    }

    @When("the binary search tree is traversed in order")
    fun `the binary search tree is traversed in order`() {
        order = binarySearchTree.inOrder()
    }

    @When("I traverse the binary search tree in pre-order")
    fun `I traverse the binary search tree in pre-order`() {
        order = binarySearchTree.preOrder()
    }

    @When("I traverse the binary search tree in post-order")
    fun `I traverse the binary search tree in post-order`() {
        order = binarySearchTree.postOrder()
    }

    @Then("the nodes should be seen in the order")
    fun `the nodes should be seen in the order`(expected: List<Int>) {
        assertThat(order, `is`(expected))
    }

    @Then("the binary search tree should contain the nodes")
    fun `the binary search tree should contain the nodes`(contains: List<Int>) {
        contains.forEach { assertThat(binarySearchTree.contains(it), `is`(true)) }
    }

    @Then("the binary search tree should not contain the nodes")
    fun `the binary search tree should not contain the nodes`(notContains: List<Int>) {
        notContains.forEach { assertThat(binarySearchTree.contains(it), `is`(false)) }
    }

}