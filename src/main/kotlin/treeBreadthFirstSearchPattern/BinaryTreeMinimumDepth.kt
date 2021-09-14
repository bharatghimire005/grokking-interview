package treeBreadthFirstSearchPattern

import java.util.*

class BinaryTreeMinimumDepth {

    companion object {
        fun traveseTreeNode(root: TreeNode): Int {
            var queue: Queue<TreeNode> = LinkedList()
            queue.offer(root)
            var minimumDepth=0
            while (queue.isNotEmpty()) {
                var level = queue.size
                minimumDepth++
                for (i in 0 until level) {
                    var node=queue.poll()
                    node.leftNode?.let {
                        queue.offer(it)
                    }
                    node.rightNode?.let {
                        queue.offer(it)
                    }
                }
            }
            return minimumDepth
        }

    }
}


fun main() {
    var treeNode: TreeNode = TreeNode(12)
    treeNode.leftNode = TreeNode(7)
    treeNode.rightNode = TreeNode(1)
    treeNode.leftNode?.leftNode = TreeNode(9)
    treeNode.rightNode?.leftNode = TreeNode(10)
    treeNode.rightNode?.rightNode = TreeNode(5)
    treeNode.rightNode?.leftNode?.leftNode = TreeNode(11)

    var traverseArray=BinaryTreeMinimumDepth.traveseTreeNode(treeNode)
    println(traverseArray)
}