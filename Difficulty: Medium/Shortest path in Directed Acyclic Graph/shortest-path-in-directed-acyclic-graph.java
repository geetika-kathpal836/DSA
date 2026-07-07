class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            adj.get(u).add(new Pair(v,wt));
        }
        int[] vis=new int[V];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                topo(i,st,adj,vis);
            }
        }
        int[] distance=new int[V];
        for(int i=0;i<distance.length;i++){
            distance[i]=Integer.MAX_VALUE;
        }
        distance[0]=0;
        while(!st.isEmpty()){
            int node=st.pop();
            for(int i=0;i<adj.get(node).size();i++){
              int u=adj.get(node).get(i).first;
              int wt=adj.get(node).get(i).second;
              if(distance[node]!=Integer.MAX_VALUE &&  distance[node]+wt<distance[u]){
                  distance[u]=distance[node]+wt;
              }
            }
        }
        for(int i=0;i<V;i++){
            if(distance[i]==Integer.MAX_VALUE){
                distance[i]=-1;
            }
        }
        return distance;
    }
    public void topo(int node, Stack<Integer> st, ArrayList<ArrayList<Pair>> adj, int[] vis){
        vis[node]=1;
        for(Pair p:adj.get(node)){
            int f=p.first;
            if(vis[f]==0){
                topo(f,st,adj,vis);
            }
        }
        st.add(node);
    }
}