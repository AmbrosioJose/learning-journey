package II_Sorting_and_Order_Statistics._8_Sorting_in_Linear_Time


/**
 * Counting sort
 *
 * Assumes that each of the n input elements is between 0 and k.
 * When k = O(n) the sort time is θ(n + k) => θ(n)
 *
 * @param list where each element at i is 0 <= list[i] <= [k]
 * @param k
 * @return sorted list
 */
fun countingSort(list: MutableList<Int>, k : Int): List<Int>{
    val auxList = MutableList(k + 1) {0}
    val results = MutableList(list.size){0}
    list.forEach {num ->
        auxList[num]++
    }
    // At this point the auxList contains the count of each element

    for(i in 1 .. k){
       auxList[i] += auxList[i - 1]
    }

    // At this point the auxList at each element contains the count of numbers equal to or less than the current number
//    println("input $list")
//    println("aux ${auxList}")
    for(i in list.size - 1 downTo 0){
//        print("i $i : list[i] ${list[i]} aux[i] ${auxList[list[i]]} ")
        results[auxList[list[i]] - 1] = list[i]
//        println(" results ${results.toTypedArray().contentDeepToString()}")
        // This is decremented in case there are multiple elements with the same value. The next element with the same
        // value will be inserted at the position before the previous element.
        auxList[list[i]]--
    }
    return results
}