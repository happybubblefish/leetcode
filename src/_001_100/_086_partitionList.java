package _001_100;

public class _086_partitionList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode res = partition(l1, 4);

        while(res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }

    }

    public static ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode lessDummyHead = new ListNode(9000);
        ListNode moreDummyHead = new ListNode(10000);
        ListNode lessPart = lessDummyHead;
        ListNode morePart = moreDummyHead;
        ListNode curr = head;

        while(curr != null) {
            if(curr.val < x) {
                lessPart.next = curr;
                lessPart = lessPart.next;
            } else {
                morePart.next = curr;
                morePart = morePart.next;
            }

            curr = curr.next;
        }

        morePart.next = null;

        lessPart.next = moreDummyHead.next;

        return lessDummyHead.next;
    }
}
