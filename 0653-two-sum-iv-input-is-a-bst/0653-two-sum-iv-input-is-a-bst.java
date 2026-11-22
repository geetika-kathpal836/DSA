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
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator bst1=new BSTIterator(root,false);
        BSTIterator bst2=new BSTIterator(root,true);
        int i=bst1.next();
        int j=bst2.next();
        while(i<j){      // since ye in-order dega
            if(i+j==k) return true;
            else if(i+j<k){
                i=bst1.next();
            }else{
                j=bst2.next();
            }
        }
        return false;
    }
}
class BSTIterator{
    Stack<TreeNode> st=new Stack<>();
    boolean reverse;
    public BSTIterator(TreeNode root, boolean isreverse){
        reverse=isreverse;
        if(reverse==false){
            pushAllNormal(root);
        }else{
            pushAllReverse(root);
        }     
    }
    public int next(){
        TreeNode node=st.pop();
        if(reverse==false){
            pushAllNormal(node.right);
        }else{
            pushAllReverse(node.left);
        }
        return node.val;
    }
    public void pushAllNormal(TreeNode root){
        while(root!=null){
            st.push(root);
            root=root.left;
        }
    }
    public void pushAllReverse(TreeNode root){
        while(root!=null){
            st.push(root);
            root=root.right;
        }
    }
}