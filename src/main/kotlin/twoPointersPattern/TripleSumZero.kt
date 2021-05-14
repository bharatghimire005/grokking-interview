package twoPointersPattern


/*Problem Statement
Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
Example 1:
Input: [-3, 0, 1, 2, -1, 1, -2]
Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
Explanation: There are four unique triplets whose sum is equal to zero.
Example 2:
Input: [-5, 2, -1, -2, 3]
Output: [[-5, 2, 3], [-2, -1, 3]]
Explanation: There are two unique triplets whose sum is equal to zero.*/

fun main() {
 println("{-3, 0, 1, 2, -1, 1, -2} triplets are ${tripleSumZero(arrayOf(-3, 0, 1, 2, -1, 1, -2))}")
}

fun tripleSumZero(arr: Array<Int>): List<List<Int>> {
    val triplets = arrayListOf<List<Int>>()
    arr.sort()
    for (i in arr.indices) {
        if (i > 0 && arr[i] == arr[i - 1]) continue
        getTriplet(arr, i + 1,-arr[i], triplets)
    }
    return triplets
}

fun getTriplet(arr: Array<Int>, left: Int, targetSum: Int, triplets: ArrayList<List<Int>>) {
    var right = arr.size - 1
    var lefts = left
    while (lefts < right) {
        val currentSum = arr[lefts] + arr[right]
        when {
            targetSum == currentSum -> {
                triplets.add(listOf(-targetSum,arr[lefts], arr[right]))
                lefts+=1
                right-=1
                while (lefts < right && arr[lefts] == arr[lefts - 1]) {
                    lefts+=1
                }
                while (lefts < right && arr[right] == arr[right +1]) {
                    right-=1
                }
            }
            targetSum > currentSum -> {
                lefts+=1
            }
            else -> {
                right-=1
            }
        }
    }

}


/*
Time complexity
Sorting the array will take O(N * logN).
The searchPair() function will take O(N).
As we are calling searchPair() for every number in the input array,
this means that overall searchTriplets() will take O(N * logN + N^2), which is asymptotically equivalent to O(N^2).
Space complexity
Ignoring the space required for the output array,
the space complexity of the above algorithm will be O(N) which is required for sorting.*/
