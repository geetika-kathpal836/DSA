class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> mpp=new HashMap<>();
        int l=0;
        int r=0;
        int maxlen=0;
        while(r<fruits.length){
            if(mpp.containsKey(fruits[r])){
                mpp.put(fruits[r],mpp.get(fruits[r])+1);
            }else{
                mpp.put(fruits[r],1);
            }
            if(mpp.size()>2){
                while(mpp.size()>2){
                    mpp.put(fruits[l],mpp.get(fruits[l])-1);
                    if(mpp.get(fruits[l])==0){
                        mpp.remove(fruits[l]);
                    }
                    l++;
                }
            }
            int len=r-l+1;
            maxlen=Math.max(maxlen,len);
            r++;
        }
        return maxlen;
    }
}