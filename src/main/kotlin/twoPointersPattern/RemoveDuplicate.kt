package twoPointersPattern


/*Problem Statement
Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after removing the duplicates in-place return the new length of the array.
Example 1:
Input: [2, 3, 3, 3, 6, 9, 9]
Output: 4
Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
Example 2:
Input: [2, 2, 2, 11]
Output: 2
Explanation: The first two elements after removing the duplicates will be [2, 11].*/


fun main() {
    var nonDuplicateNum = removeDuplicate(arrayOf(2, 3, 3, 3, 6, 9, 9))
    println("nonDuplicateCount-> $nonDuplicateNum")
    var nonDuplicateNum1 = removeDuplicate(arrayOf(2, 2, 2, 11))
    println("nonDuplicateCount2-> $nonDuplicateNum1")

    //removeGivenElement
    println("Remove Duplicate Element ${removeElement(arrayOf(3, 2, 3, 6, 3, 10, 9, 3), 3)}")
    println("Remove Duplicate Element ${removeElement(arrayOf(2, 11, 2, 2, 1), 2)}")

}


fun removeDuplicate(arr: Array<Int>): Int {
    var nextNonDuplicate = 1
    var i = 1
    while (i < arr.size) {
        if (arr[nextNonDuplicate - 1] != arr[i]) {
            arr[nextNonDuplicate] = arr[i]
            nextNonDuplicate += 1
        }
        i++
    }
    return nextNonDuplicate
}
/*
Time Complexity
The time complexity of the above algorithm will be O(N),
where ‘N’ is the total number of elements in the given array.
Space Complexity
The algorithm runs in constant space O(1).*/


/*
Problem 1: Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place and return the new length of the array.
Example 1:
Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
Output: 4
Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].
Example 2:
Input: [2, 11, 2, 2, 1], Key=2
Output: 2
Explanation: The first two elements after removing every 'Key' will be [11, 1].
*/

fun removeElement(arr: Array<Int>, elementToRemove: Int): Int {
    var nextElement = 0
    for (i in arr) {
        if (i != elementToRemove) {
            arr[nextElement] = i
            nextElement++
        }
    }
    return nextElement
}

