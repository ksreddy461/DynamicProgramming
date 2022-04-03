package trees;

import recursion.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {

    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> col = new TreeMap<>();

    class Tuple {
        TreeNode node;
        int row;
        int col;

        Tuple(TreeNode node, int r, int c) {
            this.node = node;
            row = r;
            col = c;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        solve(root, res);
        return res;
    }

    public void solve(TreeNode root, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            TreeMap<Integer, PriorityQueue<Integer>> row;
            if (col.containsKey(y)) {
                row = col.get(y);
            } else {
                row = new TreeMap<>();
            }

            PriorityQueue<Integer> pq;
            if (row.containsKey(x)) {
                pq = row.get(x);
            } else {
                pq = new PriorityQueue<>();
            }

            pq.add(node.val);
            row.put(x, pq);
            col.put(y, row);

            if (tuple.node.left != null) {
                q.add(new Tuple(node.left, x + 1, y - 1));
            }
            if (tuple.node.right != null) {
                q.add(new Tuple(node.right, x + 1, y + 1));
            }
        }

        for (Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> e1 : col.entrySet()) {

            LinkedList<Integer> row = new LinkedList<>();
            for (Map.Entry<Integer, PriorityQueue<Integer>> e2 : e1.getValue().entrySet()) {
                PriorityQueue<Integer> pq = e2.getValue();
                while (!pq.isEmpty()) {
                    row.add(pq.poll());
                }
            }
            res.add(row);
        }
    }

    public static void main(String[] args) {
        VerticalOrderTraversal verticalOrderTraversal = new VerticalOrderTraversal();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> res = new LinkedList<>();
        verticalOrderTraversal.solve(root, res);
        System.out.println(res.toString());
    }
}
