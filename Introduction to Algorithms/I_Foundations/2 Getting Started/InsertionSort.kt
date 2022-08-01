package I_Foundations.`2 Getting Started`

/**
 * Insertion sort
 *
 * Sorts a list of number in place in ascending order. Time complexity is O(n^2)
 * fun note: At every point i, a[0..i - 1] is called a loop invariant. The elements in a[0..i-1] are the same numbers,
 * but they are in sorted ascending order
 *
 * If the input list is in reverse order it is the worst case scenario. (n(n + 1)/ 2) - 2
 * If the input list is in sorted order then it is the best case which is linear
 *
 * @param a list that will be sorted
 *
 *
 */
fun insertionSort(a : MutableList<Int>){
    for(i in 1 until a.size){
        val key = a[i]
        var j = i - 1
        while(j >= 0 && a[j] > key){
            a[j + 1] = a[j]
            j--
        }
        a[j + 1] = key
    }
}

fun main(){
    val a = mutableListOf(4, 5, 3, 7)
    insertionSort(a)
    println(a)
}