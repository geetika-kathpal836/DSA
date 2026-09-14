class Solution {
    public int countGoodSubstrings(String s) {
        if(s.length()<3){
            return 0;
        }
        int cnt=0;
        int size=s.length();
        for(int i=0;i<=size-3;i++){
            HashSet<Character> st=new HashSet<>();
            String str=s.substring(i,i+3);
            for(int j=0;j<3;j++){
                st.add(str.charAt(j));
            }
            if(st.size()==3){
                cnt+=1;
            }
        }
        return cnt;
    }
}