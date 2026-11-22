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
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] i={0};
        return constructbst(preorder,Integer.MAX_VALUE,i);
    }
    public TreeNode constructbst(int[] preorder, int ub, int[] i){
        if(i[0]==preorder.length || preorder[i[0]]>ub) return null;
        TreeNode node=new TreeNode(preorder[i[0]++]);
        node.left=constructbst(preorder,node.val,i);
        node.right=constructbst(preorder,ub,i);
        return node;
    }
}