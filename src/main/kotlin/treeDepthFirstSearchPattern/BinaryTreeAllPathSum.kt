package treeDepthFirstSearchPattern

import treeBreadthFirstSearchPattern.BinaryTreeLevelAverage
import treeBreadthFirstSearchPattern.TreeNode
import java.util.ArrayList

class BinaryTreeAllPathSum {
    companion object {
        fun getAllPaths(rootNode: TreeNode, sum: Int) :List<List<Int>>{
            var allPath: ArrayList<List<Int>> = arrayListOf<List<Int>>()
            var currentPath: ArrayList<Int> = arrayListOf<Int>()
            findPathRecursively(rootNode, sum, allPath, currentPath)
            return allPath
        }

        private fun findPathRecursively(
            treeNode: TreeNode?,
            sum: Int,
            allPath: ArrayList<List<Int>>,
            currentPath: ArrayList<Int>
        ) {
            if (treeNode == null) {
                return
            }
            currentPath.add(treeNode.value)
            if (treeNode.value == sum && treeNode.leftNode == null && treeNode.rightNode == null) {
                allPath.add( currentPath.toList())
                currentPath.clear()
            }else{
                findPathRecursively(treeNode.leftNode, sum-treeNode.value, allPath, currentPath)
                findPathRecursively(treeNode.rightNode, sum-treeNode.value, allPath, currentPath)
            }
            currentPath.remove(currentPath.size-1)
        }


    }
}

fun main() {
    var treeNode: TreeNode = TreeNode(12)
    treeNode.leftNode = TreeNode(7)
    treeNode.rightNode = TreeNode(1)
    treeNode.leftNode?.leftNode = TreeNode(4)
    treeNode.rightNode?.leftNode = TreeNode(10)
    treeNode.rightNode?.rightNode = TreeNode(5)

    var traverseArray = BinaryTreeAllPathSum.getAllPaths(treeNode, 23)
    println(traverseArray)
}