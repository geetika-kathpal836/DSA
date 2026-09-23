/* Structure of Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}*/

class Solution {
    public void pre(Node root, ArrayList<Integer> arrl){
        if(root==null) return;
        arrl.add(root.data);
        pre(root.left,arrl);
        pre(root.right,arrl);
        
    }
    public ArrayList<Integer> preOrder(Node root) {
        //  code here
        ArrayList<Integer> arrl=new ArrayList<>();
        if(root==null) return arrl;
        pre(root,arrl);
        return arrl;
    }
}