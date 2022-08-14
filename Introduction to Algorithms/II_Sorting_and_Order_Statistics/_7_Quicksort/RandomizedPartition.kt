package II_Sorting_and_Order_Statistics._7_Quicksort

/**
 * Randomized quicksort
 *
 * Uses a technique called random sampling to randomly choose a pivot element. We expect that the random smapling will
 * make the split of the array more reasonably balanced.
 *
 * Random sampling is employed by swapping the pivot which, is at the end, with a random number between the [start] and
 * [end]
 *
 * @param list
 */
fun randomizedQuicksort(list: MutableList<Int>){
    randomizedQuicksort(list, 0, list.size - 1)
}

fun randomizedQuicksort(list: MutableList<Int>, start: Int, end: Int){
    if(start < end){
        val pivot = randomizedPartition(list, start, end)
        randomizedQuicksort(list, start, pivot - 1)
        randomizedQuicksort(list, pivot + 1, end)
    }
}

fun randomizedPartition(list: MutableList<Int>, start: Int, end: Int): Int{
    val i = (start..end).random()
    swap(list, i, end)
    return partition(list, start, end)
}