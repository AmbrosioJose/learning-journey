package III_Data_Structures.Test

import III_Data_Structures._12_Binary_Search_Trees.BinarySearchTree
import III_Data_Structures._12_Binary_Search_Trees.Node
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BinarySearchTreeTest {

    @Test
    fun insert() {
        val bst = BinarySearchTree()
        bst.insert(Node(5))
        bst.insert(Node(16))
        bst.insert(Node(7))
        bst.insert(Node(87))
        bst.insert(Node(43))
        bst.inOrderPrint(bst.root)
        assertEquals(5, bst.root!!.value)
    }

    @Test
    fun search() {
        val bst = BinarySearchTree()
        bst.insert(Node(5))
        bst.insert(Node(16))
        bst.insert(Node(7))
        bst.insert(Node(87))
        bst.insert(Node(43))
        bst.insert(Node(78))
        bst.insert(Node(21))
        bst.insert(Node(16))
        bst.insert(Node(63))
        assertEquals(16, bst.search(16)!!.value)
    }

    @Test
    fun search2() {
        val bst = BinarySearchTree()
        bst.insert(Node(5))
        bst.insert(Node(16))
        bst.insert(Node(7))
        bst.insert(Node(87))
        bst.insert(Node(43))
        bst.insert(Node(78))
        bst.insert(Node(21))
        bst.insert(Node(16))
        bst.insert(Node(63))
        assertNull(bst.search(72))
    }

    @Test
    fun delete() {
        val bst = BinarySearchTree()
        bst.insert(Node(5))
        bst.insert(Node(16))
        bst.insert(Node(7))
        bst.insert(Node(87))
        bst.insert(Node(43))
        bst.insert(Node(78))
        bst.insert(Node(21))
        bst.insert(Node(16))
        bst.insert(Node(63))
        bst.delete(87)
        bst.inOrderPrint(bst.root)
        assertNull(bst.search(87))
    }
}