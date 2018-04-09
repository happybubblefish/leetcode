package _101_200;

import _001_100.ListNode;
import _001_100.TreeNode;

public class _109_convertSortedLinkedListToBST {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(-10);
        ListNode l2 = new ListNode(-3);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(9);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        TreeNode root = sortedListToBST(l1);

        System.out.println(root.val);
    }

    static ListNode h = null;
    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }

        int count = 0;
        ListNode curr = head;
        h = head;

        while(curr != null){
            count++;
            curr = curr.next;
        }

        TreeNode root = helper(head, 0, count - 1);

        return root;
    }

    private static TreeNode helper(ListNode head, int start, int end) {
        if(start > end){
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode left = helper(head, start, mid - 1);
        TreeNode root = new TreeNode(h.val);
        root.left = left;

        h = h.next;

        TreeNode right = helper(head, mid + 1, end);
        root.right = right;

        return root;
    }
}
