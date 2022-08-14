package I_Foundations._2_Getting_Started

const val SELECTION_SORT_THRESHOLD = 15

fun mergeSelectionSortInit(list: MutableList<Int>){
    mergeSelectionSort(list, 0, list.size - 1)
}

fun mergeSelectionSort(list: MutableList<Int>, p:Int, r:Int){
    if(p == r) return
    if(r - p < SELECTION_SORT_THRESHOLD)
        confinedSelectionSort(list, p, r)
    else {
        val q = (r + p) / 2
        mergeSelectionSort(list, p, q)
        mergeSelectionSort(list, p + 1, q)
        merge(list, p, q, r)
    }
}

fun confinedSelectionSort(list: MutableList<Int>, p: Int, r: Int){
    for(i in p .. r){
        var min = i
        for(j in i + 1 .. r){
            if(list[min] > list[j])
                min = j
        }
        val temp = list[min]
        list[min] = list[i]
        list[i] = temp
    }
}


