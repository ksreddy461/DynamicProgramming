package trees;

import recursion.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {

    class Tuple {
        TreeNode node;
        int col;

        Tuple(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    TreeMap<Integer, Integer> map = new TreeMap<>();

    public void solve(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0));

        while (!q.isEmpty()) {
            Tuple tuple = q.remove();
            TreeNode node = tuple.node;
            int verticalLevel = tuple.col;
            map.put(verticalLevel, node.val);
            if (node.left != null) {
                q.add(new Tuple(node.left, verticalLevel - 1));
            }
            if (node.right != null) {
                q.add(new Tuple(node.right, verticalLevel + 1));
            }
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            res.add(e.getValue());
        }
    }

    public static void main(String[] args) {
        BottomView bottomView = new BottomView();

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
        List<Integer> res = new LinkedList<>();
        bottomView.solve(root, res);
        System.out.println(res.toString());
    }
}
