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
class AVLTreeSteps @Inject constructor(private val avlTree: AVLTree) : En {

    val log = logger();

    lateinit var order: List<Int>;


    @Given("an AVL tree is populated in order with values")
    fun `an AVL tree is populated in order with values`(list: List<Int>) {
        list.forEach { avlTree.insert(it) }
    }

    @When("the AVL tree is traversed in order")
    fun `the AVL tree is traversed in order`() {
        order = avlTree.inOrder()
    }

    @Then("the nodes in the AVL tree should be traversed in the order")
    fun `the nodes in the AVL tree should be traversed in the order`(expected: List<Int>) {
        assertThat(order, `is`(expected))
    }

}