class Tuple{
    int diff;
    int row;
    int col;
    Tuple(int diff, int row, int col){
        this.diff=diff;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int[] drow={0,-1,0,1};
        int[] dcol={-1,0,1,0};
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)(1e9);
            }
        }
        dist[0][0]=0;
        PriorityQueue<Tuple> pq=new PriorityQueue<>((x,y)-> x.diff - y.diff);
        pq.offer(new Tuple(0,0,0));
        while(!pq.isEmpty()){
            Tuple t=pq.poll();
            int diff=t.diff;
            int r=t.row;
            int c=t.col;
            if(r==n-1 && c==m-1) return diff;
            for(int i=0;i<4;i++){
                int nrow=r+drow[i];
                int ncol=c+dcol[i];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m){
                    int newEffort=Math.max(diff,Math.abs(heights[r][c] - heights[nrow][ncol]));
                    if(newEffort < dist[nrow][ncol]){
                        dist[nrow][ncol]=newEffort;
                        pq.offer(new Tuple(newEffort,nrow,ncol));
                    }
                }
            }
        }
        return -1;
    }
}