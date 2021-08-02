package com.btanguay.algorithm.search.depthfirst

import com.google.inject.Inject
import com.btanguay.algorithm.search.common.GraphSteps
import io.cucumber.guice.ScenarioScoped
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat

@ScenarioScoped
class DepthFirstSteps @Inject constructor(
    val depthFirstSearch: DepthFirstSearch,
    val graphSteps: GraphSteps) {

    lateinit var results: List<Int>

    @When("the graph is traversed in a depth first manner")
    fun `the graph is traversed in a depth first manner`() {
        this.results = depthFirstSearch.search(graphSteps.graphRoot)
    }

    @Then("the depth first search should yield nodes in the order")
    fun `the depth first search should yield nodes in the order`(expected: List<Int>) {
        assertThat(results, `is`(expected))
    }
}