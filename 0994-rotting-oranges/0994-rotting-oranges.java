class Solution {
    public int orangesRotting(int[][] grid) {
        int counttime=0;
        int[] dr={-1,0,+1,0};
        int[] dc={0,1,0,-1};
        int[][] finalarr=grid;
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j,0));
                }
            }
        }
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int time=q.peek().time;
            counttime=Math.max(time,counttime);
            q.poll();
            for(int i=0;i<4;i++){
                int nrow=r+dr[i];
                int ncol=c+dc[i];
                if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]==1 && finalarr[nrow][ncol]!=2){
                    q.offer(new Pair(nrow,ncol,time+1));
                    finalarr[nrow][ncol]=2;
                }
            }
        }
        for(int i=0;i<finalarr.length;i++){
            for(int j=0;j<finalarr[0].length;j++){
                if(finalarr[i][j]==1) return -1;
            }
        }
        return counttime;
    }
}
class Pair{
    int row;
    int col;
    int time;
    Pair(int row, int col, int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}