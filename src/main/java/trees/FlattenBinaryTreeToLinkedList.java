package trees;

import recursion.TreeNode;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {

        TreeNode cur = root;
        while(cur != null){

            if(cur.left == null){
                cur = cur.right;
            }else{
                TreeNode pre = cur.left;
                while(pre.right != cur && pre.right != null){
                    pre = pre.right;
                }

                if(pre.right == cur){
                    pre.right = cur.right;
                    cur.right = cur.left;
                    cur.left = null;
                    cur = cur.right;
                }else{
                    pre.right = cur;
                    cur = cur.left;
                }
            }
        }

    }

    public void flattenUsingStack(TreeNode root) {

        if(root == null){
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while(!s.isEmpty()){

            TreeNode node = s.pop();

            if(node.right != null){
                s.push(node.right);
            }

            if(node.left != null){
                s.push(node.left);
            }

            if(!s.isEmpty()){
                node.right = s.peek();
            }
            node.left = null;
        }
    }

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList =
                new FlattenBinaryTreeToLinkedList();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        //flattenBinaryTreeToLinkedList.flatten(root);
        flattenBinaryTreeToLinkedList.flattenUsingStack(root);
        System.out.println();
    }
}
