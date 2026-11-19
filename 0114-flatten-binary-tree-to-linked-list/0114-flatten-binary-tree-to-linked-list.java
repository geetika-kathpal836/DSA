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
    public void preorder(TreeNode root, ArrayList<Integer> arrl){
        if(root==null) return;
        arrl.add(root.val);
        preorder(root.left,arrl);
        preorder(root.right,arrl);
    }
    public void flatten(TreeNode root) {
        if(root==null) return;
        ArrayList<Integer> arrl=new ArrayList<>();
        preorder(root,arrl);
        root.left=null;
        root.right=null;
        TreeNode curr=root;
        if(arrl.size()>1){
            for(int i=0;i<arrl.size()-1;i++){
                TreeNode newnode=new TreeNode(arrl.get(i+1));
                curr.left=null;
                curr.right=newnode;
                curr=newnode;
            }
        }
    }
}