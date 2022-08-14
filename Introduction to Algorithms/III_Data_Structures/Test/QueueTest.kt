package III_Data_Structures.Test


import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

import III_Data_Structures._10_Elementary_Data_Structures.Queue
import III_Data_Structures._10_Elementary_Data_Structures.EmptyQueue

internal class QueueTest {

    @Test
    fun enqueue() {
        val q = Queue()

        q.enqueue(5)

        assertEquals(5, q.dequeue())
    }

    @Test
    fun dequeue() {
        val q = Queue()

        q.enqueue(5)
        q.enqueue(6)
        q.enqueue(7)

        assertEquals(5, q.dequeue())
    }

    @Test
    fun dequeue2() {
        val q = Queue()

        q.enqueue(5)
        q.enqueue(16)
        q.enqueue(6)
        q.enqueue(7)

        q.dequeue()
        assertEquals(16, q.dequeue())
    }

    @Test
    fun dequeue3() {
        val q = Queue()

        q.enqueue(5)
        q.enqueue(16)
        q.enqueue(6)
        q.enqueue(7)

        q.dequeue()
        q.dequeue()
        q.dequeue()
        q.dequeue()
        assertThrows(EmptyQueue::class.java){q.dequeue()}
    }
}