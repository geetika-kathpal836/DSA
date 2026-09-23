/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public void post(Node root, ArrayList<Integer> arrl){
        if(root==null){
            return;
        }
        post(root.left,arrl);
        post(root.right,arrl);
        arrl.add(root.data);
        
    }
    public ArrayList<Integer> postOrder(Node root) {
        // code here
        ArrayList<Integer> arrl=new ArrayList<>();
        if(root==null) return arrl;
        post(root,arrl);
        return arrl;
    }
}