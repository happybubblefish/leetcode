package _101_200;

import _001_100.TreeNode;

public class _105_constructBTFromPreAndInTraversal {
    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };

        _001_100.TreeNode root = buildTree(preorder, inorder);

        System.out.println(root.val);
    }

    public static _001_100.TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) {
            return null;
        }

        int preLen = preorder.length;
        int inLen = inorder.length;

        if(preLen != inLen) {
            return null;
        }

        return helper(preorder, 0, preLen - 1, inorder, 0, inLen);
    }

    private static _001_100.TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootValue = preorder[preStart];
        int rootIndex = 0;
        _001_100.TreeNode root = new TreeNode(rootValue);

        for(int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }

        root.left = helper(preorder, preStart + 1, (rootIndex - inStart) + preStart, inorder, inStart, rootIndex - 1);
        root.right = helper(preorder, (rootIndex - inStart) + preStart + 1, preEnd, inorder, rootIndex + 1, inEnd);

        return root;
    }
}
