package I_Foundations.Test

import I_Foundations.`2 Getting Started`.mergeInsertionSortInit
import org.junit.jupiter.api.Assertions

class MergeInsertionSortTest {
    @org.junit.jupiter.api.Test
    fun test1() {
        val sortingList = mutableListOf(5,2,4,6,1,3)
        val sortedList = mutableListOf(1,2,3,4,5,6)

        mergeInsertionSortInit(sortingList)
        Assertions.assertEquals(sortedList, sortingList)
    }

    @org.junit.jupiter.api.Test
    fun test2() {
        val sortingList = mutableListOf(5,2,4,6,1,3,7)
        val sortedList = listOf(1,2,3,4,5,6,7)

        mergeInsertionSortInit(sortingList)
        Assertions.assertEquals(sortedList, sortingList)
    }

    @org.junit.jupiter.api.Test
    fun singleValue() {
        val sortingList = mutableListOf(1)
        val sortedList = listOf(1)

        mergeInsertionSortInit(sortingList)
        Assertions.assertEquals(sortedList, sortingList)
    }

    @org.junit.jupiter.api.Test
    fun twoValues() {
        val sortingList = mutableListOf(3,2)
        val sortedList = listOf(2,3)

        mergeInsertionSortInit(sortingList)
        Assertions.assertEquals(sortedList, sortingList)
    }

    @org.junit.jupiter.api.Test
    fun emptyList(){
        val sortingList = mutableListOf<Int>()
        val sortedList = listOf<Int>()

        mergeInsertionSortInit(sortingList)
        Assertions.assertEquals(sortedList, sortingList)
    }
}