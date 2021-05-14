package twoPointersPattern
/*
Problem Statement
Given an array with positive numbers and a target number,
find all of its contiguous subarrays whose product is less than the target number.
Example 1:
Input: [2, 5, 3, 10], target=30
Output: [2], [5], [2, 5], [3], [5, 3], [10]
Explanation: There are six contiguous subarrays whose product is less than the target.
Example 2:
Input: [8, 2, 6, 5], target=50
Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
Explanation: There are seven contiguous subarrays whose product is less than the target.*/


fun main() {
    println("Input: [2, 5, 3, 10], target=30  -> ${getSubArrayLessThanTargetSum(arrayOf(2, 5, 3, 10),30)}")
}

fun getSubArrayLessThanTargetSum(arr: Array<Int>, target: Int): Set<ArrayList<Int>> {
    var subArray = hashSetOf<ArrayList<Int>>()
    for (i in arr.indices) {
        var end = i + 1
        var prod = arr[i]
        var tempArray = arrayListOf<Int>()
        tempArray.add(arr[i])
        while (prod<target){
            subArray.add(ArrayList<Int>(tempArray))
            if(end<arr.size-1){
                tempArray.add(arr[end])
                end++
                prod*=arr[end]
            }else
                break;
        }
    }
    return subArray

}
