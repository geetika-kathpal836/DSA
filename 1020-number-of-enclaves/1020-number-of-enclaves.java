class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int[] delrow={0,-1,0,1};
        int[] delcol={-1,0,1,0};
        for(int i=0;i<n;i++){
            if(grid[i][0]==1 && vis[i][0]==0){
                dfs(i,0,n,m,vis,grid,delrow,delcol);
            }
        }
        for(int i=0;i<n;i++){
            if(grid[i][m-1]==1 && vis[i][m-1]==0){
                dfs(i,m-1,n,m,vis,grid,delrow,delcol);
            }
        }
        for(int j=0;j<m;j++){
            if(grid[0][j]==1 && vis[0][j]==0){
                dfs(0,j,n,m,vis,grid,delrow,delcol);
            }
        }
        for(int j=0;j<m;j++){
            if(grid[n-1][j]==1 && vis[n-1][j]==0){
                dfs(n-1,j,n,m,vis,grid,delrow,delcol);
            }
        }
        int total1=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    total1++;
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==1){
                    count++;
                }
            }
        }
        return total1-count;
    }
    public void dfs(int row,int col, int n, int m, int[][] vis, int[][] grid, int[] delrow, int[] delcol){
        vis[row][col]=1;
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                dfs(nrow,ncol,n,m,vis,grid,delrow,delcol);
            }
        }
    }
}