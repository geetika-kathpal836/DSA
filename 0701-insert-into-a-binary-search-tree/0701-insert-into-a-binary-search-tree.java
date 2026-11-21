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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node=new TreeNode(val);
        if(root==null) return node;
        TreeNode dummyroot=root;
        TreeNode prev=null;
        while(root!=null){
            if(root.val>val){
                prev=root;
                root=root.left;
            }else{
                prev=root;
                root=root.right;
            }
        }
        if(prev.val>val){
            prev.left=node;
        }
        else{
            prev.right=node;
        }
        return dummyroot;
    }
}