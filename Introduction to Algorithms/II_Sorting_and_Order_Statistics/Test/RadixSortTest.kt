package II_Sorting_and_Order_Statistics.Test

import II_Sorting_and_Order_Statistics._8_Sorting_in_Linear_Time.radixSort
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


internal class RadixSortTest {

    @Test
    fun test1() {
        val sortingList = mutableListOf(5,2,4,6,1,3)
        val sortedList = mutableListOf(1,2,3,4,5,6)

        radixSort(sortingList, 1)
        Assertions.assertEquals(sortedList, sortingList)
    }

    @Test
    fun test2() {
        val sortingList = mutableListOf(5,2,4,6,1,3,7)
        val sortedList = mutableListOf(1,2,3,4,5,6,7)

        radixSort(sortingList, 1)
        Assertions.assertEquals(sortedList, sortingList)
    }

    @Test
    fun test3() {
        val sortingList = mutableListOf(52,87,52,46,72,99,94)
        val sortedList = mutableListOf(46,52,52,72,87,94,99)

        radixSort(sortingList, 2)
        Assertions.assertEquals(sortedList, sortingList)
    }

    @Test
    fun test4() {
        val sortingList = mutableListOf(152,187,152,146,172,199,194)
        val sortedList = mutableListOf(146,152,152,172,187,194,199)

        radixSort(sortingList, 3)
        Assertions.assertEquals(sortedList, sortingList)
    }

    @Test
    fun test5() {
        val sortingList = mutableListOf(9152,8187,6152,9146,1172,4199,7194)
        val sortedList = mutableListOf(1172,4199,6152,7194,8187,9146,9152)

        radixSort(sortingList, 4)
        Assertions.assertEquals(sortedList, sortingList)
    }

    @Test
    fun orderedList() {
        val sortingList = mutableListOf(1,2,3,4,5,6,7)
        val sortedList = mutableListOf(1,2,3,4,5,6,7)

        radixSort(sortingList, 1)
        Assertions.assertEquals(sortedList, sortingList)
    }

    @Test
    fun reversedList() {
        val sortingList = mutableListOf(7,6,5,4,3,2,1)
        val sortedList = mutableListOf(1,2,3,4,5,6,7)

        radixSort(sortingList, 1)
        Assertions.assertEquals(sortedList, sortingList)
    }

    @Test
    fun singleValue() {
        val sortingList = mutableListOf(1)
        val sortedList = mutableListOf(1)

        radixSort(sortingList, 1)
        Assertions.assertEquals(sortedList, sortingList)
    }

    @Test
    fun twoValues() {
        val sortingList = mutableListOf(3,2)
        val sortedList = mutableListOf(2,3)

        radixSort(sortingList, 1)
        Assertions.assertEquals(sortedList, sortingList)
    }

    @Test
    fun emptyList(){
        val sortingList = mutableListOf<Int>()
        val sortedList = mutableListOf<Int>()

        radixSort(sortingList, 1)
        Assertions.assertEquals(sortedList, sortingList)
    }

    @Test
    fun zeroList(){
        val sortingList = mutableListOf<Int>(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
        val sortedList = mutableListOf<Int>(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)

        radixSort(sortingList, 1)
        Assertions.assertEquals(sortedList, sortingList)
    }

    @Test
    fun sameValueList(){
        val sortingList = mutableListOf<Int>(5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5)
        val sortedList = mutableListOf<Int>(5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5)

        radixSort(sortingList, 1)
        Assertions.assertEquals(sortedList, sortingList)
    }
}