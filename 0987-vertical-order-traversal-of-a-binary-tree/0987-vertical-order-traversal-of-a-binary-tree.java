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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<Pair> q=new LinkedList<>();
        TreeMap<Integer,List<Integer>> mpp=new TreeMap<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            TreeMap<Integer,List<Integer>> tmpp=new TreeMap<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.peek().node;
                int index=q.peek().index;
                q.poll();
                if(tmpp.containsKey(index)){
                    List<Integer> l=tmpp.get(index);
                    l.add(node.val);
                    tmpp.put(index,l);
                }else{
                    tmpp.put(index,new ArrayList<>());
                    List<Integer> l=tmpp.get(index);
                    l.add(node.val);
                    tmpp.put(index,l);
                }
                if(node.left!=null){
                    q.offer(new Pair(node.left,index-1));
                }
                if(node.right!=null){
                    q.offer(new Pair(node.right,index+1));
                }
            }
            for(Map.Entry<Integer,List<Integer>> it:tmpp.entrySet()){
                List<Integer> l=it.getValue();
                Collections.sort(l);
                if(mpp.containsKey(it.getKey())){
                    List<Integer> templs=mpp.get(it.getKey());
                    for(int i:l){
                        templs.add(i);
                    }
                    mpp.put(it.getKey(),templs);
                }else{
                    mpp.put(it.getKey(),new ArrayList<Integer>());
                    List<Integer> templs=mpp.get(it.getKey());
                    for(int i:l){
                        templs.add(i);
                    }
                    mpp.put(it.getKey(),templs);
                }

            }
        }
        ans.addAll(mpp.values());
        return ans;

    }
}
class Pair{
    TreeNode node;
    int index;
    Pair(TreeNode node, int index){
        this.node=node;
        this.index=index;
    }
}