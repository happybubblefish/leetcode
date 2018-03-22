package _001_100;

import java.util.List;

public class _082_removeDuplicatesFromSortedListII {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode res = deleteDuplicates(l1);

        while(res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(999);
        dummyHead.next = head;
        ListNode curr = head;
        ListNode pre = dummyHead;

        while(curr.next != null) {
            if(curr.val != curr.next.val) {
                if(pre.next != curr) {
                    pre.next = curr.next;
                } else {
                    pre = pre.next;
                }
            }

            curr = curr.next;
        }

        if(pre.next != curr) {
            pre.next = curr;
        }

        return dummyHead.next;
    }
}
