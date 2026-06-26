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
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] ans=new int[n][m];
        int[][] vis=new int[n][m];
        int[] delrow={0,-1,0,1};
        int[] delcol={-1,0,1,0};
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.offer(new Pair(i,j,0));
                    vis[i][j]=1;
                }
            }
        }
        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            int dist=q.peek().third;
            q.poll();
            ans[r][c]=dist;
            for(int i=0;i<4;i++){
                int nrow=r+delrow[i];
                int ncol=c+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0){
                    q.offer(new Pair(nrow,ncol,dist+1));
                    vis[nrow][ncol]=1;
                }
            }
        }
        return ans;
    }
}