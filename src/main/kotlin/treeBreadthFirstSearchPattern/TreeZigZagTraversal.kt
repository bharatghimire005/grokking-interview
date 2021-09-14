package treeBreadthFirstSearchPattern

import java.util.*

class TreeZigZagTraversal {

    companion object {
        fun traveseTreeNode(root: TreeNode): List<List<Int>> {
            var result = arrayListOf<List<Int>>()
            var queue: Queue<TreeNode> = LinkedList()
            queue.offer(root)
            while (queue.isNotEmpty()) {
                var level = queue.size
                var currentLevel= arrayListOf<Int>()
                for (i in 0 until level) {
                    var node=queue.poll()
                    currentLevel.add(node.value)
                    node.leftNode?.let {
                        queue.offer(it)
                    }
                    node.rightNode?.let {
                        queue.offer(it)
                    }
                }
                result.add(currentLevel)
            }
            return result
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

    var traverseArray=TreeZigZagTraversal.traveseTreeNode(treeNode)
    println(traverseArray)
}