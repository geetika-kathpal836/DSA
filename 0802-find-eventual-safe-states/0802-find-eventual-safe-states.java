class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] vis=new int[graph.length];
        int[] pathvis=new int[graph.length];
        int[] check=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(vis[i]==0){
                dfscheck(i,vis,pathvis,check,graph);
            }
        }
        List<Integer> safenodes=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            if(check[i]==1){
                safenodes.add(i);
            }
        }
        return safenodes;
    }
    private boolean dfscheck(int node, int[]vis, int[] pathvis, int[] check,int[][] graph){
        vis[node]=1;
        pathvis[node]=1;
        check[node]=0;
        for(int it:graph[node]){
            if(vis[it]==0){
                if(dfscheck(it,vis,pathvis,check,graph)==true) return true;
            }
            else if(pathvis[it]==1) return true;
        }
        check[node]=1;
        pathvis[node]=0;
        return false;
    }
}