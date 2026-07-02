class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        //Using DFS
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
        }
        Stack<Integer> st=new Stack<>();
        int[] vis=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,st,adj,vis);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }
    public void dfs(int node, Stack<Integer> st,ArrayList<ArrayList<Integer>> adj,int[] vis ){
        vis[node]=1;
        for(int it:adj.get(node)){
            if(vis[it]==0){
                dfs(it,st,adj,vis);
            }
        }
        st.add(node);
    }
}