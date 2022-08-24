package III_Data_Structures._14_Augmenting_Data_Structures


/**
 * Order statistic red black tree
 *
 * Provides an easy solution to find the position of a number in the linear order determined by an
 * inorder tree walk of this Order Statistic Tree
 *
 * @constructor Create empty Order Statistic Red black trees
 */


class OrderStatisticTree {
    private val nil: OSNode = OSNode(0)
    var root: OSNode = nil

    init{
        nil.color = COLOR.BLACK
    }
    /**
     * Search
     *
     * Similar to binary search except its worst-case time is θ(lgn) where n is the total number of nodes.
     *
     * @param value
     * @return [OSNode] that matches the value otherwise returns null
     */
    fun search(value: Int): OSNode?{
        var currentNode = root
        while(currentNode != nil && currentNode.value != value){
            if(currentNode.value < value)
                currentNode = currentNode.right!!
            else currentNode = currentNode.left!!
        }
        if(currentNode == nil) return null
        return currentNode
    }

    /**
     * Insert
     *
     * Finds the correct position to insert new node within the Red black tree then calls [rbInsertFixUp]
     * to ensure that the red black tree's properties are preserved
     *
     * 1) Find correct position to insert new node
     * 2) Connect new node to its parent
     * 3) Color node
     * 4) Call [rbInsertFixUp]
     *
     * @param insertingNode
     */
    fun insert(insertingNode: OSNode){
//        println("Inserting: ${insertingNode.value} ")
        var parentNode: OSNode? = nil
        var navigationNode = root
        while(navigationNode != nil){ // find place to insert node
            parentNode = navigationNode
            navigationNode.size++
            if(insertingNode.value < navigationNode.value) {
                navigationNode = navigationNode.left!!
            } else navigationNode = navigationNode.right!!
        }

        // connect new node to it's parent
        insertingNode.parent = parentNode
        if(parentNode == nil)
            root = insertingNode
        else if(insertingNode.value < parentNode!!.value)
            parentNode.left = insertingNode
        else
            parentNode.right = insertingNode

        insertingNode.color = COLOR.RED
        insertingNode.left = nil
        insertingNode.right = nil
        insertingNode.size = 1
        rbInsertFixUp(insertingNode)
    }

    /**
     * Insert
     *
     * Creates a node of the given value and calls the [insert] method
     * @see insert
     *
     * @param value
     */
    fun insert(value: Int) {
        insert(OSNode(value))
    }


    /**
     * Rb insert fix up
     *
     * Used to guarantee that the Red Black trees properties are maintained.
     * There are a couple of cases that require specific action:
     * Note: These cases assume that the node was inserted as a left leaf child of a node on the left side of the root's
     * children. These cases are reflected when the inserting node is added as a right child
     *
     * 1) [node]'s uncle is red
     *   Action: Change Colors
     *     - Parent and uncle are turned black while
     *     - Grandparent is turned red
     *     - Make the grandparent the new focus node
     * 2) [node]'s uncle is black and [node] is a right child(triangle)
     *   Action: left rotate on the parent
     *     - Set [node]'s parent as the new focus node
     *     - Left rotate on it
     *
     * 3) [node]'s uncle is black and [node] is a left child (line)
     *   Action: Color and right rotate
     *     - Color the focus node's parent black
     *     - Color the focus node's grand parent red
     *     - Right rotate on the focus node's grandparent
     *
     * @param node
     */
    private fun rbInsertFixUp(node: OSNode){
        var focusNode = node
        while(focusNode.parent!!.color == COLOR.RED){
            if(focusNode.parent!! == focusNode.parent!!.parent!!.left){
                val uncle: OSNode = focusNode.parent!!.parent!!.right!!
                if(uncle.color == COLOR.RED) { // case 1
                    uncle.color = COLOR.BLACK
                    focusNode.parent!!.color = COLOR.BLACK
                    focusNode.parent!!.parent!!.color = COLOR.RED
                    focusNode = focusNode.parent!!.parent!!
                }
                else {
                    if(focusNode == focusNode.parent!!.right){ // case 2
                        focusNode = focusNode.parent!!
                        leftRotate(focusNode)
                    }
                    focusNode.parent!!.color = COLOR.BLACK // case 3
                    focusNode.parent!!.parent!!.color = COLOR.RED
                    rightRotate(focusNode.parent!!.parent!!)
                }
            } else {
                val uncle: OSNode = focusNode.parent!!.parent!!.left!!
                if(uncle.color == COLOR.RED){ // case 1
                    uncle.color = COLOR.BLACK
                    focusNode.parent!!.color = COLOR.BLACK
                    focusNode.parent!!.parent!!.color = COLOR.RED
                } else {
                    if(focusNode == focusNode.parent!!.left){ // case 2
                        focusNode = focusNode.parent!!
                        rightRotate(focusNode)
                    }

                    focusNode.parent!!.color = COLOR.BLACK // case 3
                    focusNode.parent!!.parent!!.color = COLOR.RED
                    leftRotate(focusNode.parent!!.parent!!)
                }
            }
        }
        if(root != nil) root.color = COLOR.BLACK
    }

