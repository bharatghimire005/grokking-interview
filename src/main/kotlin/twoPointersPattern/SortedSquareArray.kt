package twoPointersPattern

/*Problem Statement
Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.
Example 1:
Input: [-2, -1, 0, 2, 3]
Output: [0, 1, 4, 4, 9]
Example 2:
Input: [-3, -1, 0, 1, 2]
Output: [0 1 1 4 9]*/

fun main() {
    var arr= arrayOf(-2, -1, 0, 2, 3)
 println("array of ${arr.contentToString()} after square and sorted ${sortSquareArray(arr).contentToString()}" )
    var arr2 = arrayOf(-3, -1, 0, 1, 2)
    println("array of  ${arr2.contentToString()} after square and sorted ${sortSquareArray(arr2).contentToString()}")
}




fun sortSquareArray(arr: Array<Int>):Array<Int> {

    var squareArray: Array<Int> = Array(arr.size){0}
    var count = arr.size-1
    var start = 0
    var end = arr.size-1

    while (start <= end) {
        var squareStart = arr[start] * arr[start]
        var squareEnd = arr[end] * arr[end]
        if (squareStart > squareEnd) {
            squareArray[count] = squareStart
            start++
        } else {
            squareArray[count] = squareEnd
            end--
        }
        count--;
    }
return squareArray
}


/*
Time complexity
The time complexity of the above algorithm will be O(N) as we are iterating the input array only once.
Space complexity
The space complexity of the above algorithm will also be O(N); this space will be used for the output array.*/
