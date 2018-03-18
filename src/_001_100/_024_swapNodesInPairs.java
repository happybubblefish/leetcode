package _001_100;

public class _024_swapNodesInPairs {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode res = swapPairs(l1);

        while(res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
//        if(head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode dummyHead = new ListNode(9999);
//        dummyHead.next = head;
//        ListNode curr = dummyHead;
//
//        ListNode fast = head.next;
//        ListNode slow = head;
//
//        while(fast.next != null && fast.next.next != null) {
//            ListNode next = fast.next;    //swap first, so I have to check at the end
//            fast.next = slow;
//            slow.next = next;
//            curr.next = fast;
//
//            curr = slow;
//            slow = next;
//            fast = next.next;
//        }
//
//        if(fast.next == null) {
//            ListNode next = fast.next;
//            fast.next = slow;
//            slow.next = next;
//            curr.next = fast;
//        }
//
//        return dummyHead.next;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while(current.next != null && current.next.next != null) {
            ListNode first = current.next;  //move first and then swap, so there is no need to check after the while loop
            ListNode second = current.next.next;

            first.next = second.next;
            second.next = first;
            current.next = second;
            current = first;
        }
        return dummy.next;
    }
}
