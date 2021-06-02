package CyclicSortPattern


/*Problem Statement
We are given an unsorted array containing numbers taken from the range 1 to ‘n’.
The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.
Example 1:
Input: [2, 3, 1, 8, 2, 3, 5, 1]
Output: 4, 6, 7
Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.
Example 2:
Input: [2, 4, 1, 2]
Output: 3
Example 3:
Input: [2, 3, 2, 1]
Output: 4
*/

fun main(){
    println(findAllMissingNumbers(arrayOf(2, 3, 1, 8, 2, 3, 5, 1)))
    println(findAllMissingNumbers(arrayOf(2, 4, 1, 2)))
    println(findAllMissingNumbers(arrayOf(2, 3, 2, 1)))
}

fun findAllMissingNumbers(nums:Array<Int>):List<Int>{
    var i=0
    while(i<nums.size){
        var j=nums[i]-1
        if(nums[i]!=nums[j]){
            nums[i]=nums[j].also{
                nums[j]=nums[i]
            }
        }else{
            i++
        }
    }
    var allMissingNumbers= arrayListOf<Int>()
    for (k in nums.indices){
        if(nums[k]!=k+1){
            allMissingNumbers.add(k+1)
        }
    }
    return allMissingNumbers
}

/*Time complexity
The time complexity of the above algorithm is O(n).
Space complexity
Ignoring the space required for the output array, the algorithm runs in constant space O(1).
*/