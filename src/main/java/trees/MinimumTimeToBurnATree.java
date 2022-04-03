package trees;

import recursion.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumTimeToBurnATree {

    public int distanceK(TreeNode root, TreeNode target) {

        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.left != null) {
                parent.put(node.left, node);
                q.add(node.left);
            }

            if (node.right != null) {
                parent.put(node.right, node);
                q.add(node.right);
            }
        }
        q = new LinkedList<>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        q.add(target);
        visited.put(target, true);
        int distance = 0;
        while (!q.isEmpty()) {

            int size = q.size();
            distance++;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (parent.containsKey(node)) {
                    TreeNode p = parent.get(node);
                    if (!visited.containsKey(p)) {
                        q.add(p);
                        visited.put(p, true);
                    }
                }

                if (node.left != null && !visited.containsKey(node.left)) {
                    q.add(node.left);
                    visited.put(node.left, true);
                }

                if (node.right != null && !visited.containsKey(node.right)) {
                    q.add(node.right);
                    visited.put(node.right, true);
                }

            }
        }

        return distance;
    }

    public static void main(String[] args) {
        MinimumTimeToBurnATree minimumTimeToBurnATree = new MinimumTimeToBurnATree();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.println("Ans is: " + minimumTimeToBurnATree.distanceK(root, root.left.right.left));
    }
}
