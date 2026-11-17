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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        boolean even=true;
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer> ls=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.peek();
                q.poll();
                ls.add(node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            if(even){
                ans.add(ls);
                even=false;
            }
            else{
                ArrayList<Integer> rl=new ArrayList<>();
                for(int i=ls.size()-1;i>=0;i--){
                    rl.add(ls.get(i));
                }
                ans.add(rl);
                even=true;
            }
            
        }
        return ans;
    }
}