package trees;

import recursion.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        parent.put(root,null);

        while(!(parent.containsKey(p) && parent.containsKey(q))){
            TreeNode node = queue.poll();

            if(node.left != null){
                queue.add(node.left);
                parent.put(node.left,node);
            }
            if(node.right != null){
                queue.add(node.right);
                parent.put(node.right,node);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();
        while(p != null){
            ancestors.add(p);
            p = parent.get(p);
        }

        while(!ancestors.contains(q)){
            q = parent.get(q);
        }
        return q;
    }

    public static void main(String[] args){
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.println("Ans is: " + lowestCommonAncestor.lowestCommonAncestor(root,root.left,root.left.right.right).val);
    }
}
