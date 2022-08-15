package III_Data_Structures._12_Binary_Search_Trees

/**
 * Binary search tree
 *
 * Let x be a node in a binary search tree.
 * If y is a node in the left subtree of x, then y.value <= x.value.
 * If y is a node in the right subtree of x, then y.value <= x.value.
 *
 * Basic operations take θ(h) worst-case time, where h is the height of the tree.
 * In a binary search tree take θ(lgn) time but if the tree is a linear chain of nodes
 * the worst-case time is θ(n). This can be deterred by adding inputs randomly. A red black tree can also be used.
 *
 * @constructor Create empty Binary search tree
 */
class BinarySearchTree {
    var root: Node? = null

    /**
     * Insert
     *
     * When inserting a new value it must be done in a way that preserves the binary search tree properties
     *
     * @param insertingNode
     */
    fun insert(insertingNode: Node){
        var currentNode = root
        var insertingNodeParent : Node? = null

        while(currentNode != null){
            insertingNodeParent = currentNode
            if(insertingNode.value < currentNode.value){
                currentNode = currentNode.left
            }
            else currentNode = currentNode.right
        }
        insertingNode.parent = insertingNodeParent
        if(insertingNodeParent == null)
            root = insertingNode
        else if( insertingNode.value < insertingNodeParent.value)
            insertingNodeParent.left = insertingNode
        else
            insertingNodeParent.right = insertingNode
    }

    /**
     * Search
     *
     * Takes O(h) worst-case time, where h is the height of the tree.
     *
     * @param value
     * @return
     */
    fun search(value: Int): Node? {
        var curr = root
        while(curr != null && curr.value != value){
            if(value < curr.value)
                curr = curr.left
            else
                curr = curr.right
        }
        return curr
    }

    /**
     * Recursive search
     *
     * Similar to search but done recursively. Iteratively is usually more efficient in most computers
     * @see search
     *
     *
     * @param node
     * @param value
     * @return Node with matching value if it exists within the given tree. Otherwise null
     */
    fun recursiveSearch(node: Node?, value: Int): Node?{
        if(node?.value == null)
            return node

        if (node.value < value)
            return recursiveSearch(node.left, value)

        return recursiveSearch(node.right, value)
    }

    fun delete(value: Int) {
        val deletingNode = search(value)
        if(deletingNode != null)
            deleteNode(deletingNode)
    }

    /**
     * Delete node
     *
     * a) If [deletingNode] has no left child, transplant right child into deletingNode's position
     *
     * b) If [deletingNode] has no right child transplant left child into deletingNode's position
     *
     * c)
     *        q                            q
     *        |                            |
     *        o z                          o y
     *      /  \                         /  \
     * l o       o y        =>        l o    o x
     * /  \    /  \
     *       NIL   o x
     *            / \
     *
     * d)
     *        q                            q                                             q
     *        |                            |                                             |
     *        o z                          o z                  o y                      o y
     *      /  \                         /                    /   \                     / \
     * l o       o r        =>        l o                   NIL    o r     =>        l o   o r
     * /  \    / \                                               /                       /
     *       /                                                 /                        /
     *       o y                                              o  x                     o  x
     *      / \                                              / \
     *    NIL  o x
     *
     * @param deletingNode
     */
    fun deleteNode(deletingNode: Node){
        if(deletingNode.left == null)
            transplant(deletingNode, deletingNode.right)
        else if(deletingNode.right == null)
            transplant(deletingNode, deletingNode.left)
        else {
            val rightMin =  treeMinimum(deletingNode.right!!)
            if(deletingNode != rightMin.parent){
                transplant(rightMin, rightMin.right)
                rightMin.right = deletingNode.right
                rightMin.right!!.parent = rightMin
            }
            transplant(deletingNode, rightMin)
            rightMin.left = deletingNode.left
            rightMin.left!!.parent = rightMin
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
    private fun transplant(a: Node, b: Node?){
        if(a.parent == null)
            root = b
        else if(a == a.parent!!.left)
            a.parent!!.left = b
        else
            a.parent!!.right = b
        if(b != null)
            b.parent = a.parent
    }


    /**
     * Tree minimum
     *
     * The smallest value is always the left most node
     *
     * @param node
     *
     * @return Node with the smallest value within the [node] subtree
     */
    fun treeMinimum(node: Node): Node{
        var curr = node
        while(node.left != null){
            curr = node.left!!
        }
        return curr
    }

    /**
     * Tree maximum
     *
     * The largest value is always the right most node
     *
     * @param node
     * @return the largest value in the node subtree
     */
    fun treeMaximum(node: Node): Node {
        var curr = node
        while(node.right != null){
            curr = node.right!!
        }
        return curr
    }


    /**
     * Tree successor
     *
     * @param node
     * @return The node with the smallest value greater than [node.value]
     */
    fun treeSuccessor(node: Node): Node?{
        if(node.right != null)
            return treeMinimum(node.right!!)
        var currNode = node
        var currParentNode = node.parent
        while(currParentNode != null && currParentNode.right == node){
            currNode = currParentNode
            currParentNode = currParentNode.parent
        }
        return currParentNode
    }


    /**
     * Tree predecessor
     *
     * @param node
     * @return The node with the largest value smaller than [node.value]
     */
    fun treePredecessor(node: Node): Node? {
        if(node.left != null)
            return treeMaximum(node.left!!)
        var currNode = node
        var currParentNode = node.parent
        while(currParentNode != null && currParentNode.left == node){
            currNode = currParentNode
            currParentNode = currParentNode.parent
        }
        return currParentNode
    }

    /**
     * In order print
     *
     * Prints the values of nodes in the given tree in sorted order
     *
     * @param node
     */
    fun inOrderPrint(node: Node?){
        if(node != null){
            inOrderPrint(node.left)
            print(" ${node.value}")
            inOrderPrint(node.right)
        }
    }

    /**
     * Pre-order print
     *
     * Prints the values of nodes in the given tree by printing the parent first then its children
     *
     * @param node
     */
    fun preOrder(node: Node?){
        if(node != null){
            print(" ${node.value}")
            inOrderPrint(node.left)
            inOrderPrint(node.right)
        }
    }

    /**
     * Post order print
     *
     * Prints the values of nodes in the given tree by printing the parent after the children are printed
     *
     * @param node
     */
    fun postOrderPrint(node: Node?){
        if(node != null){
            inOrderPrint(node.left)
            inOrderPrint(node.right)
            print(" ${node.value}")
        }
    }
}