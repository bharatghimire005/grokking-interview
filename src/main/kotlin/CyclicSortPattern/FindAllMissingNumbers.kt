package CyclicSortPattern

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