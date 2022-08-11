package III_Data_Structures.`11_Hash_Tables`

/**
 * Direct address table
 *
 * Creates a simple hash table as an example of direct addressing
 * Size of 10
 *
 * @constructor Create empty Direct address table
 */
class DirectAddressTable {
    private val table = Array<SatelliteData?>(10){null}

    fun search(key: Int): SatelliteData? {
        return table[key]
    }

    fun insert(entry: SatelliteData){
        table[entry.key] = entry
    }

    fun delete(key: Int){
        table[key] = null
    }
}