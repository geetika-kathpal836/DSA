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
        int index=0;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> ls=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                ls.add(node.val);
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            if(index%2==0) ans.add(ls);
            else{
                List<Integer> lsnew=new ArrayList<>();
                for(int i=ls.size()-1;i>=0;i--){
                    lsnew.add(ls.get(i));
                }
                ans.add(lsnew);
            }
            index++;
        }
        return ans;
    }
}