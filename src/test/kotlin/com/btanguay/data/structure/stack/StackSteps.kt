package com.btanguay.data.structure.stack

import com.google.inject.Inject
import io.cucumber.guice.ScenarioScoped
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat

@ScenarioScoped
class StackSteps @Inject constructor(private val stack: Stack<Int>) {

    private var peekedValue: Int = -100000
    private lateinit var valuesPopped: MutableList<Int>

    @Given("a stack is successively populated with values")
    fun `a stack is successively populated with values`(list: List<Int>) {
        list.forEach { stack.push(it) }
    }

    @When("we pop the stack until it is empty and store all the values in a list")
    fun `we pop the stack until it is empty and store all the values in a list`() {
        valuesPopped = ArrayList();
        while (!stack.isEmpty) {
            valuesPopped.add(stack.pop())
        }
    }

    @When("we peek the top element")
    fun `we peek the top element`() {
        peekedValue = stack.peek()
    }

    @Then("the list should follow the order")
    fun `the list should follow the order`(list: List<Int>) {
        assertThat(list, `is`(valuesPopped))
    }

    @Then("the value peeked off the stack should be {int}")
    fun `the value peeked off the stack should be`(expected: Int) {
        assertThat(peekedValue, `is`(expected))
    }

    @Then("the stack size should be {int}")
    fun `the stack size should be`(expected: Int) {
        assertThat(stack.size(), `is`(expected))
    }
}