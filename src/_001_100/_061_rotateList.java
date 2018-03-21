package _001_100;

public class _061_rotateList {
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

        ListNode res = rotateRight(l1, 2);

        while(res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }

        int count = 0;

        ListNode last = head;
        ListNode dummyHead = new ListNode(999);
        dummyHead.next = head;
        ListNode fast = head;
        ListNode slow = head;

        while(last.next != null) {
            last = last.next;
            count++;
        }

        count++;

        k = k % count;

        while(k > 0) {
            fast = fast.next;
            k--;
        }

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        last.next = dummyHead.next;
        dummyHead.next = slow.next;
        slow.next = null;

        return dummyHead.next;
    }
}
