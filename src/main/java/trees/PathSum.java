package trees;

import recursion.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class PathSum {

    static List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<Integer> list = new LinkedList<>();
        helper(root, targetSum, list);
        return res;
    }

    public void helper(TreeNode root, int targetSum, List<Integer> list) {
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                list.add(root.val);
                res.add(new LinkedList<>(list));
                list.remove(list.size() - 1);
            }
            return;
        }

        list.add(root.val);
        if (root.left != null) {
            helper(root.left, targetSum - root.val, list);
        }
        if (root.right != null) {
            helper(root.right, targetSum - root.val, list);
        }
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        pathSum.pathSum(root, 22);

        System.out.println(res.toString());
    }
}
