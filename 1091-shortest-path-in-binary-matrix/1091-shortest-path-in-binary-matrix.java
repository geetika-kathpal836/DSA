class Tuple{
    int dist;
    int row;
    int col;
    Tuple(int dist, int row, int col){
        this.dist=dist;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0] == 1) return -1;
        int[][] distance=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                distance[i][j]=(int)(1e9);
            }
        }
        distance[0][0]=1;
        Queue<Tuple> q=new LinkedList<>();
        q.offer(new Tuple(1,0,0));
        while(!q.isEmpty()){
            Tuple t=q.poll();
            int d=t.dist;
            int r=t.row;
            int c=t.col;
            if(r== n-1 && c== n-1) return d;
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int nrow=r+i;
                    int ncol=c+j;
                    if(nrow>=0 && nrow< n && ncol>=0 && ncol<n && d+1 < distance[nrow][ncol] && grid[nrow][ncol]==0){
                        distance[nrow][ncol]=d+1;
                        q.offer(new Tuple(d +1 , nrow, ncol));
                    }
                }
            }
        }
        return -1;
    }
}