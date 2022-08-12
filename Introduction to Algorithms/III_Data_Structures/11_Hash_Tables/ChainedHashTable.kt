package III_Data_Structures.`11_Hash_Tables`




/**
 * Chained hash table
 *
 * A simple hash table implemented with chaining to provide a solution to collisions
 * We assume no since we are using the [SatelliteData] class
 *
 * @constructor Create empty Chained hash table
 */
class ChainedHashTable: SatelliteHashTable{
    private val table = Array<ChainNode?>(10){ null }

    override fun search(key: Int): SatelliteData? {
        if(table[key] == null) return null
        return table[key]!!.next!!.search(key)!!.data
    }

    override fun insert(entry: SatelliteData){
        val insertingNode = ChainNode(entry.key, entry)
        if(table[entry.key] == null){
            val sentinel =  ChainNode(0, SatelliteData(0,"Sentinel"))
            table[entry.key] = sentinel
        }
        table[entry.key]!!.addToEnd(insertingNode)

    }

    override fun delete(key: Int){
        if(table[key] == null) return
        val deletingNode = table[key]!!.next!!.search(key) ?: return

        // clear if the deleting node is the only non sentinel node in the list
        if(!table[key]!!.next!!.hasNext()){
            table[key] = null
            return
        }

        deletingNode.delete()

    }



}

/**
 * Chain node
 *
 * A doubly linked list
 * @constructor Create empty Chain node
 */
class ChainNode(val key: Int, val data: SatelliteData){
    var next: ChainNode? = null
    var prev: ChainNode? = null

    fun addToEnd(insertingNode: ChainNode){
        if(next == null){
            next = insertingNode
            insertingNode.prev = this
        } else{
            next!!.addToEnd(insertingNode)
        }

    }

    fun search(searchKey: Int): ChainNode?{
        println("searchKey $searchKey, key $key")
        if(searchKey == key) return this
        if(next == null) return null

        return next!!.search(searchKey)
    }

    fun hasNext(): Boolean{
        return next != null
    }

    fun delete(){
        prev!!.next = next
        if(next != null){
            next!!.prev = prev
        }
    }

}