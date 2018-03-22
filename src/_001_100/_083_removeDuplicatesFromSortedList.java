package _001_100;

public class _083_removeDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(5);
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
        ListNode curr = head;
        dummyHead.next = head;
        ListNode d = head;

        while(curr.next != null) {
            if(curr.val != curr.next.val) {
                d.next = curr.next;
                curr = curr.next;
                d = d.next;
            } else {
                curr = curr.next;
            }
        }

        if(d.val != curr.val) {
            d.next = curr;
        } else {
            d.next = null;
        }

        return dummyHead.next;
    }
}
