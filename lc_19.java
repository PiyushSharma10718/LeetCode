class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class lc_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head); // Dummy node to simplify edge cases
        ListNode first = dummy;
        ListNode second = dummy;

        // Move first pointer `n + 1` steps ahead to maintain a gap of `n` nodes
        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }

        // Move both pointers until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Skip the nth node from the end
        second.next = second.next.next;

        return dummy.next; // Return the head of the modified list
    }

    public static void main(String[] args) {
        lc_19 obj = new lc_19();

        // Create a sample linked list [1, 2, 3, 4, 5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = obj.removeNthFromEnd(head, 2);

        // Print the modified list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
