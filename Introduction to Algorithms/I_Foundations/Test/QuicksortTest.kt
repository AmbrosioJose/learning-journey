package I_Foundations.Test

import I_Foundations.`7 Quicksort`.quicksort
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


internal class QuicksortTest {

    @Test
    fun test1() {
        val sortingList = mutableListOf(5,2,4,6,1,3)
        val sortedList = mutableListOf(1,2,3,4,5,6)

        quicksort(sortingList)
        Assertions.assertEquals(sortedList, sortingList)
    }

    @Test
    fun test2() {
        val sortingList = mutableListOf(5,2,4,6,1,3,7)
        val sortedList = mutableListOf(1,2,3,4,5,6,7)

        quicksort(sortingList)
        Assertions.assertEquals(sortedList, sortingList)
    }

    @Test
    fun test3() {
        val sortingList = mutableListOf(-1,-2,-3,-6,-9,0,1,6)
        val sortedList = mutableListOf(-9,-6,-3,-2,-1,0,1,6)

        quicksort(sortingList)
        Assertions.assertEquals(sortedList, sortingList)
    }

    @Test
    fun orderedList() {
        val sortingList = mutableListOf(1,2,3,4,5,6,7)
        val sortedList = mutableListOf(1,2,3,4,5,6,7)

        quicksort(sortingList)
        Assertions.assertEquals(sortedList, sortingList)
    }

    @Test
    fun reversedList() {
        val sortingList = mutableListOf(7,6,5,4,3,2,1)
        val sortedList = mutableListOf(1,2,3,4,5,6,7)

        quicksort(sortingList)
        Assertions.assertEquals(sortedList, sortingList)
    }

    @Test
    fun singleValue() {
        val sortingList = mutableListOf(1)
        val sortedList = mutableListOf(1)

        quicksort(sortingList)
        Assertions.assertEquals(sortedList, sortingList)
    }

    @Test
    fun twoValues() {
        val sortingList = mutableListOf(3,2)
        val sortedList = mutableListOf(2,3)

        quicksort(sortingList)
        Assertions.assertEquals(sortedList, sortingList)
    }

    @Test
    fun emptyList(){
        val sortingList = mutableListOf<Int>()
        val sortedList = mutableListOf<Int>()

        quicksort(sortingList)
        Assertions.assertEquals(sortedList, sortingList)
    }

    @Test
    fun zeroList(){
        val sortingList = mutableListOf<Int>(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
        val sortedList = mutableListOf<Int>(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)

        quicksort(sortingList)
        Assertions.assertEquals(sortedList, sortingList)
    }

    @Test
    fun sameValueList(){
        val sortingList = mutableListOf<Int>(5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5)
        val sortedList = mutableListOf<Int>(5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5)

        quicksort(sortingList)
        Assertions.assertEquals(sortedList, sortingList)
    }
}