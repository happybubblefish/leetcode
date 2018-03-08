package _301_400;

public class _369_plusOneLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
		Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.
	
		You may assume the integer do not contain any leading zero, except the number 0 itself.
	
		The digits are stored such that the most significant digit is at the head of the list.
	
		Example:
		Input:
		1->2->3
	
		Output:
		1->2->4

	*/
	
//	Iterative Two-Pointers with dummy node Java O(n) time, O(1) space

	public ListNode plusOne(ListNode head) {
		ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy;
        ListNode j = dummy;
        
        while (j.next != null) {
            j = j.next;
            if (j.val != 9) {
                i = j;
            }
        }
        
        if (j.val != 9) {
            j.val++;
        } else {
            i.val++;
            i = i.next;
            while (i != null) {
                i.val = 0;
                i = i.next;
            }
        }
        
        if (dummy.val == 0) {
            return dummy.next;
        }
        
        return dummy;
	}
}

class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
}