    /**
     * Left rotate
     *
     * Left rotate assumes [rotatingNode]'s is a non-null right child
     * We use a node x which is a non-null parent of [rotatingNode]. The left rotation
     * "pivots" around the link from x to y. It "increases" the value of the root
     *
     * 1) Turn y's left subtree into x's right subtree
     * 2) Link x's parent to y
     * 3) Set x as y's left child
     *
     *
     *     |                        |
     *     y     right rotate       x
     *    / \         ->           / \
     *   x   ¥                    å   y
     *  / \      left rotate         / \
     * å  ∫           <-            ∫   ¥
     *
     *
     * @param rotatingNode
     */
    fun leftRotate(rotatingNode: OSNode){
        val newSubRoot = rotatingNode.right
        rotatingNode.right = newSubRoot!!.left // turn y's left subtree into x's right subtree
        if(newSubRoot.left != nil){
            newSubRoot.left!!.parent = rotatingNode
        }
        newSubRoot.parent = rotatingNode.parent // link x's parent to y
        if(newSubRoot.parent == nil){
            root = newSubRoot
        } else if(rotatingNode == rotatingNode.parent!!.left)
            rotatingNode.parent!!.left = newSubRoot
        else
            rotatingNode.parent!!.right = newSubRoot

        newSubRoot.left = rotatingNode // put x as y's left child
        rotatingNode.parent = newSubRoot
        newSubRoot.size = rotatingNode.size
        rotatingNode.size = rotatingNode.left!!.size + rotatingNode.right!!.size + 1
    }

    /**
     * Right rotate
     *
     * Right rotate assumes [rotatingNode]'s (y) is a non-null let child
     * We use a node x which is a non-null parent of [rotatingNode]. The left rotation
     * "pivots" around the link from x to y. It "decreases" the value of the root
     *
     * 1) Turn x's right subtree into y's left subtree
     * 2) Link y's parent to x
     * 3) Set y as x's right child
     *
     *
     *     |                        |
     *     y     right rotate       x
     *    / \         ->            / \
     *   x   ¥                    å   y
     *  / \      left rotate         / \
     * å  ∫           <-            ∫   ¥
     *
     * @param rotatingNode
     */
    fun rightRotate(rotatingNode: OSNode){
        val newSubRoot = rotatingNode.left
        rotatingNode.left = newSubRoot!!.right // Turn x's right subtree into y's left subtree
        if(newSubRoot.right != nil){
            newSubRoot.right!!.parent = rotatingNode
        }
        newSubRoot.parent = rotatingNode.parent // Link y's parent to x
        if(newSubRoot.parent == nil)
            root = newSubRoot
        else if(rotatingNode == rotatingNode.parent!!.left)
            rotatingNode.parent!!.left = newSubRoot
        else
            rotatingNode.parent!!.right = newSubRoot

        newSubRoot.right = rotatingNode // Set y as x's left child
        rotatingNode.parent = newSubRoot
        newSubRoot.size = rotatingNode.size
        rotatingNode.size = rotatingNode.left!!.size + rotatingNode.right!!.size + 1
    }

    /**
     * Delete
     *
     * @param value
     */
    fun delete(value: Int){
        val deletingNode = search(value) ?: return
        delete(deletingNode)
    }

