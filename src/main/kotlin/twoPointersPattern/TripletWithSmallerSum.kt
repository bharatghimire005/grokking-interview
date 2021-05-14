package twoPointersPattern
/*
Problem Statement
Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices. Write a function to return the count of such triplets.
Example 1:
Input: [-1, 0, 2, 3], target=3
Output: 2
Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
Example 2:
Input: [-1, 4, 2, 1, 3], target=5
Output: 4
Explanation: There are four triplets whose sum is less than the target:
[-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]*/

fun main(){
println("Input: [-1, 0, 2, 3], target=3  -> ${getTripletWithSmallerSum(arrayOf(-1, 0, 2, 3),3)}")
println("Input: [-1, 4, 2, 1, 3] target=5  -> ${getTripletWithSmallerSum(arrayOf(-1, 4, 2, 1, 3),5)}")
}

fun getTripletWithSmallerSum(arr:Array<Int>,target:Int):Int{
    arr.sort()
    var count:Int=0
    for(i in arr.indices-2){
        var left=i+1
        var right=arr.size-1
        while(left<right){
            if(arr[i]+arr[left]+arr[right]<target){
                count+=right-left
                left++
            }else{
                right--
            }
        }
    }
    return count
}

/*
Time complexity
Sorting the array will take O(N * logN). The searchPair() will take O(N).
So, overall searchTriplets() will take O(N * logN + N^2), which is asymptotically equivalent to O(N^2).
Space complexity
Ignoring the space required for the output array,
the space complexity of the above algorithm will be O(N) which is required for sorting if we are not using an in-place sorting algorithm.*/
