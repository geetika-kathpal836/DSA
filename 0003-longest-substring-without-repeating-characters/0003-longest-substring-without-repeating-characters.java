class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen=0;
        int l=0;
        int r=0;
        int[] hash=new int[256];
        Arrays.fill(hash,-1);
        while(r<s.length()){
            if(hash[s.charAt(r)]!=-1){
                if(hash[s.charAt(r)]>=l){
                    l=hash[s.charAt(r)]+1;
                }
            }
            int len=r-l+1;
            maxlen=Math.max(maxlen,len);
            hash[s.charAt(r)]=r;
            r++;
        }
        return maxlen;
    }
}