class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] visited=new int[isConnected.length];
        int count=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<isConnected.length;i++){
            if(visited[i]==0){
                count++;
                bfs(q,isConnected,visited,i);
            }
        }
        return count;
    }
    public void bfs(Queue<Integer> q, int[][] isConnected, int[] visited, int vertex){
        visited[vertex]=1;
        q.offer(vertex);
        while(!q.isEmpty()){
            int n=q.poll();
            for(int i=0;i<isConnected[n].length;i++){
                if(visited[i]==0 && isConnected[n][i]==1){
                    q.offer(i);
                    visited[i]=1;
                }
            }
        }
    }
}