    /**
     * Delete
     *
     * Cases:
     *
     * 1) [deletingNode] left child is nil
     *   Action: successor is right child replace deleting node
     *
     * 2) [deletingNode] right child is nil
     *   Action: successor is left child replace deleting node
     *
     * 3) [deletingNode] both children are not nil
     *   Action: successor is minimum of deleting nodes right subtree
     *
     * if (deletingNode's color was black or case 3 happened and successor's color is black)
     *   fixUp([successor])
     *
     * @param deletingNode
     */
    fun delete(deletingNode: OSNode){
        var focusNode = deletingNode
        var originalColor = deletingNode.color
        var successor: OSNode? = null
        if(deletingNode.left == nil){
            decreaseAncestorRanks(deletingNode)
            successor = deletingNode.right!!
            transplant(deletingNode, successor)
        } else if(deletingNode.right == nil){
            decreaseAncestorRanks(deletingNode)
            successor = deletingNode.left!!
            transplant(deletingNode, successor)
        } else {
            focusNode = minimum(deletingNode.right!!) // successor(focusNode) will be the smallest node in the right subtree
            originalColor = focusNode.color
            successor = focusNode.right
            decreaseAncestorRanks(deletingNode)
            if(focusNode.parent == deletingNode)
                successor!!.parent = focusNode
            else {
                transplant(focusNode, focusNode.right!!) // move right child of minimum(focusNode) to the focusNode's position since focusNode will be moved
                focusNode.right = deletingNode.right
                focusNode.right!!.parent = focusNode
            }
            transplant(deletingNode, focusNode) // move the focusNode to the deleting node's position
            focusNode.left = deletingNode.left
            focusNode.left!!.parent = focusNode
            focusNode.color = deletingNode.color
            focusNode.size = deletingNode.size

        }

        if(originalColor == COLOR.BLACK)
            deleteFixUp(successor!!)

    }

    /**
     * Delete fix up
     *
     * Given a [node] (successor to the deleted node) make adjustments to maintain red black tree properties.
     * Similar to insertion fix up [deleteFixUp] handles cases that are "reflected" depending on whether [node]
     * is a right child or a left child.
     *
     * Cases assuming [node] is a left (reflected for right)
     * We keep going through the loop that handles the cases is [focusNode] ≠ root and [focusNode].color ≠ BLACK
     *
     * Cases:
     * 1) [node]'s sibling is red
     *    Action: Color sibling and parent then left rotate parent
     *      - color sibling black
     *      - color parent red
     *      - left rotate parent
     *      - sibling is now parent's right child
     *
     *  followed by 2 paths (case 1 does not exclude other cases)
     *  2 paths:
     *    1st (both siblings are black (case 2))
     *    2nd (one of the children is red (case 4 and possibly case 3))
     *
     * 2) [node]'s sibling is black and both of it's children are black
     *    Action: color sibling and [node] (actually [focusNode]) now points to it's parent
     *      - color sibling red
     *      - make [focusNode] point to it's parent
     *
     *
     * 3) [node]'s sibling is black. It's left child is red, and it's right child black
     *    Action: Color sibling, and it's left child then right rotate sibling.
     *      - Color the sibling's left black
     *      - Color the sibling red
     *      - Right rotate sibling
     *      - sibling is now the [focusNode]'s parent's right child
     *
     *
     * 4) [node]'s sibling is black and the right child is red
     *    Action: Color sibling, focusNode parent, and sibling's right child. left rotate sibling's parent
     *      - Color sibling with [node]'s parent's color
     *      - [node]'s parent's color is set to black
     *      - Color sibling's right color to black
     *      - Left rotate [node]'s parent
     *
     *    set the focusNode to the root (for 2nd path only)
     *
     *    set the focusNode color to black
     *
     *
     * if(case1) case 1 action
     * if(case2) case 2 action
     *
     * else
     *   if(case3) case 3 action
     *   case4 case 4 action
     *
     *
     * @param node
     */
    private fun deleteFixUp(node: OSNode){
//        println("deleteFix Up ${if(node == nil) "nil" else node.toBasicString()}")
        var focusNode = node
        while(focusNode != root && focusNode.color == COLOR.BLACK){
            if(focusNode == focusNode.parent!!.left){
                var sibling = focusNode.parent!!.right!!
                if(sibling.color == COLOR.RED){ // case 1
                    sibling.color = COLOR.BLACK
                    focusNode.parent!!.color = COLOR.RED
                    leftRotate(focusNode.parent!!)
                    sibling = focusNode.parent!!.right!!
                }
                if(sibling.left!!.color == COLOR.BLACK && sibling.right!!.color == COLOR.BLACK){ // case 2
                    sibling.color = COLOR.RED
                    focusNode = focusNode.parent!!
                } else {
                    if(sibling.right!!.color == COLOR.BLACK){ // case 3
                        sibling.left!!.color = COLOR.BLACK
                        sibling.color = COLOR.RED
                        rightRotate(sibling)
                        sibling = focusNode.parent!!.right!!
                    }
                    sibling.color = focusNode.parent!!.color // case 4
                    focusNode.parent!!.color = COLOR.BLACK
                    sibling.right!!.color = COLOR.BLACK
                    leftRotate(focusNode.parent!!)
                    focusNode = root
                }
            } else {
                if(focusNode == focusNode.parent!!.right){
                    var sibling = focusNode.parent!!.left!!
                    if(sibling.color == COLOR.RED){ // case 1
                        sibling.color = COLOR.BLACK
                        focusNode.parent!!.color = COLOR.RED
                        rightRotate(focusNode.parent!!)
                        sibling = focusNode.parent!!.left!!
                    }
                    if(sibling.left!!.color == COLOR.BLACK && sibling.right!!.color == COLOR.BLACK){ // case 2
                        sibling.color = COLOR.RED
                        focusNode = focusNode.parent!!
                    } else {
                        if(sibling.left!!.color == COLOR.BLACK){ // case 3
                            sibling.right!!.color = COLOR.BLACK
                            sibling.color = COLOR.RED
                            leftRotate(sibling)
                            sibling = focusNode.parent!!.left!!
                        }
                        sibling.color = focusNode.parent!!.color // case 4
                        focusNode.parent!!.color = COLOR.BLACK
                        sibling.left!!.color = COLOR.BLACK
                        rightRotate(focusNode.parent!!)
                        focusNode = root
                    }
                }
            }
        }
        focusNode.color = COLOR.BLACK
    }

