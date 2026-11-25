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
    public int kthSmallest(TreeNode root, int k) {
        //brute force is inorder ko save krlo arraylist mein and then kth smallest by looping 
        int[] res={-1};
        int[] count={0};
        solve(root,k,count,res);
        return res[0];
    }
    public void solve(TreeNode root,int k, int[] count, int[] res){
        if(root==null) return;
        solve(root.left,k,count,res);
        count[0]++;
        if(count[0]==k){
            res[0]=root.val;
            return;
        }
        solve(root.right,k,count,res);
    }
}