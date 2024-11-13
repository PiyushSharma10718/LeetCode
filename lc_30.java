class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

class lc_30 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // Swapping nodes
            prev.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Move pointers to the next pair
            prev = firstNode;
            head = firstNode.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        lc_30 solution = new lc_30();

        // Create a sample linked list 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Call the swapPairs function
        ListNode result = solution.swapPairs(head);

        // Print the resulting linked list after swapping
        printList(result);
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}


// Loche hue hain From no. 24 to 30 in the Coding !
// I have Writen the 24 Question's Answer in the lc_30.java !
// And The Answer for the 25th Question is Written in 24 and 26  -> 25, 27th -> 26.java mein, So on, So fourth !
