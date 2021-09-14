package treeDepthFirstSearchPattern

import treeBreadthFirstSearchPattern.BinaryTreeLevelAverage
import treeBreadthFirstSearchPattern.TreeNode

class BinaryTreePathSum {
    companion object {
        fun hasPath(root: TreeNode?, sum: Int): Boolean {
            if (root == null) {
                return false;
            }
            if (root.value == sum && root.leftNode == null && root.rightNode == null) {
                return true
            }
            return hasPath(root.leftNode, sum - root.value) || hasPath(root.rightNode, sum - root.value)
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

    var traverseArray = BinaryTreePathSum.hasPath(treeNode, 22)
    println(traverseArray)
}