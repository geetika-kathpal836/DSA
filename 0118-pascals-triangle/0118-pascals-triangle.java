class Solution {
    public List<List<Integer>> generate(int numrows) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<numrows;i++){
            List<Integer> lis=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    lis.add(1);
                }
                else{
                    lis.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
                }
            }
            ans.add(lis);
        }
        return ans;
    }
}