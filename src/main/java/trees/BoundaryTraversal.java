package trees;

import recursion.TreeNode;

import java.util.LinkedList;

//https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
public class BoundaryTraversal {


    public void leftBoundary(TreeNode root, LinkedList<Integer> res) {

        if (root == null) {
            return;
        }
        TreeNode p = root;
        while (!isLeaf(p)) {
            res.add(p.val);
            if (p.left != null) {
                p = p.left;
            } else if (p.right != null) {
                p = p.right;
            }
        }
    }

    public void LeafNodes(TreeNode root, LinkedList<Integer> res) {
        if (root == null) {
            return;
        }

        if (isLeaf(root)) {
            res.add(root.val);
        }

        LeafNodes(root.left, res);
        LeafNodes(root.right, res);
    }

    public void rightBoundary(TreeNode root, LinkedList<Integer> res) {

        if (root == null) {
            return;
        }

        LinkedList<Integer> tmp = new LinkedList<>();
        TreeNode p = root;
        while (!isLeaf(p)) {
            tmp.add(0, p.val);
            if (p.right != null) {
                p = p.right;
            } else if (p.left != null) {
                p = p.left;
            }
        }
        res.addAll(tmp);
    }

    private boolean isLeaf(TreeNode p) {

        if (p != null && p.left == null && p.right == null) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BoundaryTraversal boundaryTraversal = new BoundaryTraversal();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        root.left.right.right.left = new TreeNode(8);
        root.right.left.right.left = new TreeNode(9);

        // Let us construct the tree given in the above diagram
        /*  TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right = new TreeNode(22);
        root.right.right = new TreeNode(25);*/

        LinkedList<Integer> res = new LinkedList<>();
        res.add(root.val);
        boundaryTraversal.leftBoundary(root.left, res);
        boundaryTraversal.LeafNodes(root, res);
        boundaryTraversal.rightBoundary(root.right, res);
        System.out.println(res.toString());
    }

}
