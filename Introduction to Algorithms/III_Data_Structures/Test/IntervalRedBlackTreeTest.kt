package III_Data_Structures.Test

import III_Data_Structures._14_Augmenting_Data_Structures.COLOR
import III_Data_Structures._14_Augmenting_Data_Structures.Interval
import III_Data_Structures._14_Augmenting_Data_Structures.IntervalTree
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class IntervalRedBlackTreesTest {

    @Nested
    inner class maxCheck{
        private var rbt = IntervalTree()
        @BeforeEach
        fun resetTree() {
            rbt = IntervalTree()
            rbt.insert(Interval(15,23))
            rbt.insert(Interval(26,26))
            rbt.insert(Interval(16,21))
            rbt.insert(Interval(25,30))
            rbt.insert(Interval(17,19))
            rbt.insert(Interval(19,20))
            rbt.insert(Interval(6,10))
            rbt.insert(Interval(8,9))
            rbt.insert(Interval(0,3))
            rbt.insert(Interval(5,8))
        }

        @Test
        fun rootMax(){
            assertEquals(30, rbt.root.subtreeMax)
        }

        @Test
        fun overlapping(){
            assertEquals(16, rbt.search(Interval(21, 26))!!.interval.start)
        }

        @Test
        fun allOverlapping(){
            // [[16,21], [15,23], [25,30], [26,26]]
            println(rbt.searchAll(Interval(21, 26)).contentDeepToString())
            assertEquals(4, rbt.searchAll(Interval(21, 26)).size)

        }
    }

    @Test
    fun insert(){
        val rbt = IntervalTree()
        rbt.insert(Interval(5,6))
        rbt.insert(Interval(16,25))
        rbt.insert(Interval(7,8))
        assertEquals(7, rbt.root.interval.start)
    }


    /**
     * Insert sequence
     *
     * Checks that the expected nodes are red given a sequence of numbers.
     * sequence: 41, 38, 31, 12, 19, 8
     * We check the for the expected red nodes at each point in the insertion. (Note the order matters in insertion
     * so all tests add the numbers in the same order as the given sequence)
     *
     * eg:
     * inserting 41: no red nodes, so we just test that the root node is black (property 1 of RedBlack Tree)
     * inserting 38: 38 is red (Fix up: no case)
     * inserting 31: 31 and 41 are red (Fix up: case 3)
     * inserting 12: 12 is red (Fix up: case 1)
     * inserting 19: 12 and 31 are red (Fix up: case 2 and case 3)
     * inserting 8: 8 and 19 are red (Fix up: case 2)
     *
     * Worked it out in paper based on pseudocode
     *
     * @constructor Create empty Insert multiple
     */
    @Nested
    inner class InsertSequence{

        @Test
        fun insert41(){
            val rbt = IntervalTree()
            rbt.insert(Interval(41,43))
            assertEquals(COLOR.BLACK, rbt.search(Interval(41, 45))!!.color)
        }

        @Test
        fun insert38(){
            val rbt = IntervalTree()
            rbt.insert(Interval(41,42))
            rbt.insert(Interval(38,39))
            assertEquals(COLOR.RED, rbt.search(Interval(38,39))!!.color)
        }

        @Test
        fun insert31(){
            val rbt = IntervalTree()
            rbt.insert(Interval(41,42))
            rbt.insert(Interval(38,39))
            rbt.insert(Interval(31,32))
            assertEquals(COLOR.RED, rbt.search(Interval(31,32))!!.color)
        }

        @Test
        fun insert31b(){
            val rbt = IntervalTree()
            rbt.insert(Interval(41,42))
            rbt.insert(Interval(38,39))
            rbt.insert(Interval(31,32))
            assertEquals(COLOR.RED, rbt.search(Interval(41,42))!!.color)
        }

        @Test
        fun insert12(){
            val rbt = IntervalTree()
            rbt.insert(Interval(41,42))
            rbt.insert(Interval(38,39))
            rbt.insert(Interval(31,32))
            rbt.insert(Interval(12,13))
            assertEquals(COLOR.RED, rbt.search(Interval(12,14))!!.color)
        }

        @Test
        fun insert19(){
            val rbt = IntervalTree()
            rbt.insert(Interval(41,42))
            rbt.insert(Interval(38,39))
            rbt.insert(Interval(31,32))
            rbt.insert(Interval(12,13))
            rbt.insert(Interval(19,21))
            assertEquals(COLOR.RED, rbt.search(Interval(12,14))!!.color)
        }

        @Test
        fun insert19b(){
            val rbt = IntervalTree()
            rbt.insert(Interval(41,42))
            rbt.insert(Interval(38,39))
            rbt.insert(Interval(31,32))
            rbt.insert(Interval(12,13))
            rbt.insert(Interval(19,21))
            assertEquals(COLOR.RED, rbt.search(Interval(31,32))!!.color)
        }


        @Test
        fun insert8(){
            val rbt = IntervalTree()
            rbt.insert(Interval(41,42))
            rbt.insert(Interval(38,39))
            rbt.insert(Interval(31,32))
            rbt.insert(Interval(12,13))
            rbt.insert(Interval(19,21))
            rbt.insert(Interval(8,11))
            assertEquals(COLOR.RED, rbt.search(Interval(8,9))!!.color)
        }

        @Test
        fun insert8b(){
            val rbt = IntervalTree()
            rbt.insert(Interval(41,42))
            rbt.insert(Interval(38,39))
            rbt.insert(Interval(31,32))
            rbt.insert(Interval(12,13))
            rbt.insert(Interval(19,21))
            rbt.insert(Interval(8,11))
            assertEquals(COLOR.RED, rbt.search(Interval(19,20))!!.color)
        }

    }


    @Test
    fun search() {
        val rbt = IntervalTree()
        rbt.insert(Interval(5,6))
        rbt.insert(Interval(16,17))
        rbt.insert(Interval(7,8))
        rbt.insert(Interval(87,89))
        rbt.insert(Interval(43,44))
        rbt.insert(Interval(78,79))
        rbt.insert(Interval(21,23))
        rbt.insert(Interval(16,19))
        rbt.insert(Interval(63,64))
        rbt.inOrderPrint(rbt.root)
        println()
        assertEquals(16, rbt.search(Interval(16,17))!!.interval.start)
    }

    @Test
    fun search2() {
        val rbt = IntervalTree()
        rbt.insert(Interval(5,6))
        rbt.insert(Interval(16,17))
        rbt.insert(Interval(7,8))
        rbt.insert(Interval(87,89))
        rbt.insert(Interval(43,44))
        rbt.insert(Interval(78,79))
        rbt.insert(Interval(21,23))
        rbt.insert(Interval(16,19))
        rbt.insert(Interval(63,64))
        assertNull(rbt.search(Interval(72,73)))
    }

    @Test
    fun delete() {
        val rbt = IntervalTree()
        rbt.insert(Interval(41,42))
        rbt.printTree()
        rbt.insert(Interval(38,39))
        rbt.printTree()
        rbt.insert(Interval(31,32))
        rbt.printTree()
        rbt.insert(Interval(12,13))
        rbt.printTree()
        rbt.insert(Interval(19,21))
        rbt.printTree()
        rbt.insert(Interval(8,9))
        rbt.printTree()
        rbt.delete(Interval(12,13))
        rbt.printTree()
        assertNull(rbt.search(Interval(12,13)))
    }



    /**
     * Delete sequence
     *
     * Deletes numbers in sequence 8, 12, 19, 31, 38, 41
     *
     * Deleting 8: 19 is red (No fix up since 8's left child is nil and 8 was red)
     * Deleting 12: 31 is red (case 2)
     * Deleting 19: No red
     * Deleting 31: 41 is red
     * Deleting 41: 41 is black
     *
     *
     * @constructor Create empty Delete sequence
     */
    @Nested
    inner class DeleteSequence{
        private var rbt = IntervalTree()

        @BeforeEach
        fun resetTree(){
            rbt = IntervalTree()
            rbt.insert(Interval(41,41))
            rbt.insert(Interval(38,39))
            rbt.insert(Interval(31,36))
            rbt.insert(Interval(12,14))
            rbt.insert(Interval(19,22))
            rbt.insert(Interval(8,11))
        }

        @Test
        fun delete8(){
            rbt.delete(Interval(8, 10))
            assertEquals(COLOR.RED, rbt.search(Interval(19,22))!!.color)
        }

        @Test
        fun delete12(){
            rbt.delete(Interval(8,10))
            rbt.delete(Interval(12,13))
            println("After deleting 8, 12")
            rbt.printTree()
            assertEquals(COLOR.RED, rbt.search(Interval(31,32))!!.color)
        }


        /**
         * Delete19
         *
         * No red nodes
         *
         */
        @Test
        fun delete19(){
            rbt.delete(Interval(8,10))
            rbt.delete(Interval(12,13))
            rbt.delete(Interval(19,21))
            assertEquals(COLOR.BLACK, rbt.search(Interval(31,32))!!.color)
            assertEquals(COLOR.BLACK, rbt.search(Interval(41,42))!!.color)
            assertEquals(COLOR.BLACK, rbt.search(Interval(38,39))!!.color)

        }


        @Test
        fun delete31(){
            rbt.delete(Interval(8,10))
            rbt.delete(Interval(12,13))
            rbt.delete(Interval(19,21))
            rbt.delete(Interval(31,32))
            assertEquals(COLOR.RED, rbt.search(Interval(41,42))!!.color)
        }


        /**
         * Delete41
         *
         * Only root remaining which should be black
         */
        @Test
        fun delete32(){
            rbt.delete(Interval(8,10))
            rbt.delete(Interval(12,13))
            rbt.delete(Interval(19,21))
            rbt.delete(Interval(31,32))
            rbt.delete(Interval(38,39))
            assertEquals(COLOR.BLACK, rbt.search(Interval(41,42))!!.color)
        }
    }
}