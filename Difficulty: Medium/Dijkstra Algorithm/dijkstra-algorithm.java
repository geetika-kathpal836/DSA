class Pair{
    int distance;
    int node;
    Pair(int distance, int node){
        this.distance=distance;
        this.node=node;
    }
}
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Pair>>arrl=new ArrayList<>();
        for(int i=0;i<V;i++){
            arrl.add(new ArrayList<Pair>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            arrl.get(u).add(new Pair(wt,v));
            arrl.get(v).add(new Pair(wt,u));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((a,b) ->{
            if(a.distance == b.distance) return a.node-b.node;
            return a.distance-b.distance;
        });
        int[] distance=new int[V];
        for(int i=0;i<V;i++){
            distance[i]=(int)(1e9);
        }
        distance[src]=0;
        pq.offer(new Pair(0,src));
        while(!pq.isEmpty()){
            int dist=pq.peek().distance;
            int nd=pq.peek().node;
            pq.poll();
            for(int i=0;i<arrl.get(nd).size();i++){
                Pair p=arrl.get(nd).get(i);
                int dist2=p.distance;
                int node2=p.node;
                if(dist+dist2 < distance[node2]){
                    distance[node2]=dist+dist2;
                    pq.offer(new Pair(distance[node2],node2));
                }
            }
        }
        for(int i=0;i<V;i++){
            if(distance[i]==1e9){
                distance[i]=-1;
            }
        }
        return distance;
    }
}