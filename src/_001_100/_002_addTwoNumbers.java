package _001_100;

public class _002_addTwoNumbers {
    public static void main(String[] args) {
        ListNode l1_1 = new ListNode(7);
        ListNode l1_2 = new ListNode(9);
        ListNode l1_3 = new ListNode(1);

        l1_1.next = l1_2;
        l1_2.next = l1_3;

        ListNode l2_1 = new ListNode(5);
        ListNode l2_2 = new ListNode(1);
        ListNode l2_3 = new ListNode(9);

        l2_1.next = l2_2;
        l2_2.next = l2_3;

        ListNode result =addTwoNumbers(l1_1, l2_1);

        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return l1;
        }

        ListNode dummyHeadResult = new ListNode(10000);
        ListNode curr = dummyHeadResult;

        int tempSum = 0;
        int carry = 0;

        while(l1 != null && l2 != null) {
            tempSum = l1.val + l2.val + carry;
            carry = tempSum < 10 ? 0 : 1;
            tempSum = tempSum < 10 ? tempSum : tempSum % 10;

            ListNode newListNode = new ListNode(tempSum);
            curr.next = newListNode;
            curr = newListNode;

            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            tempSum = l1.val + carry;
            carry = tempSum < 10 ? 0 : 1;
            tempSum = tempSum < 10 ? tempSum : tempSum % 10;

            ListNode newListNode = new ListNode(tempSum);
            curr.next = newListNode;
            curr = newListNode;

            l1 = l1.next;
        }

        while(l2 != null){
            tempSum = l2.val + carry;
            carry = tempSum < 10 ? 0 : 1;
            tempSum = tempSum < 10 ? tempSum : tempSum % 10;

            ListNode newListNode = new ListNode(tempSum);
            curr.next = newListNode;
            curr = newListNode;

            l2 = l2.next;
        }

        if(carry == 1) {
            ListNode newListNode = new ListNode(1);
            curr.next = newListNode;
        }

        return dummyHeadResult.next;
    }
}
