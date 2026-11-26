class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[] dr={-1,0,+1,0};
        int[] dc={0,+1,0,-1};
        int[][] ans=image;
        int inicolor=image[sr][sc];
        dfs(image,sr,sc,color,dr,dc,ans,inicolor);
        return ans;
    }
    public void dfs(int[][] image, int sr, int sc, int color, int[] dr, int[] dc, int[][] ans,int initialcolor){
        ans[sr][sc]=color;
        for(int i=0;i<4;i++){
            int nrow=sr+dr[i];
            int ncol=sc+dc[i];
            if(nrow>=0 && nrow<image.length && ncol>=0 && ncol<image[0].length && image[nrow][ncol]==initialcolor && ans[nrow][ncol]!=color){
                dfs(image,nrow,ncol,color,dr,dc,ans,initialcolor);
            }
        }
    }
}