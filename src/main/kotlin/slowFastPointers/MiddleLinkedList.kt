package slowFastPointers

/*
Problem Statement
Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.
If the total number of nodes in the LinkedList is even, return the second middle node.
Example 1:
Input: 1 -> 2 -> 3 -> 4 -> 5 -> null
Output: 3
Example 2:
Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
Output: 4
Example 3:
Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
Output: 4
*/


fun main(){
    var head: ListNode = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)
    head.next?.next?.next?.next?.next = ListNode(6)
    println("Starting cyclic node ${getMiddleNode(head)?.data}")
}

fun getMiddleNode( head:ListNode):ListNode?{
    var slow:ListNode?=head
    var fast:ListNode?=head
    while(fast?.next != null){
       slow=slow?.next
       fast=fast.next?.next
    }
    return slow
}

/*
Time complexity
The above algorithm will have a time complexity of O(N) where ‘N’ is the number of nodes in the LinkedList.
Space complexity
The algorithm runs in constant space O(1).
*/
