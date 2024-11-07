import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class lc_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Priority queue to store nodes by their values in ascending order
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each list to the priority queue
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        // Dummy head for the result list
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Process the queue until empty
        while (!pq.isEmpty()) {
            // Get the smallest element from the heap
            ListNode smallest = pq.poll();
            tail.next = smallest;
            tail = tail.next;

            // If there's a next node in this list, add it to the heap
            if (smallest.next != null) {
                pq.add(smallest.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Test case
        ListNode[] lists = new ListNode[3];
        
        // List 1: 1 -> 4 -> 5
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        // List 2: 1 -> 3 -> 4
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        // List 3: 2 -> 6
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        lc_23 obj = new lc_23();
        ListNode result = obj.mergeKLists(lists);

        // Print merged list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
