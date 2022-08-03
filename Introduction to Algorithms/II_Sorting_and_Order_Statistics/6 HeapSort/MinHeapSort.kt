package II_Sorting_and_Order_Statistics.`6 HeapSort`

class MinHeap(a: MutableList<Int>) {

    var heapSize = 0
    private val list: MutableList<Int> = a

    fun parent(i: Int): Int{
        return i shr(1)
    }

    fun left(i: Int): Int {
        return (i shl(1)) + 1
    }

    fun right(i: Int): Int {
        return (i shl(1)) + 2
    }

    fun buildMinHeap(){
        heapSize = list.size
        for(i in list.size / 2 downTo 0){
            minHeapify(i)
        }
    }

    fun minHeapify(i: Int){
        var min = i
        val l = left(i)
        val r = right(i)

        if(l < heapSize && list[l] < list[min])
            min = l
        if(r < heapSize && list[r] < list[min])
            min = r
        if(min != i){
            swap(min, i)
            minHeapify(min)
        }
    }

    private fun swap(i: Int, j: Int){
        val temp = list[i]
        list[i] = list[j]
        list[j] = temp
    }

    fun extractMin(): Int{
        val minValue = list[0]
        swap(0, heapSize - 1)
        heapSize--
        minHeapify(0)
        return minValue
    }


    fun heapSort(){
        buildMinHeap()
        for(i in list.size - 1 downTo 1){
            swap(0, i)
            heapSize--
            minHeapify(0)
        }
        list.reverse()
    }

    init {
        buildMinHeap()
    }

}