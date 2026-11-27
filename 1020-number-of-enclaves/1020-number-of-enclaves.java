class Solution {
    public int numEnclaves(int[][] grid) {
        int[][] visited=new int[grid.length][grid[0].length];
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j]==0 && grid[i][j]==1 && (i==0 || i==grid.length-1 || j==0 || j==grid[0].length-1)){
                    bfs(i,j,visited,grid,delrow,delcol);
                }
            }
        }
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && visited[i][j]==0) count++;
            }
        }
        return count;
    }
    public void bfs(int r, int c, int[][] visited, int[][] grid,int[]delrow, int[] delcol){
        visited[r][c]=1;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(r,c));
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            q.poll();
            for(int i=0;i<4;i++){
                int drow=row+delrow[i];
                int dcol=col+delcol[i];
                if(drow>=0 && drow<grid.length && dcol>=0 && dcol<grid[0].length && visited[drow][dcol]==0 && grid[drow][dcol]==1){
                    q.offer(new Pair(drow,dcol));
                    visited[drow][dcol]=1;
                }
            }
        }
    }
}
class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}