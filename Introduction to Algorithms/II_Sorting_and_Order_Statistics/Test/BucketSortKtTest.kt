import II_Sorting_and_Order_Statistics._8_Sorting_in_Linear_Time.bucketSort
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BucketSortKtTest {

    @Test
    fun test1() {
        val sortingList = mutableListOf(.42,.32,.33,.52,.37,.47,.51)
        val sortedList = sortingList.sorted()
        bucketSort(sortingList)
        assertEquals(sortedList, sortingList)
    }


    @Test
    fun orderedList() {
        val sortingList = mutableListOf(.1,.2,.3,.4,.5,.6,.7)
        val sortedList = mutableListOf(.1,.2,.3,.4,.5,.6,.7)
        bucketSort(sortingList)
        assertEquals(sortedList, sortingList)
    }

    @Test
    fun reversedList() {
        val sortingList = mutableListOf(.7,.6,.5,.4,.3,.2,.1)
        val sortedList = mutableListOf(.1,.2,.3,.4,.5,.6,.7)
        bucketSort(sortingList)
        assertEquals(sortedList, sortingList)
    }

    @Test
    fun singleValue() {
        val sortingList = mutableListOf(.1)
        val sortedList = mutableListOf(.1)

        bucketSort(sortingList)
        assertEquals(sortedList, sortingList)
    }

    @Test
    fun twoValues() {
        val sortingList = mutableListOf(.3,.2)
        val sortedList = mutableListOf(.2,.3)

        bucketSort(sortingList)
        assertEquals(sortedList, sortingList)
    }

    @Test
    fun emptyList(){
        val sortingList = mutableListOf<Double>()
        val sortedList = mutableListOf<Double>()

        bucketSort(sortingList)
        assertEquals(sortedList, sortingList)
    }

    @Test
    fun zeroList(){
        val sortingList = mutableListOf(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0)
        val sortedList = mutableListOf(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0)

        bucketSort(sortingList)
        assertEquals(sortedList, sortingList)
    }

    @Test
    fun sameValueList(){
        val sortingList = mutableListOf<Double>(.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5)
        val sortedList = mutableListOf<Double>(.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5)

        bucketSort(sortingList)
        assertEquals(sortedList, sortingList)
    }
}