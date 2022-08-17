package III_Data_Structures.Test

import III_Data_Structures._13_Red_Black_Trees.COLOR
import III_Data_Structures._13_Red_Black_Trees.RBNode
import III_Data_Structures._13_Red_Black_Trees.RedBlackTrees
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class RedBlackTreesTest {

    @Test
    fun insert() {
        val rbt = RedBlackTrees()
        rbt.insert(RBNode(5))
        rbt.insert(RBNode(16))
        rbt.insert(RBNode(7))
        assertEquals(7, rbt.root.value)
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
            val rbt = RedBlackTrees()
            rbt.insert(41)
            assertEquals(COLOR.BLACK, rbt.search(41)!!.color)
        }

        @Test
        fun insert38(){
            val rbt = RedBlackTrees()
            rbt.insert(41)
            rbt.insert(38)
            assertEquals(COLOR.RED, rbt.search(38)!!.color)
        }

        @Test
        fun insert31(){
            val rbt = RedBlackTrees()
            rbt.insert(41)
            rbt.insert(38)
            rbt.insert(31)
            assertEquals(COLOR.RED, rbt.search(31)!!.color)
        }

        @Test
        fun insert31b(){
            val rbt = RedBlackTrees()
            rbt.insert(41)
            rbt.insert(38)
            rbt.insert(31)
            assertEquals(COLOR.RED, rbt.search(41)!!.color)
        }

        @Test
        fun insert12(){
            val rbt = RedBlackTrees()
            rbt.insert(41)
            rbt.insert(38)
            rbt.insert(31)
            rbt.insert(12)
            assertEquals(COLOR.RED, rbt.search(12)!!.color)
        }

        @Test
        fun insert19(){
            val rbt = RedBlackTrees()
            rbt.insert(41)
            rbt.insert(38)
            rbt.insert(31)
            rbt.insert(12)
            rbt.insert(19)
            assertEquals(COLOR.RED, rbt.search(12)!!.color)
        }

        @Test
        fun insert19b(){
            val rbt = RedBlackTrees()
            rbt.insert(41)
            rbt.insert(38)
            rbt.insert(31)
            rbt.insert(12)
            rbt.insert(19)
            assertEquals(COLOR.RED, rbt.search(31)!!.color)
        }


        @Test
        fun insert8(){
            val rbt = RedBlackTrees()
            rbt.insert(41)
            rbt.insert(38)
            rbt.insert(31)
            rbt.insert(12)
            rbt.insert(19)
            rbt.insert(8)
            assertEquals(COLOR.RED, rbt.search(8)!!.color)
        }

        @Test
        fun insert8b(){
            val rbt = RedBlackTrees()
            rbt.insert(41)
            rbt.insert(38)
            rbt.insert(31)
            rbt.insert(12)
            rbt.insert(19)
            rbt.insert(8)
            assertEquals(COLOR.RED, rbt.search(19)!!.color)
        }

    }


    @Test
    fun search() {
        val rbt = RedBlackTrees()
        rbt.insert(RBNode(5))
        rbt.insert(RBNode(16))
        rbt.insert(RBNode(7))
        rbt.insert(RBNode(87))
        rbt.insert(RBNode(43))
        rbt.insert(RBNode(78))
        rbt.insert(RBNode(21))
        rbt.insert(RBNode(16))
        rbt.insert(RBNode(63))
        rbt.inOrderPrint(rbt.root)
        println()
        assertEquals(16, rbt.search(16)!!.value)
    }

    @Test
    fun search2() {
        val rbt = RedBlackTrees()
        rbt.insert(RBNode(5))
        rbt.insert(RBNode(16))
        rbt.insert(RBNode(7))
        rbt.insert(RBNode(87))
        rbt.insert(RBNode(43))
        rbt.insert(RBNode(78))
        rbt.insert(RBNode(21))
        rbt.insert(RBNode(16))
        rbt.insert(RBNode(63))
        assertNull(rbt.search(72))
    }

    @Test
    fun delete() {
        val rbt = RedBlackTrees()
        rbt.insert(RBNode(41))
        rbt.printTree()
        rbt.insert(RBNode(38))
        rbt.printTree()
        rbt.insert(RBNode(31))
        rbt.printTree()
        rbt.insert(RBNode(12))
        rbt.printTree()
        rbt.insert(RBNode(19))
        rbt.printTree()
        rbt.insert(RBNode(8))
        rbt.printTree()
        rbt.delete(12)
        rbt.printTree()
        assertNull(rbt.search(12))
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
        private var rbt = RedBlackTrees()

        @BeforeEach
        fun resetTree(){
            rbt = RedBlackTrees()
            rbt.insert(41)
            rbt.insert(38)
            rbt.insert(31)
            rbt.insert(12)
            rbt.insert(19)
            rbt.insert(8)
        }

        @Test
        fun delete8(){
            rbt.delete(8)
            assertEquals(COLOR.RED, rbt.search(19)!!.color)
        }

        @Test
        fun delete12(){
            rbt.delete(8)
            rbt.delete(12)
            println("After deleting 8, 12")
            rbt.printTree()
            assertEquals(COLOR.RED, rbt.search(31)!!.color)
        }


        /**
         * Delete19
         *
         * No red nodes
         *
         */
        @Test
        fun delete19(){
            rbt.delete(8)
            rbt.delete(12)
            rbt.delete(19)
            assertEquals(COLOR.BLACK, rbt.search(31)!!.color)
            assertEquals(COLOR.BLACK, rbt.search(41)!!.color)
            assertEquals(COLOR.BLACK, rbt.search(38)!!.color)

        }


        @Test
        fun delete31(){
            rbt.delete(8)
            rbt.delete(12)
            rbt.delete(19)
            rbt.delete(31)
            assertEquals(COLOR.RED, rbt.search(41)!!.color)
        }


        /**
         * Delete41
         *
         * Only root remaining which should be black
         */
        @Test
        fun delete41(){
            rbt.delete(8)
            rbt.delete(12)
            rbt.delete(19)
            rbt.delete(31)
            rbt.delete(38)
            assertEquals(COLOR.BLACK, rbt.search(41)!!.color)
        }
    }
}