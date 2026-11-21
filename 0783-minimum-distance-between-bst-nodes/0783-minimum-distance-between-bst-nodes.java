/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void inorder(TreeNode root,TreeNode[] prev, int[] minDifference){
        if(root==null) return;
        inorder(root.left,prev,minDifference);
        if(prev[0]!=null){
            minDifference[0]=Math.min(minDifference[0],Math.abs(root.val-prev[0].val));
        }
        prev[0]=root;
        inorder(root.right,prev, minDifference);
    }
    public int minDiffInBST(TreeNode root) {
        TreeNode[] prev={null};
        int[] minDifference={Integer.MAX_VALUE};
        inorder(root,prev,minDifference);
        return minDifference[0];
    }
}