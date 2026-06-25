class Pair{
    int first;
    int second;
    int third;
    Pair(int first, int second, int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] vis=new int[grid.length][grid[0].length];
        Queue<Pair> q=new LinkedList<>();
        int[] delrow={0,-1,0,1};
        int[] delcol={-1,0,1,0};
        int cntfresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    vis[i][j]=2;
                    q.offer(new Pair(i,j,0));
                }
                else if(grid[i][j]==1){
                    cntfresh++;
                }
            }
        }
        int cntOfFreshTurnedRotten=0;
        int time=0;
        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            int t=q.peek().third;
            q.poll();
            for(int i=0;i<4;i++){
                int nrow=r+delrow[i];
                int ncol=c+delcol[i];
                time=Math.max(time,t);
                if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                    cntOfFreshTurnedRotten++;
                    vis[nrow][ncol]=2;
                    q.offer(new Pair(nrow,ncol,t+1));
                }
            }
        }
        return (cntfresh==cntOfFreshTurnedRotten)?time:-1;
    }
}