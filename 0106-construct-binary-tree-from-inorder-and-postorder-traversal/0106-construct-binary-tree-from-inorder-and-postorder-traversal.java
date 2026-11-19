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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mpp.put(inorder[i],i);
        }
        TreeNode root=build(postorder,0,postorder.length-1,inorder,0,inorder.length-1,mpp);
        return root;
    }
    public TreeNode build(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer,Integer> mpp){
        if(postStart>postEnd || inStart>inEnd) return null;
        TreeNode root=new TreeNode(postorder[postEnd]);
        int inroot=mpp.get(root.val);
        int numberofcomponentsatleft=inroot-inStart;
        root.left=build(postorder,postStart,postStart+numberofcomponentsatleft-1,inorder,inStart,inroot-1,mpp);
        root.right=build(postorder,postStart+numberofcomponentsatleft,postEnd-1,inorder,inroot+1,inEnd,mpp);
        return root;
    }
}