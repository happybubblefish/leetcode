package _001_100;

public class _021_mergeTwoSortedLists {
    public static void main(String[] args) {
//        ListNode l1_1 = new ListNode(1);
//        ListNode l1_2 = new ListNode(3);
        ListNode l1_3 = new ListNode(5);

        ListNode l2_1 = new ListNode(2);
        ListNode l2_2 = new ListNode(4);
        ListNode l2_3 = new ListNode(6);

//        l1_1.next = l1_2;
//        l1_2.next = l1_3;

        l2_1.next = l2_2;
        l2_2.next = l2_3;

        ListNode res = mergeTwoLists(l1_3, l2_1);

        while(res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return l1;
        }

        ListNode dummyHead = new ListNode(9999);
        ListNode curr = dummyHead;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
                curr = curr.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
                curr = curr.next;
            }
        }

        if(l1 != null) {
            curr.next = l1;
        }

        if(l2 != null) {
            curr.next = l2;
        }

        return dummyHead.next;
    }
}
