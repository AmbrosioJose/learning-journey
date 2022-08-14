package III_Data_Structures._11_Hash_Tables

interface SatelliteHashTable {
    fun search(key: Int): SatelliteData?

    fun insert(entry: SatelliteData)

    fun delete(key: Int)
}