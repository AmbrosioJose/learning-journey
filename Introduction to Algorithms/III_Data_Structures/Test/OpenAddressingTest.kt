package III_Data_Structures.Test

import III_Data_Structures._11_Hash_Tables.OpenAddressingTable
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class OpenAddressingTest {
    @Test
    fun insert(){
        val table = OpenAddressingTable()
        assertDoesNotThrow{table.insert(15)}
    }

    @Test
    fun search(){
        val table = OpenAddressingTable()
        table.insert(15)
        assertEquals(15, table.search(15))
    }

    @Test
    fun search2(){
        val table = OpenAddressingTable()
        table.insert(89)
        assertNull( table.search(15))
    }

    @Test
    fun search3(){
        val table = OpenAddressingTable()
        table.insert(15)
        table.insert(15)
        table.insert(15)
        table.insert(15)
        table.insert(16)
        table.insert(18)
        assertEquals(16, table.search(16))
    }

    @Test
    fun delete(){
        val table = OpenAddressingTable()
        table.insert(15)
        table.insert(1)
        table.insert(99)

        table.delete(15)

        assertNull(table.search(15))
    }
}