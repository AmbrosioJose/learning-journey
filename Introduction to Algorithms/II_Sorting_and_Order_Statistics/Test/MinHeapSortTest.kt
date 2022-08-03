package II_Sorting_and_Order_Statistics.Test

import II_Sorting_and_Order_Statistics.`6 HeapSort`.MinHeap
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*

internal class MinHeapSortTest {

    @org.junit.jupiter.api.Test
    fun test1() {
        val sortingList = mutableListOf(5,2,4,6,1,3)
        val sortedList = mutableListOf(1,2,3,4,5,6)

        MinHeap(sortingList).heapSort()
        assertEquals(sortedList, sortingList)
    }

    @org.junit.jupiter.api.Test
    fun test2() {
        val sortingList = mutableListOf(5,2,4,6,1,3,7)
        val sortedList = mutableListOf(1,2,3,4,5,6,7)

        MinHeap(sortingList).heapSort()
        Assertions.assertEquals(sortedList, sortingList)
    }

    @org.junit.jupiter.api.Test
    fun test3() {
        val sortingList = mutableListOf(-1,-2,-3,-6,-9,0,1,6)
        val sortedList = mutableListOf(-9,-6,-3,-2,-1,0,1,6)

        MinHeap(sortingList).heapSort()
        Assertions.assertEquals(sortedList, sortingList)
    }

    @org.junit.jupiter.api.Test
    fun orderedList() {
        val sortingList = mutableListOf(1,2,3,4,5,6,7)
        val sortedList = mutableListOf(1,2,3,4,5,6,7)

        MinHeap(sortingList).heapSort()
        Assertions.assertEquals(sortedList, sortingList)
    }

    @org.junit.jupiter.api.Test
    fun reversedList() {
        val sortingList = mutableListOf(7,6,5,4,3,2,1)
        val sortedList = mutableListOf(1,2,3,4,5,6,7)

        MinHeap(sortingList).heapSort()
        Assertions.assertEquals(sortedList, sortingList)
    }

    @org.junit.jupiter.api.Test
    fun singleValue() {
        val sortingList = mutableListOf(1)
        val sortedList = mutableListOf(1)

        MinHeap(sortingList).heapSort()
        assertEquals(sortedList, sortingList)
    }

    @org.junit.jupiter.api.Test
    fun twoValues() {
        val sortingList = mutableListOf(3,2)
        val sortedList = mutableListOf(2,3)

        MinHeap(sortingList).heapSort()
        assertEquals(sortedList, sortingList)
    }

    @org.junit.jupiter.api.Test
    fun emptyList(){
        val sortingList = mutableListOf<Int>()
        val sortedList = mutableListOf<Int>()

        MinHeap(sortingList).heapSort()
        assertEquals(sortedList, sortingList)
    }

    @org.junit.jupiter.api.Test
    fun zeroList(){
        val sortingList = mutableListOf<Int>(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
        val sortedList = mutableListOf<Int>(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)

        MinHeap(sortingList).heapSort()
        assertEquals(sortedList, sortingList)
    }

    @org.junit.jupiter.api.Test
    fun sameValueList(){
        val sortingList = mutableListOf<Int>(5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5)
        val sortedList = mutableListOf<Int>(5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5)

        MinHeap(sortingList).heapSort()
        assertEquals(sortedList, sortingList)
    }
}