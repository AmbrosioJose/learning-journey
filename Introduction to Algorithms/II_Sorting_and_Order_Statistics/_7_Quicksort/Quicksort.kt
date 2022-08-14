package II_Sorting_and_Order_Statistics._7_Quicksort

/**
 * Quicksort
 *
 * Space complexity: O(1)
 * Time complexity
 *  O(n^2)
 *  Balanced: θ(nlgn). An average case execution would have good and bad splits throughout the tree
 *  Unbalanced: θ(n^2). Number of "Bad" partitions greatly out weighs "Good" partitions
 *
 * "Good" partition: produces two sub arrays of size (n - 1)/ 2 - 1 and (n - 1)/ 2. Basically two close to equal arrays
 * "Bad" partition: produces two sub arrays of size 0 and n - 1.
 *
 *
 * @param list
 */
fun quicksort(list: MutableList<Int>){
    quicksort(list, 0, list.size - 1)
}

fun quicksort(list: MutableList<Int>, start: Int, end: Int){
    if(start < end){
        val pivot = partition(list, start, end)
        quicksort(list, start, pivot - 1)
        quicksort(list, pivot + 1, end)
    }
}

fun partition(list: MutableList<Int>, start: Int, end: Int): Int{
    val pivotValue = list[end]
    var i = start - 1
    for(j in start until end){
        if(list[j] <= pivotValue){
            swap(list, ++i, j)
        }
    }
    swap(list, i + 1, end)
    return i + 1
}

fun swap(list: MutableList<Int>, i: Int, j: Int){
    val temp = list[i]
    list[i] = list[j]
    list[j] = temp
}