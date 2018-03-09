package _001_100;

public class _019_removeNthNodeFromEndOfList {
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

        ListNode res = removeNthFromEnd(l1, 2);

        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode dummyHead = new ListNode(9999);
        ListNode pre = dummyHead;
        dummyHead.next = head;

        while(n > 1) {
            fast = fast.next;
            n--;
        }

        while(fast.next != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }

        pre.next = slow.next;

        return dummyHead.next;
    }
}
