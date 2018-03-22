package _001_100;

import java.util.ArrayList;
import java.util.List;

public class _095_uniqueBinarySearchTreeII {
    public static void main(String[] args) {
        List<TreeNode> res = generateTrees(3);

        System.out.println(res.size());
    }

    public static List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            return new ArrayList<TreeNode>();
        }
        
        return helper(1, n);
    }

    private static List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList<>();

        if(start > end) {
            list.add(null);
            return list;
        }

        for(int i = start; i <= end; i++) {
            List<TreeNode> leftList = helper(start, i - 1);
            List<TreeNode> rightList = helper(i + 1, end);

            for(TreeNode ltn : leftList) {
                for(TreeNode rtn : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = ltn;
                    root.right = rtn;

                    list.add(root);
                }
            }
        }

        return list;
    }
}
