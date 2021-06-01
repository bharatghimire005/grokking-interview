package CyclicSortPattern


/*
Problem Statement
We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’.
The array has only one duplicate but it can be repeated multiple times.
Find that duplicate number without using any extra space. You are, however, allowed to modify the input array.
Example 1:
Input: [1, 4, 4, 3, 2]
Output: 4
Example 2:
Input: [2, 1, 3, 3, 5, 4]
Output: 3
Example 3:
Input: [2, 4, 1, 4, 4]
Output: 4
*/


fun main() {
    println(findDuplicate(arrayOf(1, 4, 4, 3, 2)))
    println(findDuplicate(arrayOf(2, 1, 3, 3, 5, 4)))
    println(findDuplicate(arrayOf(2, 4, 1, 4, 4)))
}

fun findDuplicate(nums: Array<Int>): Int {
    var i = 0
    while (i < nums.size) {
        if (nums[i] != i + 1) {
            var j = nums[i] - 1
            if (nums[i] != nums[j]) {
                nums[i] = nums[j].also {
                    nums[j] = nums[i]
                }
            } else {
                return nums[i]
            }
        }else{
            i++
        }
    }
    return -1
}

/*
 Time complexity
The time complexity of the above algorithm is O(n).
Space complexity
The algorithm runs in constant space O(1) but modifies the input array.
*/
