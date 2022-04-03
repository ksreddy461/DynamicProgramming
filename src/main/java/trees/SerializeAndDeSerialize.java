package trees;

import recursion.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeSerialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder ans = new StringBuilder();
        if (root == null) {
            return "";
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                ans.append("null").append(",");
                ;
                continue;
            }

            ans.append(node.val).append(",");
            q.add(node.left);
            q.add(node.right);
        }
        //ans = new StringBuilder(ans.substring(0, ans.length() - 1));
        return ans.toString();
    }

    //Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] str = data.split(",");
        int size = str.length;
        if (data.isEmpty()) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        int i = 0;
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node != null) {
                if (i + 1 < size) {
                    if (!str[i + 1].equals("null")) {
                        node.left = new TreeNode(Integer.parseInt(str[i + 1]));
                        q.add(node.left);
                    }
                    i++;
                }
                if (i + 1 < size) {
                    if (!str[i + 1].equals("null")) {
                        node.right = new TreeNode(Integer.parseInt(str[i + 1]));
                        q.add(node.right);
                    }
                    i++;
                }
            } else {
                i++;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        SerializeAndDeSerialize serializeAndDeSerialize = new SerializeAndDeSerialize();

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

        System.out.println("Ans is: " + serializeAndDeSerialize.serialize(root));
        TreeNode root2 = serializeAndDeSerialize.deserialize(serializeAndDeSerialize.serialize(root));
        System.out.println();
    }
}
