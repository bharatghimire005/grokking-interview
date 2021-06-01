package slowFastPointers

import java.util.*

/*Problem Statement
Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.*/

fun main() {
var head: ListNode=ListNode(1)
    head.next=ListNode(2)
    head.next?.next=ListNode(3)
    head.next?.next?.next=ListNode(4)
    head.next?.next?.next?.next=ListNode(5)
    println("Is linkedList Cyclic ${isGivenLinkedListIsCyclic(head)}")
    head.next?.next?.next?.next?.next=head.next?.next
    println("Is linkedList Cyclic ${isGivenLinkedListIsCyclic(head)}")
}

fun isGivenLinkedListIsCyclic(head: ListNode):Boolean {
    var fast:ListNode? = head
    var slow:ListNode?=head
    while(slow?.next!=null && fast?.next!=null){
        fast=fast.next?.next
        slow=slow.next
        if(slow?.data==fast?.data){
            return true
        }
    }
    return false
}



/*
Time Complexity
As we have concluded above, once the slow pointer enters the cycle, the fast pointer will meet the slow pointer in the same loop.
Therefore, the time complexity of our algorithm will be O(N) where ‘N’ is the total number of nodes in the LinkedList.
Space Complexity #
The algorithm runs in constant space O(1).*/
