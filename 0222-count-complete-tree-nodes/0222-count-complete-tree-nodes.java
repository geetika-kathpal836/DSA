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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int leftheight=leftheight(root);
        int rightheight=rightheight(root);
        if(leftheight==rightheight){
            return (1<<leftheight)-1;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    public int leftheight(TreeNode root){ 
        int c=0;
        TreeNode curr=root;
        while(curr!=null){
            c++;
            curr=curr.left;
        }
        return c;
    }
    public int rightheight(TreeNode root){
        int c=0;
        TreeNode curr=root;
        while(curr!=null){
            c++;
            curr=curr.right;
        }
        return c;
    }
}