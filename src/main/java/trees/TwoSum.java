package trees;

import recursion.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TwoSum {

    public boolean findTarget(TreeNode root, int k) {

        BSTIterator b1 = new BSTIterator(root,false);
        BSTIterator b2 = new BSTIterator(root,true);

        int left = b1.next(),right = b2.next();
        System.out.println( left + "," + right);
        while(left < right){

            if(left+right == k){
                return true;
            }else if(left+right > k){
                right = b2.next();
            }else{
                left = b1.next();
            }
        }

        return false;
    }

    public class BSTIterator{
        Stack<TreeNode> s = new Stack<>();
        boolean reverse;

        BSTIterator(TreeNode root,boolean reverse){
            this.reverse = reverse;
            pushAll(root);
        }

        private void pushAll(TreeNode r){

            while(r != null){

                s.push(r);
                if(reverse){
                    r = r.right;
                }else{
                    r = r.left;
                }
            }
        }

        public boolean hasNext(){

            return !s.isEmpty();
        }

        public int next(){

            if(!s.isEmpty()){

                TreeNode node = s.pop();
                if(reverse){
                    pushAll(node.left);
                }else{
                    pushAll(node.right);
                }
                return node.val;
            }
            return -1;
        }
    }

    private boolean bruteForce(TreeNode root, int k){
        List<Integer> list = new ArrayList<>();
        inorder(root,list);

        int size = list.size();

        int first = 0,last = size-1;
        while(first < last){

            if(list.get(first) + list.get(last) == k){
                return true;
            }else if(list.get(first) + list.get(last) > k){
                last--;
            }else{
                first++;
            }
        }
        return false;
    }
    private void inorder(TreeNode root,List<Integer> list){

        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;

        while(!s.isEmpty() || cur != null){

            if(cur != null){
                s.push(cur);
                cur = cur.left;
            }else{
                cur = s.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
    }

    public static void main(String[] args){

        TwoSum twoSum = new TwoSum();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        boolean result = twoSum.findTarget(root,9);
        System.out.println();
    }
}
