class Solution {
    public void floydWarshall(int[][] dist) {
        // Code here
        for(int k=0;k<dist.length;k++){
            for(int i=0;i<dist.length;i++){
                for(int j=0;j<dist.length;j++){
                    if(dist[i][k]==1e8 || dist[k][j]==1e8) continue;
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
    }
}