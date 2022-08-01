package I_Foundations.`2 Getting Started`

/**
 * Insertion Sort Threshold
 *
 * Note that at the largest value that INSERTION_SORT_THRESHOLD(K)
 * can be for it to be slightly more optimal than standard merge sort
 * is K = lg(n) where n is the length of the list
 */
const val INSERTION_SORT_THRESHOLD = 20
fun mergeInsertionSortInit(list: MutableList<Int>){
    mergeInsertionSort(list, 0, list.size - 1)
}

fun mergeInsertionSort(list: MutableList<Int>, p: Int, r: Int){
    if(p >= r) return

    if(r - p < INSERTION_SORT_THRESHOLD){
        confinedInsertionSort(list, p, r)
    } else {
        val q = (p + r) / 2
        mergeInsertionSort(list, p, q)
        mergeInsertionSort(list, q + 1, r)
        merge(list, p, q, r)
    }
}

fun confinedInsertionSort(list: MutableList<Int>, p: Int, r: Int){
    var temp = 0

    for(i in p + 1..r){
        var insertingIndex = i
        while( insertingIndex > p && list[p + insertingIndex - 1] > list[p + insertingIndex]){
            temp = list[insertingIndex - 1]
            list[insertingIndex - 1] = list[insertingIndex]
            list[insertingIndex] = temp

            insertingIndex--
        }
    }
}

