class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ls=new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            List<Integer> lis=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    lis.add(1);
                }else{
                    lis.add(ls.get(i-1).get(j-1) + ls.get(i-1).get(j));
                }
            }
            ls.add(lis);
        }
        return ls.get(ls.size()-1);
    }
}