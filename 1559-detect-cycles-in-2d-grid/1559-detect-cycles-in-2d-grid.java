class Pair{
    int first;
    int second;
    int third;
    int fourth;
    Pair(int first, int second,int third,int fourth){
        this.first=first;
        this.second=second;
        this.third=third;
        this.fourth=fourth;
    }
}
class Solution {
    public boolean containsCycle(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int delrow[]={0,-1,0,1};
        int delcol[]={-1,0,1,0};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0){
                    if(bfs(i,j,vis,grid,grid[i][j],delrow,delcol)==true) return true;
                }
            }
        }
        return false;
    }
    public boolean bfs(int row, int col, int[][] vis, char[][] grid, char ch,int[] delrow, int[] delcol){
        int n=grid.length;
        int m=grid[0].length;
        vis[row][col]=1;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(row,col,-1,-1));
        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            int pr=q.peek().third;
            int pc=q.peek().fourth;
            q.poll();
            for(int i=0;i<4;i++){
                int nrow=r+delrow[i];
                int ncol=c+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==ch){
                    if(vis[nrow][ncol]==0){
                        vis[nrow][ncol]=1;
                        q.offer(new Pair(nrow,ncol,r,c));
                    }
                    else{
                        if(nrow==pr && ncol==pc) continue;
                        else{
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}