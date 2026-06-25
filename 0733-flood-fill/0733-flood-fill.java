class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans=image;
        Queue<Pair> q=new LinkedList<>();
        int inicolor=image[sr][sc];
        ans[sr][sc]=color;
        q.offer(new Pair(sr,sc));
        int[] delrow={0,-1,0,1};
        int[] delcol={-1,0,1,0};
        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            q.poll();
            for(int i=0;i<4;i++){
                int nrow=r+delrow[i];
                int ncol=c+delcol[i];
                if(nrow>=0 && nrow<image.length && ncol>=0 && ncol<image[0].length && image[nrow][ncol]==inicolor && ans[nrow][ncol]!=color){
                    ans[nrow][ncol]=color;
                    q.offer(new Pair(nrow,ncol));
                }
            }
        }
        return ans;
    }
}