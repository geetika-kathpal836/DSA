class Solution {
    public int numSub(String s) {
        int l=0;
        int r=0;
        long cnt=0;
        while(r<s.length()){
            if(s.charAt(r)=='0'){
                l=r+1;
            }
            else{
                cnt=(cnt+r-l+1)%(1000000007);
            }
            r++;
        }
        return (int)cnt%(1000000007);
    }
}