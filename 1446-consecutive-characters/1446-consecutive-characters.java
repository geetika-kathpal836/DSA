class Solution {
    public int maxPower(String s) {
        int maxlen=0;
        HashSet<Character> st=new HashSet<>();
        int l=0;
        int r=0;
        while(r<s.length()){
            if(st.contains(s.charAt(r))){
                maxlen=Math.max(maxlen,r-l+1);
            }else{
                st.clear();
                l=r;
                maxlen=Math.max(maxlen,1);
                st.add(s.charAt(r));
            }
            r++;
        }
        return maxlen;
    }
}