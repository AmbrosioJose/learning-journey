package III_Data_Structures.ElementaryDataStructures

class LinkedList {
    // sentinel node
    private val nil = Node(0)
    init {
        nil.next = nil
        nil.prev = nil
    }

    /**
     * Search
     *
     * Returns the node containing the value [k] if it is found in the list. Otherwise, it returns null
     * Ignores nil(sentinel) node
     *
     * @param k
     * @return [Node?]
     */
    fun search(k: Int): Node?{
        var curr = nil.next
        while(curr != nil && curr!!.value != k){
            curr = curr.next!!
        }
        if(curr == nil)
            return null
        return curr
    }

    /**
     * Insert
     *
     * Insert node at the start of the list
     *
     * @param node
     */
    fun insert(node: Node){
        node.next = nil.next
        nil.next!!.prev = node
        nil.next = node
        node.prev = nil
    }

    /**
     * Delete
     *
     * Deletes the first node that has a [Node.value] == [k] and return true.
     * If a node with [Node.value] == [k] is not found return false
     *
     * @param k
     * @return
     */
    fun delete(k: Int): Boolean{
        val deletingNode = search(k)
        if(deletingNode == null)
            return false
        delete(deletingNode)
        return true
    }

    /**
     * Delete
     *
     * Deletes the specified node. Since it is a private function and aren't calling delete on the [nil] node we can
     * assume that every node will always have non-null [Node.next] and [Node.prev]
     *
     * @param node
     */
    private fun delete(node: Node){
        node.prev!!.next = node.next
        node.next!!.prev = node.prev
    }


}

/**
 * Node
 *
 * Doubly linked node
 *
 * @property value
 */
class Node(val value: Int){
    var prev: Node? = null
    var next: Node? = null

    /**
     * Delete
     *
     * A way to safely delete a node. Not needed if using  sentinel to create a circular pattern
     */
    fun delete(){
        if(prev != null)
            prev!!.next = next
        if(next != null)
            next!!.prev = prev
    }
}