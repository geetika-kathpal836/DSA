class Pair{
    int node;
    int cost;
    Pair(int node, int cost){
        this.node=node;
        this.cost=cost;
    }
}
class Tuple{
    int first;
    int second;
    int third;
    Tuple(int first, int second, int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> arrl=new ArrayList<>();
        for(int i=0;i<n;i++){
            arrl.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int cost=flights[i][2];
            arrl.get(u).add(new Pair(v,cost));
        }
        PriorityQueue<Tuple> pq=new PriorityQueue<Tuple>((x,y) -> x.first - y.first);
        int[] distance=new int[n];
        for(int i=0;i<n;i++){
            distance[i]=(int)(1e9);
        }
        distance[src]=0;
        pq.offer(new Tuple(0,src,0));    //stops, distance, distance
        while(!pq.isEmpty()){
            Tuple t=pq.poll();
            int stops=t.first;
            int node=t.second;
            int cost=t.third;
            if(stops>k) continue;
            for(int i=0;i<arrl.get(node).size();i++){
                Pair p=arrl.get(node).get(i);
                int adjNode=p.node;
                int edW=p.cost;
                if(cost+edW < distance[adjNode]){
                    distance[adjNode]=cost + edW;
                    pq.offer(new Tuple(stops+1,adjNode,cost+edW));
                }
            }
        }
        if(distance[dst]==(int)(1e9)){
            return -1;
        } 
        return distance[dst];
    }
}