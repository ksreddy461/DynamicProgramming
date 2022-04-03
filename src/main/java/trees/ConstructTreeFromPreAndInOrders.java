package trees;

import recursion.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConstructTreeFromPreAndInOrders {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        ArrayList<Integer> pre = new ArrayList<>();
        for (int i = 0; i < preorder.length; i++) {
            pre.add(preorder[i]);
        }

        ArrayList<Integer> in = new ArrayList<>();
        for (int i = 0; i < inorder.length; i++) {
            in.add(inorder[i]);
        }

        return helper(pre, in);
    }

    public static TreeNode helper(List<Integer> pre, List<Integer> in) {

        if (pre.size() > 0 && in.size() > 0) {
            TreeNode root = new TreeNode(pre.get(0));
            int index = in.indexOf(pre.get(0));
            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();

            if (index > 0) {
                left = in.subList(0, index);
            }

            if (index + 1 < in.size()) {
                right = in.subList(index + 1, in.size());
            }

            pre.remove(0);

            root.left = helper(pre, left);
            root.right = helper(pre, right);
            return root;
        }
        return null;
    }

    public int preorderIndex;

    public TreeNode buildTree2(int[] preorder, int[] inorder) {

        preorderIndex = 0;
        HashMap<Integer, Integer> inorderHashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderHashMap.put(inorder[i], i);
        }

        return helper2(preorder, inorderHashMap, 0, preorder.length-1);
    }

    public TreeNode helper2(int[] pre, HashMap<Integer, Integer> inorderHashMap, int left, int right) {

        if (left > right) {
            return null;
        }

        int rootValue = pre[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        int index = inorderHashMap.get(rootValue);

        root.left = helper2(pre, inorderHashMap, left, index - 1);
        root.right = helper2(pre, inorderHashMap, index + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};

        ConstructTreeFromPreAndInOrders constructTreeFromPreAndInOrders = new ConstructTreeFromPreAndInOrders();
        TreeNode root = constructTreeFromPreAndInOrders.buildTree2(pre, in);
        System.out.println();
    }
}
