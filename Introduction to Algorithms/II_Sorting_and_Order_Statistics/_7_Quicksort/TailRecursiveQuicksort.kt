package II_Sorting_and_Order_Statistics._7_Quicksort

/**
 * Tail recursive quicksort
 *
 * This version of quicksort avoids the second recursive quicksort call by adjusting where the start of the quicksort
 * begins and restarts the loop
 *
 * @param list
 */
fun tailRecursiveQuicksort(list: MutableList<Int>){
    tailRecursiveQuicksort(list, 0, list.size - 1)
}

fun tailRecursiveQuicksort(list: MutableList<Int>, start: Int, end: Int){
    var s = start
    while(s < end){
        val pivot = partition(list, start, end)
        tailRecursiveQuicksort(list, start, pivot - 1)
        s = pivot + 1
    }
}