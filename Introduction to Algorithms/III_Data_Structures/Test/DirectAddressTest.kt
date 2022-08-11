package III_Data_Structures.Test

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import III_Data_Structures.`11_Hash_Tables`.DirectAddressTable
import III_Data_Structures.`11_Hash_Tables`.SatelliteData

internal class DirectAddressTest {
    private val data = arrayOf<SatelliteData>(
        SatelliteData(0, "satelliteData0"),
        SatelliteData(1, "satelliteData1"),
        SatelliteData(2, "satelliteData2"),
        SatelliteData(3, "satelliteData3"),
        SatelliteData(4, "satelliteData4"),
        SatelliteData(5, "satelliteData5"),
        SatelliteData(6, "satelliteData6"),
        SatelliteData(7, "satelliteData7"),
        SatelliteData(8, "satelliteData8"),
        SatelliteData(9, "satelliteData9"),
    )

    @Test
    fun nullSearch(){
        val hashtable = DirectAddressTable()
        assertNull(hashtable.search(4))
        hashtable.insert(data[1])
    }

    @Test
    fun nullSearch2(){
        val hashtable = DirectAddressTable()
        assertNull(hashtable.search(5))

    }

    @Test
    fun insertSearch(){
        val hashtable = DirectAddressTable()
        hashtable.insert(data[1])
        assertEquals("satelliteData1",hashtable.search(1)!!.data)
    }

    @Test
    fun insertSearch2(){
        val hashtable = DirectAddressTable()
        hashtable.insert(data[0])
        hashtable.insert(data[1])
        hashtable.insert(data[1])
        hashtable.insert(data[1])
        hashtable.insert(data[2])
        assertEquals(data[1].data,hashtable.search(1)!!.data)
    }

    @Test
    fun delete(){
        val hashtable = DirectAddressTable()
        hashtable.insert(data[0])
        hashtable.insert(data[1])
        hashtable.insert(data[1])
        hashtable.insert(data[1])
        hashtable.insert(data[2])
        hashtable.delete(1)
        assertNull(hashtable.search(1))
    }
}