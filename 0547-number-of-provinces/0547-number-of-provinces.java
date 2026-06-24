class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] vis=new int[isConnected.length];
        int count=0;
        for(int i=0;i<vis.length;i++){
            if(vis[i]==0){
                count++;
                bfs(isConnected,vis,i);
            }
        }
        return count;
    }
    public void bfs(int[][] isConnected,int[] vis,int node){
        vis[node]=1;
        Queue<Integer> q=new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            Integer newnode=q.poll();
            for(int i=0;i<isConnected[newnode].length;i++){
                if(isConnected[newnode][i]==1 && vis[i]==0){
                    vis[i]=1;
                    q.offer(i);
                }
            }
        }
    }
}