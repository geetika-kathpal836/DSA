class Pair{
    long dist;
    int node;
    Pair(long dist, int node){
        this.dist=dist;
        this.node=node;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<roads.length;i++){
            int node=roads[i][0];
            int neighnode=roads[i][1];
            long dist=roads[i][2];
            adj.get(node).add(new Pair(dist,neighnode));
            adj.get(neighnode).add(new Pair(dist,node));
        }
        long[] distance=new long[n];
        int[] ways=new int[n];
        Arrays.fill(distance,Long.MAX_VALUE);
        for(int i=0;i<n;i++){
            ways[i]=0;
        }
        distance[0]=0;
        ways[0]=1;
        int mod=(int)(1e9+7);
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->Long.compare(x.dist,y.dist));
        pq.offer(new Pair(0,0));
        while(pq.size()!=0){
            Pair p=pq.poll();
            long dis=p.dist;
            int nod=p.node;
            for(int i=0;i<adj.get(nod).size();i++){
                Pair p2=adj.get(nod).get(i);
                long edW=p2.dist;
                int adjNode=p2.node;
                if(dis+edW<distance[adjNode]){
                    distance[adjNode]=dis+edW;
                    ways[adjNode]=ways[nod];
                    pq.offer(new Pair(distance[adjNode],adjNode));
                }
                else if(dis+edW==distance[adjNode]){
                    ways[adjNode]=(ways[adjNode]+ways[nod])%mod;
                }
            }
        }
        return ways[n-1]%mod;
    }
}