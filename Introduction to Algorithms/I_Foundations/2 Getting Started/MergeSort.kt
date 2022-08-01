package I_Foundations.`2 Getting Started`

fun mergeSortInit(list: MutableList<Int>){
    mergeSort(list, 0, list.size - 1)
}

fun merge(list: MutableList<Int>, p: Int, q: Int, r: Int){
    val leftSize = q - p + 1
    val rightSize = r - q
    val left = IntArray(leftSize)
    val right = IntArray(rightSize)

    for(i in 0 until leftSize)
        left[i] = list[p + i]

    for(i in 0 until rightSize)
        right[i] = list[q + i + 1]
    var lI = 0
    var rI = 0
    for(i in p..r){
        if(rI < rightSize && (lI == leftSize || left[lI] >= right[rI]))
            list[i] = right[rI++]
        else
            list[i] = left[lI++]
    }
}

fun mergeSort(list: MutableList<Int>, p: Int, r: Int){
    if(p < r){
        val q = (p + r) / 2
        mergeSort(list, p, q)
        mergeSort(list, q + 1, r)
        merge(list, p, q, r)
    }
}

fun main(){

}