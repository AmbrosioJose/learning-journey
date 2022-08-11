package III_Data_Structures.Test

import org.junit.jupiter.api.Test
import III_Data_Structures.`10_Elementary_Data_Structures`.LinkedList
import III_Data_Structures.`10_Elementary_Data_Structures`.Node
import org.junit.jupiter.api.Assertions.*

internal class LinkedListTest {

    @Test
    fun insert(){
        val ll = LinkedList()
        assertDoesNotThrow{ll.insert(Node(5))}
    }

    @Test
    fun search(){
        val ll = LinkedList()
        assertNull(ll.search(5))
    }

    @Test
    fun search2(){
        val ll = LinkedList()
        ll.insert(Node(5))
        assertEquals(5, ll.search(5)!!.value)
    }

    @Test
    fun search3(){
        val ll = LinkedList()
        ll.insert(Node(5))
        ll.insert(Node(7))
        assertEquals(5, ll.search(5)!!.value)
    }

    @Test
    fun search4(){
        val ll = LinkedList()
        ll.insert(Node(5))
        ll.insert(Node(6))
        ll.insert(Node(100))
        ll.insert(Node(100))
        ll.insert(Node(45))
        ll.insert(Node(67))
        ll.insert(Node(98))
        ll.insert(Node(98))
        ll.insert(Node(98))
        assertEquals(67, ll.search(67)!!.value)
    }

    @Test
    fun search5(){
        val ll = LinkedList()
        ll.insert(Node(5))
        ll.insert(Node(6))
        ll.insert(Node(100))
        ll.insert(Node(100))
        ll.insert(Node(45))
        ll.insert(Node(67))
        ll.insert(Node(98))
        ll.insert(Node(98))
        ll.insert(Node(98))
        assertEquals(98, ll.search(98)!!.value)
    }


    @Test
    fun search6(){
        val ll = LinkedList()
        ll.insert(Node(5))
        ll.insert(Node(6))
        ll.insert(Node(100))
        ll.insert(Node(100))
        ll.insert(Node(45))
        ll.insert(Node(67))
        ll.insert(Node(98))
        ll.insert(Node(98))
        ll.insert(Node(98))
        assertNull(ll.search(3005))
    }


    @Test
    fun delete(){
        val ll = LinkedList()
        ll.insert(Node(5))
        ll.insert(Node(6))
        ll.insert(Node(100))
        ll.insert(Node(100))
        ll.insert(Node(45))
        ll.insert(Node(67))
        ll.insert(Node(98))
        ll.insert(Node(98))
        ll.insert(Node(98))
        assertTrue(ll.delete(6))
    }

    @Test
    fun delete2(){
        val ll = LinkedList()
        ll.insert(Node(5))
        ll.insert(Node(6))
        ll.insert(Node(100))
        ll.insert(Node(100))
        ll.insert(Node(45))
        ll.insert(Node(67))
        ll.insert(Node(98))
        ll.insert(Node(98))
        ll.insert(Node(98))
        assertFalse(ll.delete(3005))
    }

    @Test
    fun delete3(){
        val ll = LinkedList()
        assertFalse(ll.delete(3005))
    }

    @Test
    fun delete4(){
        val ll = LinkedList()
        ll.insert(Node(5))
        ll.insert(Node(6))
        ll.insert(Node(100))
        ll.insert(Node(100))
        ll.insert(Node(45))
        ll.insert(Node(67))
        ll.insert(Node(98))
        ll.insert(Node(98))
        ll.insert(Node(98))
        ll.delete(5)
        assertNull(ll.search(5))
    }
}