    fun decreaseAncestorRanks(node: OSNode){
        var currentNode = node
        while(currentNode != nil){
            if(currentNode.parent != nil && currentNode.parent!!.left == currentNode)
                currentNode.parent!!.size--
            currentNode = currentNode.parent!!
        }
    }

    /**
     * Transplant
     *
     * Node [a] is replaced by node [b].
     *
     * @param a
     * @param b
     */
    private fun transplant(a: OSNode, b: OSNode){
        if(a.parent == nil){
            root = b
        } else if(a.parent!!.left == a)
            a.parent!!.left = b
        else
            a.parent!!.right = b
        b.parent = a.parent
    }

    /**
     * Minimum
     *
     * The minimum is the left most node with the [node] tree
     *
     * @param node
     * @return the node with the smallest value of the given tree
     */
    fun minimum(node: OSNode): OSNode{
        var currentNode = node
        while(node.left != nil)
            currentNode = currentNode.left!!
        return currentNode
    }

    /**
     * Maximum
     *
     * The maximum is the right most node with the [node] tree
     *
     * @param node
     * @return the node with the largest value for a given tree
     */
    fun maximum(node: OSNode): OSNode{
        var currentNode = node
        while(node.right != nil)
            currentNode = currentNode.right!!
        return currentNode
    }

    /**
     * Predecessor
     *
     * The node with the
     *
     * @param node
     * @return
     */
    fun predecessor(node: OSNode): OSNode? {
        return node
    }

    /**
     * Successor
     *
     * @param node
     * @return
     */
    fun successor(node: OSNode): OSNode? {
        return node
    }


    /**
     * RBTransplant
     *
     * Node [a] is replaced by node [b].
     *
     * @param a
     * @param b
     */
    fun rbTransplant(a: OSNode, b: OSNode){

    }

