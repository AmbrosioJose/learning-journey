package III_Data_Structures.Test

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

import III_Data_Structures.Stacks_and_Queues.Queue

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
}