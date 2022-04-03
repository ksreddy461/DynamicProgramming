package trees;

import recursion.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class MorrisInOrderTraversal {

    public List<Integer> morrisTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            } else {

                TreeNode pre = cur.left;
                while (pre.right != cur && pre.right != null) {
                    pre = pre.right;
                }

                if (pre.right == cur) {
                    res.add(cur.val);
                    pre.right = null;
                    cur = cur.right;
                } else {
                    pre.right = cur;
                    cur = cur.left;
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        MorrisInOrderTraversal morrisInOrderTraversal = new MorrisInOrderTraversal();
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.left.left.right = new TreeNode(7);
        root.right.right.left = new TreeNode(8);

        root.left.left.right.left = new TreeNode(9);
        root.right.right.left.right = new TreeNode(11);

        root.left.left.right.left.left = new TreeNode(10);
        System.out.println("Ans is: " + morrisInOrderTraversal.morrisTraversal(root).toString());

    }
}
