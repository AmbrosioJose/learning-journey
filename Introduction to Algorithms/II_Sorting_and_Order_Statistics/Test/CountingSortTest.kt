package II_Sorting_and_Order_Statistics.Test

import II_Sorting_and_Order_Statistics.`8 Sorting in Linear Time`.countingSort
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


internal class CountingSortTest {

    @Test
    fun test1() {
        val sortingList = mutableListOf(5,2,4,6,1,3)
        val sortedList = mutableListOf(1,2,3,4,5,6)

        Assertions.assertEquals(sortedList, countingSort(sortingList, 6))
    }

    @Test
    fun test2() {
        val sortingList = mutableListOf(5,2,4,6,1,3,7)
        val sortedList = mutableListOf(1,2,3,4,5,6,7)

        Assertions.assertEquals(sortedList, countingSort(sortingList, 7))
    }

    @Test
    fun test3() {
        val sortingList = mutableListOf(5,2,6,4,6,1,3,9,1)
        val sortedList = mutableListOf(1,1,2,3,4,5,6,6,9)

        Assertions.assertEquals(sortedList, countingSort(sortingList, 9))
    }

    @Test
    fun test4() {
        val sortingList = mutableListOf(5,2,4,6,1,3,3,1000)
        val sortedList = mutableListOf(1,2,3,3,4,5,6,1000)

        Assertions.assertEquals(sortedList, countingSort(sortingList, 1000))
    }

    @Test
    fun orderedList() {
        val sortingList = mutableListOf(1,2,3,4,5,6,7)
        val sortedList = mutableListOf(1,2,3,4,5,6,7)

        Assertions.assertEquals(sortedList, countingSort(sortingList, 7))
    }

    @Test
    fun reversedList() {
        val sortingList = mutableListOf(7,6,5,4,3,2,1)
        val sortedList = mutableListOf(1,2,3,4,5,6,7)

        Assertions.assertEquals(sortedList, countingSort(sortingList, 7))
    }

    @Test
    fun singleValue() {
        val sortingList = mutableListOf(1)
        val sortedList = mutableListOf(1)

        Assertions.assertEquals(sortedList, countingSort(sortingList, 1))
    }

    @Test
    fun twoValues() {
        val sortingList = mutableListOf(3,2)
        val sortedList = mutableListOf(2,3)

        Assertions.assertEquals(sortedList, countingSort(sortingList, 3))
    }

    @Test
    fun emptyList(){
        val sortingList = mutableListOf<Int>()
        val sortedList = mutableListOf<Int>()

        Assertions.assertEquals(sortedList, countingSort(sortingList, 0))
    }

    @Test
    fun zeroList(){
        val sortingList = mutableListOf<Int>(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
        val sortedList = mutableListOf<Int>(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)

        Assertions.assertEquals(sortedList, countingSort(sortingList, 0))
    }

    @Test
    fun sameValueList(){
        val sortingList = mutableListOf<Int>(5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5)
        val sortedList = mutableListOf<Int>(5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5)

        Assertions.assertEquals(sortedList, countingSort(sortingList, 5))
    }
}