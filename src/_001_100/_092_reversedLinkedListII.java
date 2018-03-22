package _001_100;

public class _092_reversedLinkedListII {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode res = reverseBetween(l1, 2, 5);

        while(res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(999);
        dummyHead.next = head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode preSlow = dummyHead;

        int diff = n - m;
        int tempM = m;

        fast = fast.next;

        while(tempM > 1) {
            preSlow = preSlow.next;
            slow = slow.next;
            fast = fast.next;
            tempM--;
        }

        ListNode tempSlow = slow;

        while(diff > 0) {
            ListNode next = fast.next;
            fast.next = slow;
            slow = fast;
            fast = next;

            diff--;
        }

        preSlow.next = slow;
        tempSlow.next = fast;

        return dummyHead.next;
    }
}
