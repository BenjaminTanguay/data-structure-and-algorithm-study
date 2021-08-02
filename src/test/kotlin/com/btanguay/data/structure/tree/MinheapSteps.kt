package com.btanguay.data.structure.tree

import com.google.inject.Inject
import com.btanguay.core.log.logger
import io.cucumber.guice.ScenarioScoped
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.cucumber.java8.En
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`


@ScenarioScoped
class MinheapSteps @Inject constructor(private val minHeap: MinHeap) : En {

    val log = logger();

    lateinit var order: List<Int>;


    @Given("A min heap is populated with values")
    fun `A min heap is populated with values`(list: List<Int>) {
        list.forEach { minHeap.insert(it) }
    }

    @When("I traverse the heap in order")
    fun `I traverse the heap in order`() {
        order = minHeap.inOrder()
    }

    @When("I traverse the heap in pre-order")
    fun `I traverse the heap in pre-order`() {
        order = minHeap.preOrder()
    }

    @When("I traverse the heap in post-order")
    fun `I traverse the heap in post-order`() {
        order = minHeap.postOrder()
    }

    @When("A min heap is populated in a random order with values")
    fun `A min heap is populated in a random order with values`(list: List<Int>) {
        list.shuffled()
            .forEach { minHeap.insert(it) }
    }

    @When("{int} is added to the heap")
    fun `{int} is added to the heap`(value: Int) {
        minHeap.insert(value)
    }

    @Then("I should get the nodes in the order")
    fun `I should get the nodes in the order`(expected: List<Int>) {
        assertThat(order, `is`(expected))
    }

    @Then("values should be extracted in this order")
    fun `values should be extracted in this order`(expected: List<Int>) {
        val actual: MutableList<Int> = mutableListOf()
        while (!minHeap.isEmpty()) {
            actual.add(minHeap.extractMin())
        }
        assertThat(actual, `is`(expected))
    }

    @Then("the heap should be empty after")
    fun `the heap should be empty after`() {
        assertThat(minHeap.inOrder().isEmpty(), `is`(true))
    }

}