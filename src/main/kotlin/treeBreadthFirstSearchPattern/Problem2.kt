package treeBreadthFirstSearchPattern

import java.util.*

class Problem2 {

    companion object {
        fun traveseTreeNode(root: TreeNode): List<TreeNode> {
            var result = arrayListOf<TreeNode>()
            var queue: Queue<TreeNode> = LinkedList()
            queue.offer(root)
            while (queue.isNotEmpty()) {
                var level = queue.size
                for (i in 0 until level) {
                    var node=queue.poll()
                    if(i==level-1){
                        result.add(node)
                    }
                    node.leftNode?.let {
                        queue.offer(it)
                    }
                    node.rightNode?.let {
                        queue.offer(it)
                    }
                }
            }
            return result
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

    val traverseArray=Problem2.traveseTreeNode(treeNode)
    println(traverseArray)
}