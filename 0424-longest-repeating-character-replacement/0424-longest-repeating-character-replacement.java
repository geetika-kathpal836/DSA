class Solution {
    public int characterReplacement(String s, int k) {
        int[] hash=new int[26];
        int l=0;
        int r=0;
        int maxlen=0;
        int maxf=0;
        while(r<s.length()){
            hash[s.charAt(r)-'A']++;
            maxf=Math.max(maxf,hash[s.charAt(r)-'A']);
            while(r-l+1-maxf>k){
                hash[s.charAt(l)-'A']--;
                l++;
                maxf=0;
                for(int i=0;i<25;i++){
                    maxf=Math.max(maxf,hash[i]);
                }
            }
            maxlen=Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
}