package trees;

import recursion.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {

    class Tuple {
        TreeNode node;
        int col;

        Tuple(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0));

        int max = 0;
        while (!q.isEmpty()) {

            int size = q.size();
            int start = 0, end = 0;
            for (int i = 0; i < size; i++) {
                Tuple tuple = q.poll();
                TreeNode node = tuple.node;

                if (i == 0) {
                    start = tuple.col;
                }
                if (i == size - 1) {
                    end = tuple.col;
                }

                if (node.left != null) {
                    q.add(new Tuple(node.left, tuple.col*2 + 1));
                }
                if (node.right != null) {
                    q.add(new Tuple(node.right, tuple.col*2 + 2));
                }
            }

             if (max < end - start + 1) {
                max = end - start + 1;
            }
        }
        return max;
    }
    public static void main(String[] args) {

        MaximumWidthOfBinaryTree maximumWidthOfBinaryTree = new MaximumWidthOfBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);

        root.left.right.right = new TreeNode(1);
        root.left.right.right.right = new TreeNode(2);
        root.left.right.right.left = new TreeNode(2);

        root.left.right.right.right.left = new TreeNode(2);
        root.left.right.right.right.right = new TreeNode(2);
        root.left.right.right.left.left = new TreeNode(2);
        root.left.right.right.left.right = new TreeNode(2);

        root.left.right.right.left.left.left = new TreeNode(2);
        root.left.right.right.left.left.right = new TreeNode(2);

        root.left.right.right.left.right.left = new TreeNode(2);
        root.left.right.right.left.right.right = new TreeNode(2);

        System.out.println("Ans is: " + maximumWidthOfBinaryTree.widthOfBinaryTree(root));
    }
}
