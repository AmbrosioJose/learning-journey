package III_Data_Structures.Test

import III_Data_Structures._11_Hash_Tables.SatelliteData
import III_Data_Structures._11_Hash_Tables.SatelliteHashTableBuilder
import III_Data_Structures._11_Hash_Tables.SatelliteTableType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SatelliteHashMapTest{

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

    @ParameterizedTest
    @ArgumentsSource(MapArgumentsProvider::class)
    fun nullSearch(builder: SatelliteHashTableBuilder){
        val hashtable = builder.build()
        assertNull(hashtable.search(4))
        hashtable.insert(data[1])
    }

    @ParameterizedTest
    @ArgumentsSource(MapArgumentsProvider::class)
    fun nullSearch2(builder: SatelliteHashTableBuilder){
        val hashtable = builder.build()
        assertNull(hashtable.search(5))

    }

    @ParameterizedTest
    @ArgumentsSource(MapArgumentsProvider::class)
    fun insertSearch(builder: SatelliteHashTableBuilder){
        val hashtable = builder.build()
        hashtable.insert(data[1])
        assertEquals("satelliteData1",hashtable.search(1)!!.data)
    }

    @ParameterizedTest
    @ArgumentsSource(MapArgumentsProvider::class)
    fun insertSearch2(builder: SatelliteHashTableBuilder){
        val hashtable = builder.build()
        hashtable.insert(data[0])
        hashtable.insert(data[1])
        hashtable.insert(data[2])
        assertEquals(data[1].data,hashtable.search(1)!!.data)
    }

    @ParameterizedTest
    @ArgumentsSource(MapArgumentsProvider::class)
    fun delete(builder: SatelliteHashTableBuilder){
        val hashtable = builder.build()
        hashtable.insert(data[0])
        hashtable.insert(data[1])
        hashtable.insert(data[2])
        hashtable.delete(1)
        assertNull(hashtable.search(1))
    }


}

internal class MapArgumentsProvider : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext): Stream<out Arguments>? {
        return Stream.of(
            Arguments.of(SatelliteHashTableBuilder(SatelliteTableType.DIRECT)),
            Arguments.of(SatelliteHashTableBuilder(SatelliteTableType.CHAINED)),
        )
    }
}
