package trees;

import recursion.TreeNode;

public class MaxSumBST {

    public int maxSumBST(TreeNode root) {

        int[] maxSum = {0};
        helper(root,maxSum);
        return maxSum[0];
    }

    class Tuple {
        int sum;
        int min;
        int max;

        Tuple(int sum, int min, int max) {
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }

    private Tuple helper(TreeNode root, int[] maxSum) {

        if (root == null) {
            return new Tuple(0, Integer.MAX_VALUE,Integer.MIN_VALUE);
        }

        Tuple left = helper(root.left, maxSum);
        Tuple right = helper(root.right, maxSum);


        if (left.max < root.val && root.val < right.min) {
            int sum = root.val + left.sum + right.sum;
            if(sum > maxSum[0]){
                maxSum[0] = sum;
            }
            int min = Math.min(left.min, root.val);
            int max = Math.max(right.max, root.val);
            return new Tuple(sum, min, max);
        }

        return new Tuple(Math.max(left.sum, right.sum), Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    public static void main(String[] args) {

        SerializeAndDeSerialize serializeAndDeSerialize = new SerializeAndDeSerialize();
        TreeNode root = serializeAndDeSerialize.
                deserialize(new String("4,8,null,6,1,9,null,-5,4,null,null,null,-3,null,10"));
        MaxSumBST maxSumBST = new MaxSumBST();
        System.out.println("ANs is: " + maxSumBST.maxSumBST(root));
    }
}
