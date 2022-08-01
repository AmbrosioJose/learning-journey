package I_Foundations.`6 HeapSort`

class Heap(a: MutableList<Int>) {

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

    fun buildMaxHeap(){
        heapSize = list.size
        for(i in list.size / 2 downTo 0){
            maxHeapify(i)
        }
    }

    fun maxHeapify(i: Int){
        var max = i
        val l = left(i)
        val r = right(i)

        if(l < heapSize && list[l] > list[max])
            max = l
        if(r < heapSize && list[r] > list[max])
            max = r
        if(max != i){
            swap(max, i)
            maxHeapify(max)
        }
    }

    private fun swap(i: Int, j: Int){
        val temp = list[i]
        list[i] = list[j]
        list[j] = temp
    }

    fun extractMax(): Int{
        val maxValue = list[0]
        swap(0, heapSize - 1)
        heapSize--
        maxHeapify(0)
        return maxValue
    }


    fun heapSort(){
        buildMaxHeap()
        for(i in list.size - 1 downTo 1){
            swap(0, i)
            heapSize--
            maxHeapify(0)
        }
    }

    init {
        buildMaxHeap()
    }

}