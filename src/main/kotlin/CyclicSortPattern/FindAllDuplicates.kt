package CyclicSortPattern

/**
Problem Statement
We are given an unsorted array containing ānā numbers taken from the range 1 to ānā.
The array has some duplicates, find all the duplicate numbers without using any extra space.
Example 1:
Input: [3, 4, 4, 5, 5]
Output: [4, 5]
Example 2:
Input: [5, 4, 7, 2, 3, 5, 3]
Output: [3, 5]
 * */

fun main() {
println(findAllDuplicates(arrayOf(3, 4, 4, 5, 5)))
println(findAllDuplicates(arrayOf(5, 4, 7, 2, 3, 5, 3)))
}

fun findAllDuplicates(nums: Array<Int>): List<Int> {
    var allDuplicates = arrayListOf<Int>()
    var i = 0
    while (i < nums.size) {
        var j = nums[i] - 1
        if (nums[i] != nums[j]) {
            nums[i] = nums[j].also { nums[j] = nums[i] }
        } else {
            i++
        }
    }
    for ( k in nums.indices) {
        if (nums[k] != k + 1) {
            allDuplicates.add(nums[k])
        }
    }
    return allDuplicates
}

/*
Time complexity
The time complexity of the above algorithm is O(n).
Space complexity
Ignoring the space required for storing the duplicates, the algorithm runs in constant space O(1).
*/
