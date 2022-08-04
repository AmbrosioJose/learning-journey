package III_Data_Structures.ElementaryDataStructures

class Queue {
    private var q = IntArray(100)
    var tail = 0
    var head = 0


    fun enqueue(x: Int){
        if(head == (tail + 1) % q.size)
            throw StackOverflowError("Queue size exceeded")
        q[tail] = x
        tail = (tail + 1) % q.size
    }

    fun dequeue(): Int{
        if(tail == head)
            throw EmptyQueue("Called dequeue on an empty queue")
        val result = q[head]
        head = (head + 1) % q.size
        return result
    }
}


class EmptyQueue(message: String): Exception(message)
