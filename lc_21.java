class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class lc_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Dummy node to start the merged list
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        
        // Traverse both lists and merge them
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        
        // Attach the remaining part, if any, of list1 or list2
        if (list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }
        
        // Return the merged list starting after the dummy node
        return dummy.next;
    }
    
    // Helper function to print the list (for testing purposes)
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage:
        lc_21 obj = new lc_21();
        
        // Creating list1: 1 -> 2 -> 4
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        
        // Creating list2: 1 -> 3 -> 4
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        
        // Merging lists
        ListNode mergedList = obj.mergeTwoLists(list1, list2);
        
        // Printing the merged list
        printList(mergedList);  // Output: 1 1 2 3 4 4
    }
}
