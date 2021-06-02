package CyclicSortPattern

fun main(){
println(findFirstPositiveMissingNumber(arrayOf(-3, 1, 5, 4, 2)))
println(findFirstPositiveMissingNumber(arrayOf(3, -2, 0, 1, 2)))
println(findFirstPositiveMissingNumber(arrayOf(3, 2, 5, 1)))
}

fun findFirstPositiveMissingNumber(nums:Array<Int>):Int{
    var i=0
    var n= nums.size
    while(i<n){
        var j=nums[i]-1
        if(nums[i]>0 && nums[i]<=n && nums[i]!=nums[j]){
            nums[i]=nums[j].also{
                nums[j]=nums[i]
            }
        }else{
            i++
        }

    }
    for (k in nums.indices){
        if(nums[k]!=k+1){
            return k+1
        }
    }
    return nums.size+1
}