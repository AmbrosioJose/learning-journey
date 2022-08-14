package III_Data_Structures._11_Hash_Tables

enum class SatelliteTableType {DIRECT, CHAINED}
open class SatelliteHashTableBuilder(private val type: SatelliteTableType) {
    fun build(): SatelliteHashTable {
        if(type == SatelliteTableType.DIRECT){
            return DirectAddressTable()
        }
        return ChainedHashTable()
    }
}