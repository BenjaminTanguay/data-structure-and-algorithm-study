package com.btanguay.data.structure.linkedlist

import com.google.inject.Inject
import io.cucumber.guice.ScenarioScoped
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat

@ScenarioScoped
class LinkedListSteps @Inject constructor(private val linkedList: LinkedList<Int>) {

    @Given("a linked list is successively populated with values")
    fun `a linked list is successively populated with values`(list: List<Int>) {
        list.forEach { linkedList.addLast(it) }
    }

    @When("{int} is added at its head")
    fun `value is added at its head`(value: Int) {
        linkedList.addFirst(value)
    }

    @When("{int} is added at its tail")
    fun `value is added at its tail`(value: Int) {
        linkedList.addLast(value)
    }

    @When("the element at index {int} is removed")
    fun `the element at index is removed`(index: Int) {
        linkedList.remove(index)
    }

    @Then("the linked list should contain values")
    fun `the linked list should contain values`(list: List<Int>) {
        list.forEach { assertThat(linkedList.contains(it), `is`(true)) }
    }

    @Then("the linked list should not contain values")
    fun `the linked list should not contain values`(list: List<Int>) {
        list.forEach { assertThat(linkedList.contains(it), `is`(false)) }
    }

    @Then("the value at index {int} should be {int}")
    fun `the value at index should be`(index: Int, value: Int) {
        assertThat(linkedList.get(index), `is`(value))
    }
}