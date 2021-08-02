package com.btanguay.algorithm.sort

import com.google.inject.Inject
import com.btanguay.algorithm.sort.bucket.BucketSort
import com.btanguay.algorithm.sort.merge.MergeSort
import com.btanguay.algorithm.sort.quick.QuickSort
import com.btanguay.algorithm.sort.radix.RadixSort
import io.cucumber.guice.ScenarioScoped
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat

@ScenarioScoped
class SortSteps @Inject constructor(
    val bucketSort: BucketSort,
    val mergeSort: MergeSort,
    val quickSort: QuickSort,
    val radixSort: RadixSort
) {

    lateinit var array: IntArray


    @Given("an array is populated with the values")
    fun `an array is populated with the values`(list: List<Int>) {
        this.array = list.toIntArray()
    }

    @When("the array is sorted by the bucket sort algorithm")
    fun `the array is sorted by the bucket sort algorithm`() {
        this.array = bucketSort.sort(this.array)
    }

    @When("the array is sorted by the merge sort algorithm")
    fun `the array is sorted by the merge sort algorithm`() {
        this.array = mergeSort.sort(this.array)
    }

    @When("the array is sorted by the quick sort algorithm")
    fun `the array is sorted by the quick sort algorithm`() {
        this.array = quickSort.sort(this.array)
    }

    @When("the array is sorted by the radix sort algorithm")
    fun `the array is sorted by the radix sort algorithm`() {
        this.array = radixSort.sort(this.array)
    }

    @Then("the resulting array should be")
    fun `the resulting array should be`(expected: List<Int>) {
        assertThat(array.toList(), `is`(expected))
    }
}