class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

class lc_24 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Dummy node to help manage the head and previous groups
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            // Check if there are at least k nodes left to reverse
            ListNode kthNode = prevGroupEnd;
            for (int i = 0; i < k; i++) {
                kthNode = kthNode.next;
                if (kthNode == null) {
                    return dummy.next; // Not enough nodes left to reverse
                }
            }

            // Reverse the k nodes
            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kthNode.next;
            ListNode prev = nextGroupStart;
            ListNode curr = groupStart;
            
            while (curr != nextGroupStart) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect reversed group with the previous part
            prevGroupEnd.next = kthNode;
            prevGroupEnd = groupStart;
        }
    }

    public static void main(String[] args) {
        // Example linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        lc_24 obj = new lc_24();
        ListNode result = obj.reverseKGroup(head, 2);

        // Print the result: Expected output is 2 -> 1 -> 4 -> 3 -> 5
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
