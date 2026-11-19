/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void Parent_track(TreeNode root, HashMap<TreeNode,TreeNode> mpp){
        if(root==null) return;
        mpp.put(root,null);
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node.left!=null){
                mpp.put(node.left,node);
                q.offer(node.left);
            }
            if(node.right!=null){
                mpp.put(node.right,node);
                q.offer(node.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans=new LinkedList<>();
        HashMap<TreeNode, TreeNode> parent_track=new HashMap<>();
        Parent_track(root,parent_track);
        HashMap<TreeNode, Boolean> visited=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(target);
        visited.put(target,true);
        int dis=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(dis==k) break;
            dis++;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null && visited.get(node.left)==null){
                    q.offer(node.left);
                    visited.put(node.left,true);
                }
                if(node.right!=null && visited.get(node.right)==null){
                    q.offer(node.right);
                    visited.put(node.right,true);
                }
                if(parent_track.get(node)!=null && visited.get(parent_track.get(node))==null){
                    q.offer(parent_track.get(node));
                    visited.put(parent_track.get(node),true);
                }
            }
        }
        List<Integer> ls=new LinkedList<>();
        while(!q.isEmpty()){
            ls.add(q.peek().val);
            q.poll();
        }
        return ls;
    }
}