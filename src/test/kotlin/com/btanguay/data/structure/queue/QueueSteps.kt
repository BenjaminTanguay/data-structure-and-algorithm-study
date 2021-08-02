package com.btanguay.data.structure.queue

import com.google.inject.Inject
import io.cucumber.guice.ScenarioScoped
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat

@ScenarioScoped
class QueueSteps @Inject constructor(private val queue: Queue<Int>) {

    private lateinit var valuesDequeued: MutableList<Int>

    @Given("a queue is successively populated with values")
    fun `a queue is successively populated with values`(list: List<Int>) {
        list.forEach { queue.enqueue(it) }
    }

    @When("we dequeue the queue until it is empty and store all the values in a list")
    fun `we dequeue the queue until it is empty and store all the values in a list`() {
        valuesDequeued = ArrayList();
        while (!queue.isEmpty) {
            valuesDequeued.add(queue.dequeue())
        }
    }

    @Then("the dequeued list should follow the order")
    fun `the dequeued list should follow the order`(list: List<Int>) {
        assertThat(list, `is`(valuesDequeued))
    }
}