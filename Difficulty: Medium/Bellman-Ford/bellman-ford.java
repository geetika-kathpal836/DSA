class Pair{
    int dist;
    int node;
    Pair(int dist, int node){
        this.dist=dist;
        this.node=node;
    }
}
class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        
        int[] distance=new int[V];
        Arrays.fill(distance,(int)(1e8));
        distance[src]=0;
        for(int i=0;i<V-1;i++){
    for(int[] edge:edges){
        int u=edge[0];
        int v=edge[1];
        int wt=edge[2];

        if(distance[u]!=(int)1e8 &&
           distance[u]+wt<distance[v]){
            distance[v]=distance[u]+wt;
        }
    }
}
        
        for(int[] it:edges){
            int u=it[0];
            int v=it[1];
            int wt=it[2];
            if(distance[u]!=(int)(1e8) && distance[u]+wt<distance[v]){
                int[] temp=new int[1];
                temp[0]=-1;
                return temp;
            }
        }
        
        return distance;
    }
}
