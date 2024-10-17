/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class lc_2 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode currNode = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            currNode.next = new ListNode(sum % 10);
            currNode = currNode.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode l1 = node1;

        ListNode node11 = new ListNode(5);
        ListNode node12 = new ListNode(6);
        ListNode node13 = new ListNode(4);
        node11.next = node12;
        node12.next = node13;
        ListNode l2 = node11;

        if (l1 != null) {
            System.out.println("\nThe Linked List l1 is Shown Below !");
            ListNode temp = l1;
            while (temp != null) {
                System.out.print(temp.val);
                temp = temp.next;
            }
            System.out.println();
        }

        if (l2 != null) {
            System.out.println("\nThe Linked List l2 is Shown Below !");
            ListNode temp2 = l2;
            while (temp2 != null) {
                System.out.print(temp2.val);
                temp2 = temp2.next;
            }
            System.out.println();
        }

        ListNode res = addTwoNumbers(l1, l2);
        System.out.println("\nThe Resulted Linked List is shown Below !");
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
        System.out.println();
    }
}
