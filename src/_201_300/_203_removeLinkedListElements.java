package _201_300;

public class _203_removeLinkedListElements {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(6);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(4);
		ListNode l6 = new ListNode(5);
		ListNode l7 = new ListNode(6);
		
//		l1.next = l2;
//		l2.next = l3;
//		l3.next = l4;
//		l4.next = l5;
//		l5.next = l6;
//		l6.next = l7;
		
		ListNode head = removeElements(l1, 1);
		
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	public static ListNode removeElements(ListNode head, int val) {
		if(head == null) {
			return head;
		}
		
		ListNode dummyHead = new ListNode(9999);
		dummyHead.next = head;
		ListNode curr = head;
		ListNode pre = dummyHead;
		
		while(curr.next != null) {
			if(curr.val == val) {
				curr = curr.next;
			} else {
				if(pre.next != curr) {
					pre.next = curr;
				}
				curr = curr.next;
				pre = pre.next;
			}
		}
		
		if(curr.val == val) {
			pre.next = null;
		} else{
            pre.next = curr;
        }
		
		return dummyHead.next;
	}
}

class ListNode{
	public int val;
	public ListNode next;
	
	public ListNode(int val) {
		this.val = val;
	}
}
