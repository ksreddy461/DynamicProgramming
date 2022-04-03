package trees;

import recursion.TreeNode;

import java.util.HashMap;

public class ConstructTreeFromPostAndInOrders {

    int postorderIndex;
    HashMap<Integer, Integer> inorderHash;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postorderIndex = inorder.length - 1;
        inorderHash = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderHash.put(inorder[i], i);
        }

        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int left, int right) {

        if (left > right) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorderIndex--]);
        int index = inorderHash.get(root.val);

        root.right = helper(postorder, index + 1, right);
        root.left = helper(postorder, left, index - 1);
        return root;
    }

    public static void main(String[] args) {
        ConstructTreeFromPostAndInOrders constructTreeFromPostAndInOrders =
                new ConstructTreeFromPostAndInOrders();

        int[] in = {9,3,15,20,7};
        int[] post = {9,15,7,20,3};

        TreeNode root = constructTreeFromPostAndInOrders.buildTree(in, post);
        System.out.println();
    }
}
