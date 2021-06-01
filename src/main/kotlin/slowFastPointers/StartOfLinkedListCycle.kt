package slowFastPointers


/*Problem Statement
Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.*/

fun main() {
    var head: ListNode = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)
    println("Starting cyclic node ${getStartingNode(head)?.data}")
    head.next?.next?.next?.next?.next = head.next?.next
    println("Starting cyclic node ${getStartingNode(head)?.data}")
}

fun getStartingNode(head: ListNode): ListNode? {
    var fast: ListNode? = head
    var slow: ListNode? = head
    var length: Int = 0
    while (slow?.next != null && fast?.next != null) {
        fast = fast.next?.next
        slow = slow.next
        if (slow?.data == fast?.data) {
            length = getLength(slow)
            break
        }
    }
    if (length != 0) {
        return search(head, length)
    } else return null

}

fun search(head: ListNode?, length: Int): ListNode? {
    var slow: ListNode? = head
    var fast: ListNode? = head
    for (i in 0 until length) {
        fast = fast?.next
    }
    while (slow != fast) {
        fast = fast?.next
       slow= slow?.next
    }

    return slow

}

fun getLength(current: ListNode?): Int {
    var count = 0
    var node = current
    while (node != null) {
        node = node.next
        count += 1
        if (node == current) {
            return count
        }
    }
    return 0
}

/*
Time Complexity
As we know, finding the cycle in a LinkedList with ‘N’ nodes and also finding the length of the cycle requires O(N).
Also, as we saw in the above algorithm, we will need O(N) to find the start of the cycle.
Therefore, the overall time complexity of our algorithm will be O(N).
Space Complexity
The algorithm runs in constant space O(1).
*/


