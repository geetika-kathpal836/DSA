class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    count++;
                    dfs(grid,vis,i,j,n,m);
                }
            }
        }
        return count;
    }
    public void dfs(char[][]grid, int[][]vis, int row, int col, int n , int m){
        vis[row][col]=1;
        int[] delrow={0,-1,0,1};
        int[] delcol={-1,0,1,0};
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0){
                dfs(grid,vis,nrow,ncol,n,m);
            }
        }
    }
}