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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return solve(root.left,root.right);
    }
    public boolean solve(TreeNode r1, TreeNode r2){
        if(r1==null || r2==null) return r1==r2;
        return (r1.val==r2.val) && solve(r1.left,r2.right) && solve(r1.right,r2.left);
    }
}