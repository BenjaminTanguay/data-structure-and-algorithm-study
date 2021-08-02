package com.btanguay.algorithm.search.binary

import com.google.inject.Inject
import io.cucumber.guice.ScenarioScoped
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat

@ScenarioScoped
class BinarySearchSteps @Inject constructor(private val binarySearch: BinarySearch){

    private var result: Int = -5

    @Given("a sorted array exists with values")
    fun `a sorted array exists with values`(list: List<Int>) {
        binarySearch.setArray(list)
    }

    @Given("an empty array")
    fun `an empty array`() {
        binarySearch.setArray(ArrayList())
    }

    @When("a binary search is performed for value {int}")
    fun `a binary search is performed for value`(value: Int) {
        result = binarySearch.search(value)
    }

    @Then("the index returned should be {int}")
    fun `the index returned should be`(value: Int) {
        assertThat(result, `is`(value))
    }

}