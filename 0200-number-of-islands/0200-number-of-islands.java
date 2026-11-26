class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        int[][] visited=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j]==0 && grid[i][j]=='1'){
                    count++;
                    dfs(visited,grid,i,j);
                }
            }
        }
        return count;
    }
    public void dfs(int[][] visited, char[][] grid, int i, int j){
        visited[i][j]=1;
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        for(int k=0;k<4;k++){
            int nrow=i+delrow[k];
            int ncol=j+delcol[k];
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && visited[nrow][ncol]==0 && grid[nrow][ncol]=='1'){
                dfs(visited,grid,nrow,ncol);
            }
        }
        // for(int row=-1;row<=1;row++){
        //     for(int col=-1;col<=1;col++){
        //         int nrow=i+row;
        //         int ncol=j+col;
        //         if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && visited[nrow][ncol]==0 && grid[nrow][ncol]=='1'){
        //             dfs(visited,grid,nrow,ncol);
        //         }
        //     }        
        // }
    }
}