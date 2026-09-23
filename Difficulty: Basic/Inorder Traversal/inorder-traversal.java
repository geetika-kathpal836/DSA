/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
}*/

class Solution {
    public void in(Node root, ArrayList<Integer> arrl){
        if(root==null) return;
        in(root.left,arrl);
        arrl.add(root.data);
        in(root.right,arrl);
    }
    public ArrayList<Integer> inOrder(Node root) {
        // code here
        ArrayList<Integer> arrl=new ArrayList<>();
        if(root==null) return arrl;
        in(root,arrl);
        return arrl;
        
    }
}