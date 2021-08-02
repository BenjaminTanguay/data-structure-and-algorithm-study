package com.btanguay.algorithm.search.breathfirst

import com.google.inject.Inject
import com.btanguay.algorithm.search.common.GraphSteps
import io.cucumber.guice.ScenarioScoped
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat

@ScenarioScoped
class BreathFirstSteps @Inject constructor(
    val breathFirstSearch: BreathFirstSearch,
    val graphSteps: GraphSteps) {

    lateinit var results: List<Int>

    @When("the graph is traversed in a breath first manner")
    fun `the graph is traversed in a breath first manner`() {
        this.results = breathFirstSearch.search(graphSteps.graphRoot)
    }

    @Then("the breath first search should yield nodes in the order")
    fun `the breath first search should yield nodes in the order`(expected: List<Int>) {
        assertThat(results, `is`(expected))
    }
}