    /**
     * In order print
     *
     * Prints the values of nodes in the given tree in sorted order
     *
     * @param node
     */
    fun inOrderPrint(node: OSNode?){
        if(node != nil){
            inOrderPrint(node!!.left)
            print(" ${node.value}(${node.color} parent = ${node.parent!!.value}})")
            inOrderPrint(node.right)
        }
    }

    /**
     * In order print
     *
     *  Starting at the root prints the values of nodes in the given tree in sorted order
     *
     */
    fun inOrderPrint(){
        inOrderPrint(root)
    }


    /**
     * Print tree
     *
     * Prints the tree in a visual format
     *
     * @param root
     */
    fun printTree(root: OSNode?) {
        val lines: MutableList<List<String?>> = ArrayList()
        var level: MutableList<OSNode?> = ArrayList<OSNode?>()
        var next: MutableList<OSNode?> = ArrayList<OSNode?>()
        level.add(root)
        var nn = 1
        var widest = 0
        while (nn != 0) {
            val line: MutableList<String?> = ArrayList()
            nn = 0
            for (n in level) {
                if (n == null) {
                    line.add(null)
                    next.add(null)
                    next.add(null)
                } else {
                    val aa: String = n.toBasicString()
                    line.add(aa)
                    if (aa.length > widest) widest = aa.length
                    next.add(n.left)
                    next.add(n.right)
                    if (n.left != null) nn++
                    if (n.right != null) nn++
                }
            }
            if (widest % 2 == 1) widest++
            lines.add(line)
            val tmp: MutableList<OSNode?> = level
            level = next
            next = tmp
            next.clear()
        }
        var perpiece = lines[lines.size - 1].size * widest
        for (i in lines.indices) {
            val line = lines[i]
            val hpw = Math.floor((perpiece / 2f).toDouble()).toInt() - 1
            if (i > 0) {
                for (j in line.indices) {

                    // split node
                    var c = ' '
                    if (j % 2 == 1) {
                        if (line[j - 1] != null) {
                            c = if (line[j] != null) '┴' else '┘'
                        } else {
                            if (j < line.size && line[j] != null) c = '└'
                        }
                    }
                    print(c)

                    // lines and spaces
                    if (line[j] == null) {
                        for (k in 0 until perpiece - 1) {
                            print(" ")
                        }
                    } else {
                        for (k in 0 until hpw) {
                            print(if (j % 2 == 0) " " else "─")
                        }
                        print(if (j % 2 == 0) "┌" else "┐")
                        for (k in 0 until hpw) {
                            print(if (j % 2 == 0) "─" else " ")
                        }
                    }
                }
                println()
            }

            // print line of numbers
            for (j in line.indices) {
                var f = line[j]
                if (f == null) f = ""
                val gap1 = Math.ceil((perpiece / 2f - f.length / 2f).toDouble()).toInt()
                val gap2 = Math.floor((perpiece / 2f - f.length / 2f).toDouble()).toInt()

                // a number
                for (k in 0 until gap1) {
                    print(" ")
                }
                print(f)
                for (k in 0 until gap2) {
                    print(" ")
                }
            }
            println()
            perpiece /= 2
        }
    }


    /**
     * Print tree
     *
     * Prints the tree in a visual format starting at the root of this [OrderStatisticTree]
     */
    fun printTree(){
        printTree(root)
    }


    /**
     * Select ith node
     *
     * Retrieves an element with a given rank
     *
     * @param node
     * @param i
     * @return the ith smallest key in the subtree rooted at [node]
     */
    fun selectIthAfter(node: OSNode, i: Int): OSNode{
        val nodeRank = node.left!!.size + 1
        if(i == nodeRank)
            return node
        if(i < nodeRank)
            return selectIthAfter(node.left!!, i)
        return selectIthAfter(node.right!!, i - nodeRank)
    }

    /**
     * Rank
     *
     * @param node
     * @return the position of [node] in the linear order determined by an inorder tree walk of this Order Statistic Tree
     */
    fun rank(node: OSNode): Int{
        var rank = node.left!!.size + 1
        var currentNode = node
        while(currentNode != root){
            if(currentNode == currentNode.parent!!.right)
                rank += currentNode.parent!!.left!!.size + 1
            currentNode = currentNode.parent!!
        }
        return rank
    }

}