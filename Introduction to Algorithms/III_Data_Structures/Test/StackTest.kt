package III_Data_Structures.Test

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

import III_Data_Structures.Stacks_and_Queues.Stack

internal class StackTest {

    @Test
    fun isEmpty() {
        val stack = Stack()
        assertTrue(stack.isEmpty())
    }

    @Test
    fun isEmpty2() {
        val stack = Stack()
        stack.push(5)
        assertFalse(stack.isEmpty())
    }

    @Test
    fun push() {
        val stack = Stack()
        stack.push(5)
        stack.push(6)
        assertEquals(6, stack.pop())
    }

    @Test
    fun pop() {
        val stack = Stack()
        stack.push(5)
        stack.push(3)
        stack.push(8)
        stack.push(15)
        stack.push(1)
        stack.pop()
        stack.pop()
        assertEquals(3, stack.pop())
    }
}