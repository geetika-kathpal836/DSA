class Solution {
    public int countDistinctIslands(char[][] grid) {
        // code here
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        HashSet<ArrayList<String>> hs=new HashSet<>();
        int[] delrow={0,-1,0,1};
        int[] delcol={-1,0,1,0};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]=='L'){
                    ArrayList<String> arrl=new ArrayList<>();
                    dfs(i,j,i,j,vis,grid,arrl,delrow,delcol);
                    hs.add(arrl);
                }
            }
        }
        return hs.size();
    }
    private String toString(int r, int c){
        return Integer.toString(r) + " " + Integer.toString(c);
    }
    public void dfs(int row, int col, int rowbase, int colbase, int[][] vis, char[][] grid, ArrayList<String> arrl,int[] delrow, int[] delcol){
        int n=grid.length;
        int m=grid[0].length;
        vis[row][col]=1;
        arrl.add(toString(row-rowbase,col-colbase));
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]=='L'){
                dfs(nrow,ncol,rowbase,colbase,vis,grid,arrl,delrow,delcol);
            }
        }
    }
}