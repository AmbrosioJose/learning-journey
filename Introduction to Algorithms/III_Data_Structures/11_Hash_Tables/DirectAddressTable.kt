package III_Data_Structures.`11_Hash_Tables`

/**
 * Direct address table
 *
 * Creates a simple hash table as an example of direct addressing. No hashing
 * Size of 10.
 *
 *
 * @constructor Create empty Direct address table
 */
class DirectAddressTable : SatelliteHashTable{
    private val table = Array<SatelliteData?>(10){null}

    override fun search(key: Int): SatelliteData? {
        return table[key]
    }

    override fun insert(entry: SatelliteData){
        table[entry.key] = entry
    }

    override fun delete(key: Int){
        table[key] = null
    }
}