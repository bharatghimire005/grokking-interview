package slowFastPointers

/*Problem Statement
Any number will be called a happy number if,
after repeatedly replacing it with a number equal to the sum of the square of all of its digits,
leads us to number ‘1’. All other (not-happy) numbers will never reach ‘1’.
Instead, they will be stuck in a cycle of numbers which does not include ‘1’.
*/

fun main() {
    println("Is 25 is HappyNumber ${getHappyNumber(25)}")
    println("Is 19 is HappyNumber ${getHappyNumber(19)}")
    println("Is 23 is HappyNumber ${getHappyNumber(23)}")
}


fun getHappyNumber(num: Int): Boolean {
    var slow = num
    var fast = num
    do {
        fast = square(square(fast))
        slow = square(slow)
    } while (slow != fast)

    return fast == 1
}


fun square(number: Int): Int {
    var num = number
    var squareNum = 0
    while (num > 0) {
        var n = num % 10
        squareNum += (n * n)
        num /= 10
    }
    return squareNum
}


/*
Time Complexity #
The time complexity of the algorithm is difficult to determine.
However we know the fact that all unhappy numbers eventually get stuck in the cycle: 4 -> 16 -> 37 -> 58 -> 89 -> 145 -> 42 -> 20 -> 4
This sequence behavior tells us two things:
1. If the number NN is less than or equal to 1000, then we reach the cycle or ‘1’ in at most 1001 steps.
2. For N > 1000, suppose the number has ‘M’ digits and the next number is ‘N1’.
From the above Wikipedia link, we know that the sum of the squares of the digits of ‘N’ is at most 9^2 M, or 81M
(this will happen when all digits of ‘N’ are ‘9’).
This means:
1. N1 < 81M
2. As we know M = log(N+1)M=log(N+1)
3. Therefore: N1 < 81 * log(N+1)N1<81∗log(N+1) => N1 = O(logN)N1=O(logN)
This concludes that the above algorithm will have a time complexity of O(logN)O(logN).
Space Complexity
The algorithm runs in constant space O(1)O(1).
*/
