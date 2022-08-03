package II_Sorting_and_Order_Statistics.`8 Sorting in Linear Time`

/**
 * Radix sort
 *
 * Radix sort assumes that each element in [list] has [d] amount of digits, where 1 digit is the lowest order
 * and d digit is the highest order. Uses a stable sort with θ(n + k)
 *
 * @param list
 * @param d
 */
fun radixSort(list: MutableList<Int>, d: Int){
    for(digit in 1 .. d){
        countSortIthDigit(list, digit)
    }
}


/**
 * Base Ten Digits Count
 *
 * Since radix sort uses each digit to sort the maximum amount of digits used would be 10, 0...9.
 * This can perhaps be optimized for numbers that do not use a decimal system(base 10) but it works for any number
 * systems that use base 10 or less.
 *
 * Note: in the case of letters a count of 26 can be used since it is a base 26 system
 */
const val BASE_TEN_DIGITS_COUNT = 10


/**
 * Count sort ith digit
 *
 * Similar to standard counting sort but assumes that the all number's will have a certain specified [digit] with
 * a value of at most [BASE_TEN_DIGITS_COUNT].
 *
 * e.g element 1546 the if specified [digit] is 2 it will return 4 because it is the second digit
 *
 * @see ithDigit is used to get the specified digit
 *
 *
 * @param list
 * @param digit
 */
fun countSortIthDigit(list: MutableList<Int>, digit: Int){
    val auxList = MutableList(BASE_TEN_DIGITS_COUNT){0}

    val results = MutableList(list.size){0}

    list.forEach{ num ->
        val ithNum = ithDigit(num, digit)
        auxList[ithNum]++
    }

    for(i in 1 until BASE_TEN_DIGITS_COUNT){
        auxList[i] += auxList[i -1]
    }

    for(i in list.size - 1 downTo 0){
//        print("i $i : list[i] ${list[i]} aux[i] ${auxList[list[i]]} ")
        val ithNum = ithDigit(list[i], digit)
//        println(" results ${results.toTypedArray().contentDeepToString()}")

        results[auxList[ithNum] - 1] = list[i]
        auxList[ithNum]--
    }

    results.forEachIndexed{i, num ->
        list[i] = num
    }
}

const val TEN = 10.0

/**
 * Ith digit
 *
 * f(x, d) = (x % 10^d - x % 10^(d - 1)) / x % 10^(d - 1)
 *  where x is the number and d is the digit that we are trying to extract.
 *
 * e.g
 * val tensPlace = (x % 100 - x % 10) / 10
 * val hundredsPlace = (x % 1000 - x % 100) / 100
 *
 * @param num
 * @param i
 * @return
 */
fun ithDigit(num: Int, i: Int): Int{
    val dNum = num.toDouble()
    val dI = i.toDouble()
    return ((num % Math.pow(TEN, dI) - num % Math.pow(TEN, dI - 1)) / Math.pow(TEN, dI - 1) ).toInt()
}