data class Node(val value: Int, val left: Node? = null, val right: Node? = null)

class ImmutableBinaryTree(private val root: Node? = null) {

    fun insert(value: Int): ImmutableBinaryTree {
        fun insertNode(node: Node?): Node {
            return when {
                node == null -> Node(value)
                value < node.value -> Node(node.value, insertNode(node.left), node.right)
                else -> Node(node.value, node.left, insertNode(node.right))
            }
        }

        return ImmutableBinaryTree(insertNode(root))
    }

    fun contains(value: Int): Boolean {
        var current = root
        while (current != null) {
            if (value == current.value) return true
            current = if (value < current.value) current.left else current.right
        }
        return false
    }

    fun traverseInOrder(visit: (Int) -> Unit) {
        fun inOrder(node: Node?) {
            if (node != null) {
                inOrder(node.left)
                visit(node.value)
                inOrder(node.right)
            }
        }
        inOrder(root)
    }

}

fun main() {
    val tree = ImmutableBinaryTree()
        .insert(5)
        .insert(3)
        .insert(7)
        .insert(2)
        .insert(4)

    println("Contains 4: ${tree.contains(4)}")

    tree.traverseInOrder { value -> print("$value ")
        println("\n")
    }


}
