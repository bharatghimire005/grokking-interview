package treeBreadthFirstSearchPattern

import java.util.*

class BinaryTreeLevelOrderSuccessor {

    companion object {
        fun traveseTreeNode(root: TreeNode, key: Int): TreeNode? {

            var queue: Queue<TreeNode> = LinkedList()
            queue.add(root)
            while (queue.isNotEmpty()) {

                var treeNode = queue.poll()
                treeNode.leftNode?.let {
                    queue.offer(it)
                }
                treeNode.rightNode?.let {
                    queue.offer(it)
                }
                if (treeNode.value == key) {
                    break;
                }
            }
            return queue.peek()
        }
    }
}

fun main() {
    val treeNode: TreeNode = TreeNode(12)
    treeNode.leftNode = TreeNode(7)
    treeNode.rightNode = TreeNode(1)
    treeNode.leftNode?.leftNode = TreeNode(9)
    treeNode.rightNode?.leftNode = TreeNode(10)
    treeNode.rightNode?.rightNode = TreeNode(5)
    treeNode.rightNode?.leftNode?.leftNode = TreeNode(11)

    val traverseArray=BinaryTreeLevelOrderSuccessor.traveseTreeNode(treeNode,5)
    println(traverseArray?.value)
}