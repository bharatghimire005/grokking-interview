package twoPointersPattern


/*Problem Statement
Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects,
hence, we can’t count 0s, 1s, and 2s to recreate the array.
The flag of the Netherlands consists of three colors: red, white and blue;
and since our input array also consists of three different numbers that is why it is called Dutch National Flag problem.
Example 1:
Input: [1, 0, 2, 1, 0]
Output: [0 0 1 1 2]
Example 2:
Input: [2, 2, 0, 1, 2, 0]
Output: [0 0 1 2 2 2 ]*/


fun main() {
println("[1, 0, 2, 1, 0] -> ${getSortUseDutchNation(arrayOf(1, 0, 2, 1, 0)).contentToString()}")
println("[2, 2, 0, 1, 2, 0] -> ${getSortUseDutchNation(arrayOf(2, 2, 0, 1, 2, 0)).contentToString()}")
}

fun getSortUseDutchNation(arr: Array<Int>):Array<Int> {
    var i = 0
    var left = 0
    var right = arr.size - 1
    while (i <= right) {
        when (arr[i]) {
            0 -> {
                arr[i] = arr[left].also {
                    arr[left] = arr[i]
                }
                left += 1
                i += 1
            }
            2 -> {
                arr[i] = arr[right].also {
                    arr[right] = arr[i]
                }
                right -= 1
            }
            else -> {
                i += 1
            }
        }
    }
    return arr
}


/*
Time complexity
The time complexity of the above algorithm will be O(N) as we are iterating the input array only once.
Space complexity #
The algorithm runs in constant space O(1).*/
