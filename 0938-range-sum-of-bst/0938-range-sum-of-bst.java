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
    public void inorder(TreeNode root,ArrayList<Integer> arrl){
        if(root==null) return;
        inorder(root.left,arrl);
        arrl.add(root.val);
        inorder(root.right,arrl);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        ArrayList<Integer> arrl=new ArrayList<>();
        inorder(root,arrl);
        int sum=0;
        for(int i=0;i<arrl.size();i++){
            if(arrl.get(i)>=low && arrl.get(i)<=high){
                sum+=arrl.get(i);
            }
        }
        return sum;
    }
}