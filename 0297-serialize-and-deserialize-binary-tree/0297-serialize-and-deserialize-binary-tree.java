/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String ans="";
        if(root==null) return "null";
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                ans+="null,";
                continue;
            }
            ans+=node.val +",";
            q.offer(node.left);
            q.offer(node.right);
        }
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="null") return null;
        String[] arr=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
        int i=1;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty() && i<arr.length){
            TreeNode node=q.poll();
            if(!arr[i].equals("null")){
                node.left=new TreeNode(Integer.parseInt(arr[i]));
                q.offer(node.left);
            }
            i++;
            if(!arr[i].equals("null")){
                node.right=new TreeNode(Integer.parseInt(arr[i]));
                q.offer(node.right);
            }
            i++;
        }        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));