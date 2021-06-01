package CyclicSortPattern

/**
Problem Statement
We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.
Example 1:
Input: [4, 0, 3, 1]
Output: 2
Example 2:
Input: [8, 3, 5, 2, 4, 6, 0, 1]
Output: 7
  **/

fun main(){
    println(findMissingNumber(arrayOf(0, 2, 3, 1)))
    println(findMissingNumber(arrayOf(8, 3, 5, 2, 4, 6, 0, 1)))
}

fun findMissingNumber(nums:Array<Int>):Int{
    var i =0
    var n =nums.size
    while(i<n){
        var j=nums[i]
        if(nums[i]<n && nums[i]!=nums[j]){
            nums[i]=nums[j].also {
                nums[j]=nums[i]
            }
        }else{
            i++
        }
    }
    for(k in nums.indices){
        if(nums[k]!=k){
            return k
        }
    }
    return n
}