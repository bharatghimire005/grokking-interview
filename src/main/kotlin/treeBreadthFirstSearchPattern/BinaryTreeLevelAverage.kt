package treeBreadthFirstSearchPattern

import java.util.*

class BinaryTreeLevelAverage {

    companion object {
        fun traveseTreeNode(root: TreeNode): List<Int> {
            var result = arrayListOf<Int>()
            var queue: Queue<TreeNode> = LinkedList()
            queue.offer(root)
            while (queue.isNotEmpty()) {
                var level = queue.size
                var currentLevel:Int=0
                for (i in 0 until level) {
                    var node=queue.poll()
                    currentLevel+=node.value
                   // currentLevel.add(node.value)
                    node.leftNode?.let {
                        queue.offer(it)
                    }
                    node.rightNode?.let {
                        queue.offer(it)
                    }
                }
                result.add(currentLevel/level)
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

    var traverseArray=BinaryTreeLevelAverage.traveseTreeNode(treeNode)
    println(traverseArray)
}