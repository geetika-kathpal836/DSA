class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int shortestPath(int V, int[][] edges, int src, int dest) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] distance=new int[V];
        for(int i=0;i<V;i++){
            distance[i]=Integer.MAX_VALUE;
        }
        distance[src]=0;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(src,0));
        while(!q.isEmpty()){
            int first=q.peek().first;
            int second=q.peek().second;
            q.poll();
            for(int it:adj.get(first)){
                if(distance[first]!=Integer.MAX_VALUE && distance[first]+1<distance[it]){
                    distance[it]=distance[first]+1;
                    q.offer(new Pair(it,distance[it]));
                }
            }
        }
        return (distance[dest]==Integer.MAX_VALUE)?-1:distance[dest];
    }
}