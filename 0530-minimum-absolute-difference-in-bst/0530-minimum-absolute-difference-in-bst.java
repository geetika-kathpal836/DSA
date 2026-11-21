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
    public int getMinimumDifference(TreeNode root) {
        TreeNode[] prev={null};
        int[] mindiff={Integer.MAX_VALUE};
        inorder(root,prev,mindiff);
        return mindiff[0];
    }
    public void inorder(TreeNode root,TreeNode[] prev, int[] mindiff){
        if(root==null) return;
        inorder(root.left,prev,mindiff);
        if(prev[0]!=null){
            mindiff[0]=Math.min(mindiff[0],root.val-prev[0].val);
        }
        prev[0]=root;
        inorder(root.right,prev,mindiff);
    }
}