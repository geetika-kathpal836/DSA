class Solution {
    public int countHomogenous(String s) {
        long cnt=0;
        int l=0;
        int r=0;
        HashSet<Character> st=new HashSet<>();
        while(r<s.length()){
            if(st.contains(s.charAt(r))){
                cnt+=(r-l+1)%1000000007;
            }
            else{
                st.clear();
                l=r;
                st.add(s.charAt(r));
                cnt=(cnt+1)%1000000007;
            
            }
            r++;
        }
        return (int)(cnt%1000000007);
    }
}