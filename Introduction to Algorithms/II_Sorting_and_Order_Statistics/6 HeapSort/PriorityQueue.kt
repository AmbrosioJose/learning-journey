package II_Sorting_and_Order_Statistics.`6 HeapSort`

import java.lang.IndexOutOfBoundsException

class PriorityQueue(size: Int) {
    private val list = MutableList<Int>(size){0}
    var heapSize = 0

    private fun parent(i: Int): Int{
        return i shr(1)
    }

    private fun left(i: Int): Int {
        return (i shl(1)) + 1
    }

    private fun right(i: Int): Int {
        return (i shl(1)) + 2
    }

    private fun swap(i: Int, j: Int){
        val temp = list[i]
        list[i] = list[j]
        list[j] = temp
    }

    fun heapMax(): Int{
        if(heapSize < 1)
            throw EmptyQueueException("Empty heap")
        return list[0]
    }

    fun extractMax(): Int {
        if(heapSize < 1)
            throw EmptyQueueException("Empty heap")
        val max = list[0]
        list[0] = list[heapSize - 1]
        heapSize--
        maxHeapify(0)
        return max
    }

    fun insert(key: Int) {
        if(heapSize >= list.size)
            throw IndexOutOfBoundsException("This heap only handles a size up to ${list.size}")
        list[heapSize++] = Int.MIN_VALUE
        heapIncreaseHeap(heapSize - 1, key)
    }

    private fun heapIncreaseHeap(i: Int, key: Int){
        if(heapSize <= i)
            throw IndexOutOfBoundsException()
        if(list[i] > key)
            throw InvalidPriorityException("Key $key is not larger than ${list[i]}")

        list[i] = key
        var j = i
        while(j > 0 && list[j] > list[parent(j)]){
            swap(j, parent(j))
            j = parent(j)
        }
    }

    private fun maxHeapify(i: Int){
        var max = i
        val l = left(max)
        val r = right(max)
        if(l < heapSize && list[l] > list[max])
            max = l
        if(r < heapSize && list[r] > list[max])
            max = r
        if(max != i){
            swap(max, i)
            maxHeapify(max)
        }
    }


}

class EmptyQueueException(message: String): Exception(message)
class InvalidPriorityException(message: String): Exception(message)