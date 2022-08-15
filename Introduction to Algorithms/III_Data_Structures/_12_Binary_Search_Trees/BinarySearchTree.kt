package III_Data_Structures._12_Binary_Search_Trees

class BinarySearchTree {
    var root: Node? = null

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

    fun recursiveSearch(node: Node?, value: Int): Node?{
       if(node?.value == null)
           return node

        if (node.value < value)
            return recursiveSearch(node.left, value)

        return recursiveSearch(node.right, value)
    }

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

    fun treeMinimum(node: Node): Node{
        var curr = node
        while(node.left != null){
            curr = node.left!!
        }
        return curr
    }

    fun treeMaximum(node: Node): Node {
        var curr = node
        while(node.right != null){
            curr = node.right!!
        }
        return curr
    }

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

    fun inOrderPrint(node: Node?){
        if(node != null){
            inOrderPrint(node.left)
            print(" ${node.value}")
            inOrderPrint(node.right)
        }
    }
}