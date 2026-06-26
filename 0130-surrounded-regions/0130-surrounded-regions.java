class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] vis=new int[n][m];
        int[] delrow={0,-1,0,1};
        int[] delcol={-1,0,1,0};
        //first row
        for(int j=0;j<m;j++){
            if(board[0][j]=='O' && vis[0][j]==0){
                dfs(board,vis,n,m,0,j,delrow,delcol);
            }
        }
        //last row
        for(int j=0;j<m;j++){
            if(board[n-1][j]=='O' && vis[n-1][j]==0){
                dfs(board,vis,n,m,n-1,j,delrow,delcol);
            }
        }
        //first col
        for(int i=0;i<n;i++){
            if(board[i][0]=='O' && vis[i][0]==0){
                dfs(board,vis,n,m,i,0,delrow,delcol);
            }
        }
        //last col
        for(int i=0;i<n;i++){
            if(board[i][m-1]=='O' && vis[i][m-1]==0){
                dfs(board,vis,n,m,i,m-1,delrow,delcol);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
    public void dfs(char[][] board, int[][] vis, int n , int m , int row, int col,int[] delrow, int[] delcol){
        vis[row][col]=1;
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && board[nrow][ncol]=='O' && vis[nrow][ncol]==0){
                dfs(board,vis,n,m,nrow,ncol,delrow,delcol);
            }
        }
    }
}