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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<>();
        ArrayList<Integer> sb=new ArrayList<>();
        List<ArrayList<Integer>> arrl=new ArrayList<>();
        solve(root,sb,arrl);
        for(ArrayList<Integer> a: arrl){
            String s="";
            for(int i=0;i<a.size();i++){
                if(i!=a.size()-1){
                    s+=a.get(i);
                    s+="->";
                }
                else{
                    s+=a.get(i);
                }
            }
            ans.add(s);
        }
        return ans;
    }
    public boolean isLeaf(TreeNode root){
        if(root.left==null && root.right==null) return true;
        return false;
    }
    public void solve(TreeNode root, ArrayList<Integer> sb, List<ArrayList<Integer>> arrl){
        if(root==null) return;
        sb.add(root.val);
        if(isLeaf(root)){
            arrl.add(new ArrayList<Integer>(sb));
            sb.remove(sb.size()-1);
            return;
        }
        solve(root.left,sb,arrl);
        solve(root.right,sb,arrl);
        sb.remove(sb.size()-1);
    }
}