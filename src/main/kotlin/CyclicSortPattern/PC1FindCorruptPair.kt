package CyclicSortPattern


/*
Problem Challenge 1
Find the Corrupt Pair (easy)
We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
The array originally contained all the numbers from 1 to ‘n’,
but due to a data error, one of the numbers got duplicated which also resulted in one number going missing. Find both these numbers.
Example 1:
Input: [3, 1, 2, 5, 2]
Output: [2, 4]
Explanation: '2' is duplicated and '4' is missing.
Example 2:
Input: [3, 1, 2, 3, 6, 4]
Output: [3, 5]
Explanation: '3' is duplicated and '5' is missing.
* */
fun main(){
    println(findCorruptNumber(arrayOf(3, 1, 2, 5, 2)))
    println(findCorruptNumber(arrayOf(3, 1, 2, 3, 6, 4)))
}


fun findCorruptNumber(nums:Array<Int>):Pair<Int,Int>{
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

    for (k in nums.indices){
        if(nums[k]!=k+1){
            return Pair(nums[k],k+1)
        }
    }
    return Pair(-1,-1)
}
/*
Time complexity
The time complexity of the above algorithm is O(n).
Space complexity
The algorithm runs in constant space O(1)
*/
