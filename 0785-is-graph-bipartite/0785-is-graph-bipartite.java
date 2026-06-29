class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        for(int i=0;i<n;i++){
            color[i]=-1;
        }
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(dfs(i,0,graph,color)==false) return false;
            }
        }
        return true;
    }
    public boolean dfs(int node,int colo, int[][] graph, int[] color){
        color[node]=colo;
        for(int k=0;k<graph[node].length;k++){
            int val=graph[node][k];
            if(color[val]==-1){
                if(dfs(val,1-colo,graph,color)==false) return false;
            }
            else if(color[val]==color[node]) return false;
        }
        return true;
    }
}