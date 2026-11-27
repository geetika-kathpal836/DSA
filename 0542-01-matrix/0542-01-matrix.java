class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] visited=new int[mat.length][mat[0].length];
        for(int i=0;i<visited.length;i++){
            for(int j=0;j<visited[0].length;j++){
                visited[i][j]=-1;
            }
        }
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    q.offer(new Pair(i,j,0));
                    visited[i][j]=0;
                }
            }
        }
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int d=q.peek().dist;
            q.poll();
            for(int i=0;i<4;i++){
                int nrow=r+delrow[i];
                int ncol=c+delcol[i];
                if(nrow>=0 && nrow<mat.length && ncol>=0 && ncol<mat[0].length && visited[nrow][ncol]==-1 && mat[nrow][ncol]==1){
                    q.offer(new Pair(nrow,ncol,d+1));
                    visited[nrow][ncol]=d+1;
                }
            }
        }
        return visited;
    }
}
class Pair{
    int row;
    int col;
    int dist;
    Pair(int row, int col,int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}