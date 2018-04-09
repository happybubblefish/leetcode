package _101_200;

import _001_100.TreeNode;

public class _106_constructBTFromInAndPostTraversal {
    public static void main(String[] args) {
        int[] inorder = { 9, 3, 15, 20,7  };
        int[] postorder = { 9, 15, 7, 20, 3 };

        _001_100.TreeNode root = buildTree(inorder, postorder);

        System.out.println(root.val);
    }

    public static _001_100.TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null) {
            return null;
        }

        int inLen = inorder.length;
        int postLen = postorder.length;

        if(inLen != postLen) {
            return null;
        }

        return helper(inorder, 0, inLen - 1, postorder, 0, postLen - 1);
    }

    private static _001_100.TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootValue = postorder[postEnd];
        int rootIndex = 0;
        _001_100.TreeNode root = new TreeNode(rootValue);

        for(int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }

        root.left = helper(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + (rootIndex - inStart) - 1);
        root.right = helper(inorder, rootIndex + 1, inEnd, postorder, postStart + (rootIndex - inStart), postEnd - 1);

        return root;
    }
}
