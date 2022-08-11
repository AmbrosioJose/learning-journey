package III_Data_Structures.`11_Hash_Tables`

class SatelliteData(val key: Int, val data: String)

/**
 * Direct address table
 *
 * Creates a simple hash table as an example of direct addressing
 * Size of 10
 *
 * @constructor Create empty Direct address table
 */
class DirectAddressTable {
    val table = Array<SatelliteData?>(10){null}

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