class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        for(int i=0;i<n;i++){
            color[i]=-1;
        }
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(bfs(i,graph,color)==false) return false;
            }
        }
        return true;
    }
    public boolean bfs(int node, int[][] graph, int[] color){
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        color[node]=0;
        while(!q.isEmpty()){
            node=q.poll();
            for(int k=0;k<graph[node].length;k++){
                int val=graph[node][k];
                if(color[val]==-1){
                    color[val]=1-color[node];
                    q.add(val);
                }
                else if(color[val]==color[node]) return false;
            }
        }
        return true;
    }
}