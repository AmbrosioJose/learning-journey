package II_Sorting_and_Order_Statistics.`8 Sorting in Linear Time`

fun bucketSort(list: MutableList<Double>){
    val buckets = MutableList<ListNode?>(list.size){null}

    for(i in list.indices){
        val bucketIndex = (list.size * list[i]).toInt()
        if(buckets[bucketIndex] == null)
            buckets[bucketIndex] = ListNode(list[i])
        else
            buckets[bucketIndex]!!.addToEnd(list[i])
    }

    for(i in buckets.indices){
        if(buckets[i] != null){
            println("sorting $i")
            printNodeList(buckets[i]!!)
            buckets[i] = insertionSortListNode(buckets[i]!!)
            printNodeList(buckets[i]!!)
        }
    }

    var i = 0
    var iteratingNode = ListNode(1.0)
    buckets.forEach{ bucket ->
        if(bucket!= null){
            iteratingNode = bucket
            list[i++] = bucket.value
            while(iteratingNode.next!= null){
                iteratingNode = iteratingNode.next!!
                list[i++] = iteratingNode.value
            }
        }
    }

}


fun swapNeighborNodes(a: ListNode, b: ListNode){
    a.next = b.next
    b.next = a
    b.prev = a.prev
    a.prev = b
    if(a.next != null)
        a.next!!.prev = a
    if(b.prev != null)
        b.prev!!.next = b
}

fun printNodeList(head: ListNode){
    var n = head
    print(" ${n.value} -> ")
    while (n.next != null) {
        n = n.next!!
        print(" ${n.value} -> ")
    }
    println()
}
fun insertionSortListNode(head: ListNode): ListNode{
    val sentinel = ListNode(0.0)
    sentinel.next = head
    head.prev = sentinel
    var currentNode = sentinel.next!!
    var insertingNode = currentNode
    var swapped = false

    while(currentNode.next != null){
        insertingNode = currentNode.next!!
        swapped = false
        while (insertingNode.prev?.prev != null && insertingNode.value < insertingNode.prev!!.value){
            swapped = true
            //swap inserting value
            swapNeighborNodes(insertingNode.prev!!, insertingNode)
        }
        if(!swapped &&  currentNode.next != null)
            currentNode = currentNode.next!!
    }
    // finished with sentinel so removing reference to it
    sentinel.next!!.prev = null
    return sentinel.next!!
}


class ListNode(val value: Double){
    var next: ListNode? = null
    var prev: ListNode? = null

    fun addToEnd(num: Double){
        if(next != null) {
            next!!.addToEnd(num)
        } else {
            next = ListNode(num)
            next!!.prev = this
        }
    }
}