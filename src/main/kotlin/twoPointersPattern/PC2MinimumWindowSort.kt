package twoPointersPattern

import java.lang.Integer.min
import kotlin.math.max

/*
Problem Challenge 3
Minimum Window Sort (medium)
Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.
Example 1:
Input: [1, 2, 5, 3, 7, 10, 9, 12]
Output: 5
Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted
Example 2:
Input: [1, 3, 2, 0, -1, 7, 10]
Output: 5
Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted
Example 3:
Input: [1, 2, 3]
Output: 0
Explanation: The array is already sorted
Example 4:
Input: [3, 2, 1]
Output: 3
Explanation: The whole array needs to be sorted.
*/

fun main() {
        println("[1, 2, 5, 3, 7, 10, 9, 12] ->${getMinimumWindowSortCount(arrayOf(1, 2, 5, 3, 7, 10, 9, 12))}")
        println("[1, 3, 2, 0, -1, 7, 10] ->${getMinimumWindowSortCount(arrayOf(1, 3, 2, 0, -1, 7, 10))}")
        println("[1, 2, 3] ->${getMinimumWindowSortCount(arrayOf(1, 2, 3))}")
        println("[3, 2, 1] ->${getMinimumWindowSortCount(arrayOf(3, 2, 1))}")
}

fun getMinimumWindowSortCount(array: Array<Int>): Int {
    var low = 0
    var high = array.size - 1
    while (low < array.size - 1 && array[low] <= array[low + 1]) {
        low += 1
    }
    if(low==array.size-1){
        return 0
    }
    while (high > 0  && array[high] >= array[high - 1]) {
        high -= 1
    }
    var maxOfSubArray=Int.MIN_VALUE
    var minOfSubArray=Int.MAX_VALUE
    for(i in array.copyOfRange(low,high)){
        maxOfSubArray= max(i,maxOfSubArray)
        minOfSubArray= min(i,minOfSubArray)
    }
    while (low>0 && array[low-1]>minOfSubArray){
        low-=1
    }
    while (high<array.size-1 && array[high+1]<maxOfSubArray){
        high+=1
    }
    return high-low+1
}

/*
Time complexity
The time complexity of the above algorithm will be O(N)O(N).
Space complexity
The algorithm runs in constant space O(1)O(1).*/
