package twoPointersPattern

import kotlin.math.abs

/*
Triplet Sum Close to Target (medium)
Problem Statement
Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the target number as possible, return the sum of the triplet.
If there are more than one such triplet, return the sum of the triplet with the smallest sum.
Example 1:
Input: [-2, 0, 1, 2], target=2
Output: 1
Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
Example 2:
Input: [-3, -1, 1, 2], target=1
Output: 0
Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
Example 3:
Input: [1, 0, 1, 1], target=100
Output: 3
Explanation: The triplet [1, 1, 1] has the closest sum to the target.*/

fun main() {
    println(" getTripletSumCloseToTarget([-2, 0, 1, 2], 2) ->  ${getTripletSumCloseToTarget(arrayOf(-2, 0, 1, 2), 2)} ")
    println(
        " getTripletSumCloseToTarget([-3, -1, 1, 2], 1) ->  ${
            getTripletSumCloseToTarget(
                arrayOf(-3, -1, 1, 2),
                1
            )
        } "
    )
}


fun getTripletSumCloseToTarget(arr: Array<Int>, target: Int): Int {
    var targetClose = Int.MAX_VALUE
    arr.sort()
    for (i in arr.indices - 2) {
        var left = i + 1
        var right = arr.size - 1
        while (left < right) {
            var closeToTarget = target - (arr[i] + arr[left] + arr[right])
            if (closeToTarget == 0)
                return target
            if (closeToTarget > 0) {
                left++
            } else {
                right--
            }
            if (abs(closeToTarget) < abs(targetClose)) {
                targetClose = closeToTarget
            }
        }

    }
    return target - targetClose
}

/*
 Time complexity
Sorting the array will take O(N* logN)O(N∗logN). Overall searchTriplet() will take O(N * logN + N^2),
which is asymptotically equivalent to O(N^2).
Space complexity
The space complexity of the above algorithm will be O(N) which is required for sorting
.*/