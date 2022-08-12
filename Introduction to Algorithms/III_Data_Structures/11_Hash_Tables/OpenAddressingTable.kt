package III_Data_Structures.`11_Hash_Tables`

const val DELETED = Int.MIN_VALUE
/**
 * Open addressing table
 *
 * Each entry either contains an entry(Int) or a null. When searching for an element
 * we systematically examine table slots until we find the element or ascertained that the
 * element is not in the table
 *
 * @constructor Create empty Open addressing table
 */

class OpenAddressingTable {
    private val table = Array<Int?>(10){null}

    fun insert(key: Int): Int{
        var i = 0
        while(i < table.size){
            val hashedKey = doubleHashing(key, i)
            if(table[hashedKey] == null || table[hashedKey] == DELETED){
                table[hashedKey] = key
                return hashedKey
            }
            i++
        }

        throw StackOverflowError("Hash table overflow")
    }

    fun delete(key: Int){
        val keyHash = searchHash(key)?: return
        table[keyHash] = DELETED

    }

    fun search(key: Int): Int?{
        val keyPosition = searchHash(key) ?: return null

        return table[keyPosition]
    }

    private fun searchHash(key: Int): Int?{
        var i = 0
        while(i < table.size){
            val hashedKey = doubleHashing(key, i)
            if(table[hashedKey] == null) return null
            if(table[hashedKey] == key)
                return hashedKey
            i++
        }
        return null
    }


    /**
     * Division hash
     *
     * h(k) = k mod m
     *
     * k = key
     * m = table size
     *
     * @param key
     * @return Hashed Key
     */
    private fun divisionHash(key: Int): Int{
        return key % table.size
    }

    /**
     * Multiplication hash
     *
     * h(k) = m (kA mod 1)
     *
     * k = key
     * m = table size
     * A = (sqrt(5) - 1) / 2
     * A is used since it a suggested by Knuth, but other values can be used as well to fit characteristics of data
     * being hashed
     *
     *
     * @param key
     * @return Hashed key
     */
    private fun multiplicationHash(key: Int): Int{
        val a = (Math.sqrt(5.0) - 1) / 2
        return (table.size * ((key * a) % 1)).toInt()
    }


    /**
     * Linear probing
     *
     * @param key
     * @param i
     * @return Hashed key
     *
     * Long runs of occupied slots tend to get longer therefore the average search time increases
     */
    private fun linearProbing(key: Int, i: Int): Int{
        return (divisionHash(key) + i) % table.size
    }

    /**
     * Quadratic probing
     *
     * @param key
     * @param i
     * @return Hashed Key
     *
     * Similar to linear probing the initial probe determines the entire sequence
     *
     */
    private fun quadraticProbing(key: Int, i: Int): Int {
        val c1 = 1
        val c2 = 3

        return (divisionHash(key) + c1 * i + c2 * i * i) % table.size
    }

    /**
     * Double hashing
     *
     * @param key
     * @param i
     * @return Hashed Key
     *
     * Uses two different auxiliary hashing functions
     *
     */
    private fun doubleHashing(key: Int, i: Int): Int {
        return (divisionHash(key) + (i * multiplicationHash(key))) % table.size
    }
}
