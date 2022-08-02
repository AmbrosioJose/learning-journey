package I_Foundations.Test

import I_Foundations.`6 HeapSort`.EmptyQueueException
import I_Foundations.`6 HeapSort`.PriorityQueue
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PriorityQueueTest {

    @Test
    fun emptyPQ(){
        val pq = PriorityQueue(0)
        assertEquals(0, pq.heapSize) }

    @Test
    fun verifySize1(){
        val pq = PriorityQueue(1)
        pq.insert(5)
        assertEquals(1, pq.heapSize) }

    @Test
    fun verifySize2(){
        val pq = PriorityQueue(1)
        pq.insert(5)
        pq.extractMax()
        assertEquals(0, pq.heapSize) }

    @Test
    fun verifyEmptyException(){
        val pq = PriorityQueue(0)
        assertThrows(EmptyQueueException::class.java) { pq.extractMax() }
    }

    @Test
    fun verifyEmptyException2(){
        val pq = PriorityQueue(1)
        assertThrows(EmptyQueueException::class.java) { pq.extractMax() }
    }

    @Test
    fun verifyEmptyException3(){
        val pq = PriorityQueue(0)
        assertThrows(EmptyQueueException::class.java) { pq.heapMax() }
    }

    @Test
    fun verifyEmptyException4(){
        val pq = PriorityQueue(1)
        assertThrows(EmptyQueueException::class.java) { pq.heapMax() }
    }

    @Test
    fun verifyEmptyException5(){
        val pq = PriorityQueue(1)
        pq.insert(5)
        pq.extractMax()
        assertThrows(EmptyQueueException::class.java) { pq.extractMax() }
    }

    @Test
    fun verifyEmptyException6(){
        val pq = PriorityQueue(1)
        pq.insert(5)
        pq.extractMax()
        assertThrows(EmptyQueueException::class.java) { pq.heapMax() }
    }


    @Test
    fun verifyMax(){
        val pq = PriorityQueue(1)
        pq.insert(5)
        assertEquals( 5, pq.extractMax())
    }

    @Test
    fun verifyMax2(){
        val pq = PriorityQueue(1)
        pq.insert(5)
        assertEquals( 5, pq.heapMax())
    }

    @Test
    fun verifyMax3(){
        val pq = PriorityQueue(2)
        pq.insert(5)
        pq.insert(6)
        assertEquals( 6, pq.extractMax())
    }

    @Test
    fun verifyMax4(){
        val pq = PriorityQueue(2)
        pq.insert(5)
        pq.insert(6)
        assertEquals( 6, pq.heapMax())
    }

    @Test
    fun verifyMax5(){
        val pq = PriorityQueue(2)
        pq.insert(6)
        pq.insert(5)
        assertEquals( 6, pq.extractMax())
    }

    @Test
    fun verifyMax6(){
        val pq = PriorityQueue(2)
        pq.insert(6)
        pq.insert(5)
        assertEquals( 6, pq.heapMax())
    }

    @Test
    fun verifyMax7(){
        val pq = PriorityQueue(6)
        pq.insert(2)
        pq.insert(3)
        pq.insert(1)
        pq.insert(4)
        pq.insert(5)
        pq.insert(6)
        assertEquals( 6, pq.extractMax())
    }

    @Test
    fun verifyMax8(){
        val pq = PriorityQueue(6)
        pq.insert(2)
        pq.insert(3)
        pq.insert(4)
        pq.insert(5)
        pq.insert(6)
        pq.insert(1)
        assertEquals( 6, pq.heapMax())
    }

    @Test
    fun verifyMax9(){
        val pq = PriorityQueue(6)
        pq.insert(2)
        pq.insert(-1)
        pq.insert(1)
        pq.insert(4)
        pq.insert(5)
        pq.insert(6)
        assertEquals( 6, pq.extractMax())
    }

    @Test
    fun verifyMax10(){
        val pq = PriorityQueue(6)
        pq.insert(2)
        pq.insert(-1)
        pq.insert(4)
        pq.insert(5)
        pq.insert(6)
        pq.insert(1)
        assertEquals( 6, pq.heapMax())
    }

    @Test
    fun verifyMax11(){
        val pq = PriorityQueue(2)
        pq.insert(2)
        pq.insert(-1)
        assertEquals( 2, pq.extractMax())
    }

    @Test
    fun verifyMax12(){
        val pq = PriorityQueue(2)
        pq.insert(2)
        pq.insert(-1)
        assertEquals( 2, pq.heapMax())
    }


    @Test
    fun verifyMax13(){
        val pq = PriorityQueue(6)
        pq.insert(2)
        pq.insert(-1)
        pq.insert(4)
        pq.insert(5)
        pq.insert(6)
        pq.insert(1)
        pq.extractMax()
        pq.extractMax()
        pq.extractMax()
        pq.extractMax()
        pq.extractMax()
        assertEquals( -1, pq.extractMax())
    }

    @Test
    fun verifyMax14(){
        val pq = PriorityQueue(6)
        pq.insert(2)
        pq.insert(-1)
        pq.insert(4)
        pq.insert(5)
        pq.insert(6)
        pq.insert(1)
        pq.extractMax()
        pq.extractMax()
        pq.extractMax()
        pq.extractMax()
        pq.extractMax()
        assertEquals( -1, pq.extractMax())
    }

    @Test
    fun verifyMax15(){
        val pq = PriorityQueue(6)
        pq.insert(2)
        pq.insert(-1)
        pq.insert(4)
        pq.insert(5)
        pq.insert(6)
        pq.insert(1)
        pq.extractMax()
        pq.extractMax()
        assertEquals( 4, pq.extractMax())
    }

    @Test
    fun verifyMax16(){
        val pq = PriorityQueue(6)
        pq.insert(2)
        pq.insert(-1)
        pq.insert(4)
        pq.insert(5)
        pq.insert(6)
        pq.insert(1)
        pq.extractMax()
        pq.extractMax()
        assertEquals( 4, pq.heapMax())
    }
}