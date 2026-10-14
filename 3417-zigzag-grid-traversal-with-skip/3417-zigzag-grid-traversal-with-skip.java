class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> ls=new ArrayList<>();
        boolean taken=false;
        for(int i=0;i<grid.length;i++){
            if(i%2==0){
                for(int j=0;j<grid[i].length;j++){
                    if(taken==false){
                        ls.add(grid[i][j]);
                        taken=true;
                    }else{
                        taken=false;
                    }
                }
            }else{
                for(int j=grid[i].length-1;j>=0;j--){
                    if(taken==false){
                        ls.add(grid[i][j]);
                        taken=true;
                    }else{
                        taken=false;
                    }
                }
            }
        }
        return ls;
    }
}