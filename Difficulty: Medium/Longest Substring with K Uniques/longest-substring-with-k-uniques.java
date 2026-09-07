class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int maxlen=-1;
        int l=0;
        int r=0;
        Map<Character,Integer> mpp=new HashMap<>();
        while(r<s.length()){
            if(mpp.containsKey(s.charAt(r))){
                mpp.put(s.charAt(r),mpp.get(s.charAt(r))+1);
            }else{
                mpp.put(s.charAt(r),1);
            }
            if(mpp.size()>k){
                mpp.put(s.charAt(l),mpp.get(s.charAt(l))-1);
                if(mpp.get(s.charAt(l))==0){
                    mpp.remove(s.charAt(l));
                }
                l++;
            }
            
            if(mpp.size()==k){
                maxlen=Math.max(maxlen,r-l+1);
            }
            r++;
        }
        return maxlen;
    }
    
}